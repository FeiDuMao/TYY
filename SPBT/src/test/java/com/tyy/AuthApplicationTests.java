package com.tyy;

import com.tyy.config.DefaultConfiguration;
import com.tyy.jpa.FundBondPositionEntity;
import com.tyy.jpa.FundBondPositionRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class AuthApplicationTests {


    @Autowired
    FundBondPositionRepository fundBondPositionRepository;
    @Autowired
    DefaultConfiguration defaultConfiguration;
    @Value("${thread.pool.core}")
    String core;


    @Test
    void contextLoads() {
        List<FundBondPositionEntity> all = fundBondPositionRepository.findAll();
        System.out.println(defaultConfiguration.getCore());
        System.out.println(core);
        System.out.println(all.size());

    }
}
