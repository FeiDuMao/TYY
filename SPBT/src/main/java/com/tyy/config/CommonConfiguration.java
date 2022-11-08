package com.tyy.config;

import com.tyy.adapter.controller.paramTest.FeignClientTest;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {


    @Bean("local")
    public FeignClientTest feignClientTest2() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(FeignClientTest.class, "http://127.0.0.1:8080");
    }

    @Bean("remote")
    public FeignClientTest feignClientTest1() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(FeignClientTest.class, "https://v3.uat.junson.cloud");
    }


}
