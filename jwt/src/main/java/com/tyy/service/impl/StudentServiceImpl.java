package com.tyy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyy.entity.LoginUser;
import com.tyy.util.RedisUtil;
import com.tyy.util.TokenUtil;
import com.tyy.entity.LoginBody;
import com.tyy.entity.RespBean;
import com.tyy.entity.Student;
import com.tyy.mapper.StudentMapper;
import com.tyy.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tyy
 * @since 2021-06-07
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Qualifier("userDetailServiceImpl")
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    RedisUtil redisUtil;
    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenUtil tokenUtil;

    @Value("${jwt.head}")
    String head;
    @Value("${jwt.expireTime}")
    private Long expireTime;

    @Override
    public RespBean login(LoginBody loginBody, HttpServletRequest request) {

//        UserDetails userDetails=userDetailsService.loadUserByUsername(loginBody.getUsername());
//        if (userDetails==null||!passwordEncoder.matches(loginBody.getPassword(),userDetails.getPassword())){
//            return RespBean.error("用户名或者密码不正确");
//        }
        //检查验证码
        if (!redisUtil.getCacheObject("CaptchaAns").equals(loginBody.getCode())) {
            return RespBean.error("验证码错误");
        }
        Authentication authentication = null;
        try{
            //此方法会执行userDetailServiceImpl.loadUserByUsername
            authentication=authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginBody.getUsername(), loginBody.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("用户名或者密码不正确");
        }


        //生成token
        LoginUser loginUser= (LoginUser) authentication.getPrincipal();
        String token=tokenUtil.CreateToken(loginUser);
        loginUser.setToken(token);
        //将用户对象存入到redis中
        redisUtil.setCacheObject(loginUser.getUsername(),loginUser,expireTime);

        Map<String,String>tokenMap=new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",head);

        System.out.println("生成了jwt token");

        return RespBean.success("login success",tokenMap);
    }

    @Override
    public Student findByUsername(String username) {
        return this.getOne(new QueryWrapper<Student>().eq("username",username));
    }
}
