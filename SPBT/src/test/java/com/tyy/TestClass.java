package com.tyy;

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


        List<String> list = List.of("2","3");
        List<String> result = list.stream().filter(s -> s.equals("1")).map(String::toUpperCase).toList();
        System.out.println(result.isEmpty());


    }




}
