package com.tyy;

import com.google.common.collect.Lists;
import com.tyy.asset.adapter.AlternateFundEntity;
import com.tyy.asset.adapter.TestData;
import com.tyy.asset.application.AlternateFundRepository;
import com.tyy.asset.application.Mapper;
import com.tyy.asset.util.JsonUtil;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthApplicationTests {

    @Autowired
    AlternateFundRepository alternateFundRepository;


    public  static  String t;

    @Value("${asset.factor.id1:123123}")
    public  void setT(String t) {
        AuthApplicationTests.t = t;
    }

    @Test
    void contextLoads() {


        AlternateFundEntity alternateFundEntity =
                new AlternateFundEntity("xxx","xxx","c","xxx",null,null,"xxx","xxx",LocalDate.parse("2020-01-21"),"xxx");

        List<AlternateFundEntity> xxx1 = alternateFundRepository.getAllByUserId("xxx");
        AlternateFundEntity xxx = alternateFundRepository.getById("xxx");

        AlternateFundEntity save = alternateFundRepository.save(alternateFundEntity);

        System.out.println("======================");


        List<AlternateFundEntity> all = alternateFundRepository.findAll();
        all.forEach(System.out::println);

        System.out.println("======================");

    }




    @Test
    public void test2(){

        System.out.println(t);
        System.out.println("xxxx");
    }

}
