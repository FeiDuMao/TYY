package com.tyy;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tyy.adapter.controller.paramTest.ReqTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

class HttpClientTest {


    private ObjectMapper mapper;

    {
        mapper = new ObjectMapper();

        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
        simpleFilterProvider.setDefaultFilter(SimpleBeanPropertyFilter.filterOutAllExcept("data"));
        mapper.setFilterProvider(simpleFilterProvider);

    }


    @Test
    void test() throws IOException, InterruptedException, URISyntaxException {

        HttpClient httpClient = HttpClient.newHttpClient();
        ReqTest reqBody = new ReqTest("tyy", "18");
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, ReqTest.class);

        HttpRequest req = HttpRequest.newBuilder(new URI("http://127.0.0.1:8080/param/httpReqStudy"))
                .timeout(Duration.ofHours(1))
                .POST(HttpRequest.BodyPublishers.ofString(reqBody.toString()))
                .header("Content-type", "application/json")
                .build();

        Object body = httpClient.send(req, HttpResponse.BodyHandlers.ofString()).body();

        ReqTest reqTest = mapper.readValue((String) body, javaType);
        System.out.println(reqTest);

    }


    @Test
    public void test2() {
        System.out.println(null=="200");
    }


}
