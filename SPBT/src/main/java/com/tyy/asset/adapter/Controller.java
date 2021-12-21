package com.tyy.asset.adapter;

import com.google.common.collect.Lists;
import com.tyy.asset.application.Mapper;
import lombok.AllArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    Mapper mapper;


    @RequestMapping("/get")
    public String get(){

        List<TestData> allByFundIdAndFactorId = mapper.getAllByFundIdAndFactorId(Lists.newArrayList("000e6e8e-3040-11ec-a020-00163e047fc4"), Lists.newArrayList("33df00d217a0", "123123123123"));
        List<TestData> allByFundIdAndFactorId2 = mapper.getAllByFundIdAndFactorId2(Lists.newArrayList("000e6e8e-3040-11ec-a020-00163e047fc4"));
        return null;

    }

}
