package com.tyy;

import com.tyy.jpa.Person;
import com.tyy.jpa.TestEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
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

        String s="1,2,3,4";
        String s1="1";

        List<String> strings = Arrays.stream(s.split(",")).toList();
        List<String> strings1 = Arrays.stream(s1.split(",")).toList();
        System.out.println(strings);
        System.out.println(strings1);


    }



}
