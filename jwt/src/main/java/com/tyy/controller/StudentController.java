package com.tyy.controller;


import com.tyy.entity.RespBean;
import com.tyy.entity.Student;
import com.tyy.service.IStudentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tyy
 * @since 2021-06-07
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @RequestMapping("/all")
    public RespBean getStudentList(Principal principal){
        System.out.println(principal.getName());

        List<Student> list = studentService.list();
        return RespBean.success("success",list);
    }

    @PostMapping("/update")
    public RespBean updateInfo(@RequestBody Student student){

        boolean update = studentService.updateById(student);
        return RespBean.success("update success",update);
    }

    @PostMapping("/add")
    public RespBean add(@RequestBody Student student){
        studentService.save(student);
        return RespBean.success("add success");
    }
    @PostMapping("/del")
    public RespBean del(@RequestBody Student student){
        studentService.removeById(student.getId());
        return RespBean.success("del success");
    }
    @PostMapping("/get")
    public RespBean get(@RequestBody Student student){
        Student s = studentService.getById(student.getId());
        return RespBean.success("get success",s);
    }

}

