package com.tyy;

import com.google.common.collect.Lists;
import com.tyy.asset.adapter.TestData;
import com.tyy.asset.application.Mapper;
import com.tyy.asset.application.MyBatis;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthApplicationTests {


    @Autowired
    MyBatis myBatis;

    @Autowired
    Mapper mapper;

    @Test
    void contextLoads() {

        ArrayList<String> fundIds = Lists.newArrayList("000e6e8e-3040-11ec-a020-00163e047fc4");
        ArrayList<String> factorIds = Lists.newArrayList("33df00d217a0", "123123123123");


        List<TestData> byFactorIdList = myBatis.getByFactorIdList(factorIds);

        List<TestData> allByFundId = mapper.getAllByFundId(fundIds);

        List<TestData> byFundIdAndFactorId = myBatis.getByFundIdAndFactorId(fundIds,factorIds);

    }



}
