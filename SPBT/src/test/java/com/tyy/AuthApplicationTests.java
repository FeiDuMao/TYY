package com.tyy;

import com.google.common.collect.Lists;
import com.tyy.asset.adapter.AlternateFundEntity;
import com.tyy.asset.adapter.TestData;
import com.tyy.asset.application.FundAssetPositionEntity;
import com.tyy.asset.application.FundAssetPositionRepository;
import com.tyy.asset.application.Mapper;
import com.tyy.asset.util.JsonUtil;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthApplicationTests {

    @Autowired
    FundAssetPositionRepository fundAssetPositionRepository;

    public  static  String t;

    @Value("${asset.factor.id1:123123}")
    public  void setT(String t) {
        AuthApplicationTests.t = t;
    }

    @Test
    void contextLoads() {
        List<FundAssetPositionEntity> netAsset = fundAssetPositionRepository.getNetAsset("00017bb8-21ce-11e8-9a06-c4b301c5b6bb");


        System.out.println("======================");

    }
    private Double fundScoreConverter(Double score) {
        if (score > 100) return Double.NaN;
        if (score >= 80) return 5d;
        if (score >= 60) return 4d;
        if (score >= 40) return 3d;
        if (score >= 20) return 4d;
        if (score >= 0) return 1d;
        return Double.NaN;
    }



    @Test
    public void test2(){

        System.out.println(fundScoreConverter(90d));

    }

}
