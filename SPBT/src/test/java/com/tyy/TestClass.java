package com.tyy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyy.adapter.controller.paramTest.ReqTest;
import com.tyy.jpa.Person;
import com.tyy.jpa.TestEntity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Flow;

/**
 * @Date 2022/9/9 16:44
 * @Created by taoyuanyuan
 */
public class TestClass {


    @Test
    public void test() {

        Map<String, String> getenv = System.getenv();
        Properties properties = System.getProperties();
    }

    @Test
    public void test2() {
        Person tyy = Person.builder()
                .name("tyy")
                .age(12)
                .build();


        System.out.println(tyy);

        TestEntity testEntity = new TestEntity();
        testEntity.setName("asd");

    }


    @Test
    public void test3() {

        String str = "syn_rank_ic_12m_decay * 0.5 + syn_ir * 0.5";
        String replace = str.replace(" ", "").replace('+', ',').replace('-', ',').replace('*', ',').replace('/', ',');
        String[] split = replace.split(",");
        for (String sp : split) {

            System.out.println(sp + sp.matches("-?\\d+(\\.\\d+)"));


        }

    }


    @SneakyThrows
    @Test
    public void test4() {

        HttpClient httpClient = HttpClient.newHttpClient();

        ReqTest reqBody = new ReqTest("tyy", "18");

        HttpRequest req = HttpRequest.newBuilder(new URI("127.0.0.1:8080/param/resp"))
                .timeout(Duration.ofHours(1))
                .POST(HttpRequest.BodyPublishers.ofString(reqBody.toString())).build();

        Object body = httpClient.send(req, HttpResponse.BodyHandlers.ofString()).body();
        System.out.println(body);

    }


}
