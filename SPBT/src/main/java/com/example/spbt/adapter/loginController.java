package com.example.spbt.adapter;

import com.example.spbt.adapter.entity.loginUserTerms;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class loginController {



    @RequestMapping("/login")
    public ResponseEntity login(HttpServletRequest req){

        Map<String,String>map=new HashMap<>();
        map.put("name","tyy");

        String name = (String) req.getSession().getAttribute("name");
        String head = req.getHeader("name");
        String name1 = req.getParameter("name");


        System.out.println(name1);


        System.out.println(head);
        System.out.println(name);

        return ResponseEntity.ok(map);
    }

    @RequestMapping("/register")
    public ResponseEntity register(loginUserTerms loginUserTerms){
        System.out.println(loginUserTerms);
        return ResponseEntity.ok(loginUserTerms);
    }



}
