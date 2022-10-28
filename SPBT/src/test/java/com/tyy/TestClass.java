package com.tyy;

import com.tyy.jpa.Person;
import com.tyy.jpa.TestEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @Date 2022/9/9 16:44
 * @Created by taoyuanyuan
 */
public class TestClass {




    @Test
    public void test(){

        Map<String, String> getenv = System.getenv();
        Properties properties = System.getProperties();
    }

    @Test
    public void test2(){
        Person tyy = Person.builder()
                .name("tyy")
                .age(12)
                .build();


        System.out.println(tyy);

        TestEntity testEntity = new TestEntity();
        testEntity.setName("asd");

    }


    @Test
    public void test3(){

        String str="syn_rank_ic_12m_decay * 0.5 + syn_ir * 0.5";
        String replace = str.replace(" ","").replace('+', ',').replace('-', ',').replace('*', ',').replace('/', ',');
        String[] split = replace.split(",");
        for (String sp : split) {

            System.out.println(sp+sp.matches("-?\\d+(\\.\\d+)"));


        }

    }



    @Test
    public void test4(){


        for (int i = 0; i < 100; i++) {
            System.out.println(System.currentTimeMillis());
        }


        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(1666859260317L), ZoneId.systemDefault()));

    }



}
