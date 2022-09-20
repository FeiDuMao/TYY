package com.tyy;

import com.tyy.jpa.FundBondPositionEntity;
import com.tyy.jpa.FundBondPositionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.util.List;

@SpringBootTest
@Slf4j
class AuthApplicationTests {


    @Autowired
    FundBondPositionRepository fundBondPositionRepository;


    @Test
    void contextLoads() throws InterruptedException {
        List<FundBondPositionEntity> all = fundBondPositionRepository.findAll();
        System.out.println(all.size());
    }
}
