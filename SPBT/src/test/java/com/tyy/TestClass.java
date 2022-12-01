package com.tyy;

import com.tyy.adapter.controller.paramTest.ReqTest;
import com.tyy.jpa.Person;
import com.tyy.jpa.TestEntity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;

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


    @SneakyThrows
    @Test
    public void test5() {

        StopWatch watch = new StopWatch();

        int n = 100000;
        List<Integer> list = new LinkedList<>();
        List<Integer> array = new ArrayList<>();

        Random random = new Random(n);
        watch.start("list add");
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        watch.stop();
        watch.start("list insert");
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(list.size()), i);
        }
        watch.stop();

        watch.start("list read");
        for (int i = 0; i < n; i++) {
            list.get(random.nextInt(n));
        }
        watch.stop();

        watch.start("list remove");
        for (int i = 0; i < n; i++) {
            list.remove(random.nextInt(list.size()));
        }
        watch.stop();

        watch.start("array add");
        for (int i = 0; i < n; i++) {
            array.add(i);
        }
        watch.stop();

        watch.start("array insert");
        for (int i = 0; i < n; i++) {
            array.add(random.nextInt(array.size()), i);
        }
        watch.stop();

        watch.start("array read");
        for (int i = 0; i < n; i++) {
            array.get(random.nextInt(n));
        }
        watch.stop();

        watch.start("array remove");
        for (int i = 0; i < n; i++) {
            array.remove(random.nextInt(array.size()));
        }
        watch.stop();
        System.out.println(watch.prettyPrint());

    }



    @Test
    public void test13(){



    }

}
