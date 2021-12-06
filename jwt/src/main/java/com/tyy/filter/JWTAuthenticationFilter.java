package com.tyy.filter;

import com.tyy.entity.LoginUser;
import com.tyy.util.RedisUtil;
import com.tyy.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {


    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.head}")
    private String head;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Qualifier("userDetailServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        System.out.println("进行了jwt验证");
        String authHeader = httpServletRequest.getHeader(this.header);
        if (authHeader!=null&&authHeader.startsWith(head)){

            String token = authHeader.substring(head.length()+1);
            String username = tokenUtil.getUsername(token);//注意是否拿到了username

            LoginUser loginUser=(LoginUser)redisUtil.getCacheObject(username);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (loginUser!=null&&null== authentication){

                //UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (tokenUtil.validateToken(token,loginUser)){
                    System.out.println("更新上下文对象");
                    UsernamePasswordAuthenticationToken authenticationToken=new
                            UsernamePasswordAuthenticationToken(loginUser,null,
                            loginUser.getAuthorities());

                    authenticationToken.setDetails(new
                            WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}
