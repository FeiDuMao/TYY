package com.tyy;

import com.tyy.common.util.ObjectUtil;
import com.tyy.jpa.Person;
import com.tyy.jpa.TestEntity;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import org.springframework.boot.context.properties.PropertyMapper;
import reactor.core.publisher.Flux;

import javax.xml.transform.Source;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.stream.Stream;

/**
 * @Date 2022/9/9 16:44
 * @Created by taoyuanyuan
 */
public class TestClass {




    @Test
    public void test(){

        Iterable<String>strings=null;




        List<String> list = List.of("2","3");
        List<String> result = list.stream().filter(s -> s.equals("1")).map(String::toUpperCase).toList();
        System.out.println(result.isEmpty());


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




}
