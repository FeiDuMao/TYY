package com.tyy.service;

import com.tyy.entity.LoginBody;
import com.tyy.entity.LoginUser;
import com.tyy.entity.RespBean;
import com.tyy.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tyy
 * @since 2021-06-07
 */
public interface IStudentService extends IService<Student> {

    public RespBean login(LoginBody loginBody, HttpServletRequest request);

    public Student findByUsername(String username);
}
