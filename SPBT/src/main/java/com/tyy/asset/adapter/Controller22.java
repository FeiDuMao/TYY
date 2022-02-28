package com.tyy.asset.adapter;

import com.google.common.collect.Lists;
import com.tyy.asset.application.Mapper;
import lombok.AllArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class Controller22 {

    @RequestMapping("/get")
    public String get(){
        return "t";
    }



    @RequestMapping("/test")
    public boolean test(@RequestBody List<String> list){
        list.forEach(System.out::println);
        return true;
    }

    @RequestMapping("/test2")
    public boolean test2(@RequestBody String s){
        System.out.println(s);
        return true;
    }

    @RequestMapping("/fund/{reportDate}")
    public Map<String,Integer> test2(@RequestBody List<String> fundIds, @PathVariable String reportDate){
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("2021-01-01",1);
        map2.put("2021-01-05",5);
        map2.put("2021-01-03",3);
        map2.put("2021-01-04",4);
        map2.put("2021-01-02",2);
        map2.put("2021-01-06",6);
        return map2;
    }


}
