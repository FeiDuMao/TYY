package com.tyy.asset.adapter;

import com.google.common.collect.Lists;
import com.tyy.asset.application.Mapper;
import com.tyy.asset.application.MyBatis;
import lombok.AllArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    Mapper mapper;
    MyBatis myBatis;


    @RequestMapping("/get")
    public String get(){

        ArrayList<String> fundIds = Lists.newArrayList("000e6e8e-3040-11ec-a020-00163e047fc4");
        ArrayList<String> factorIds = Lists.newArrayList("33df00d217a0", "123123123123");

        List<TestData> allByFundId = mapper.getAllByFundId(fundIds);

        List<TestData> byFactorIdList = myBatis.getByFactorIdList(factorIds);

        List<TestData> byFundIdAndFactorId = myBatis.getByFundIdAndFactorId(fundIds,factorIds);

        //return byFundIdAndFactorId.toString();


        Specification<TestData> specification=new Specification<TestData>() {
            @Override
            public Predicate toPredicate(Root<TestData> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate>predicates=new ArrayList<>();


                if (fundIds!=null){
                    CriteriaBuilder.In<Object> allFundId=criteriaBuilder.in(root.get("fundId"));
                    for (String fundId : fundIds) {
                        allFundId=allFundId.value(fundId);
                    }
                    predicates.add(allFundId);
                }
                return criteriaBuilder
                        .and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        List<TestData> alldata=mapper.findAll(specification);


        return null;
    }


    private String List2String(List<String>list){
        StringBuilder sb=new StringBuilder();
        for (String s : list) {
            sb.append('\''+s+'\''+',');
        }
        return sb.substring(0,sb.length()-1);
    }


    @Test
    public void test(){

    }


}
