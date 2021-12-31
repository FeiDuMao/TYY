package com.tyy.asset.application;

import com.tyy.asset.adapter.TestData;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname MyBatis
 * @Description TODO
 * @Date 2021/12/21 19:01
 * @Created by taoyuanyuan
 */

@Mapper
public interface MyBatis {


    @Select(  "<script>"
            + "SELECT fund_id fundId,factor_id factorId, data,create_time createTime"
            + "FROM fund_factor_data WHERE fund_id IN "
            + "<foreach item='item' index='index' collection='fundIds' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    List<TestData> getByFundIdList(@Param("fundIds") List<String> fundIds);


    @Select(  "<script>"
            + "SELECT *"
            + "FROM fund_factor_data WHERE factor_id IN "
            + "<foreach item='item' index='index' collection='factorIds' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    @Results( id = "TestData",
            value = {
            @Result(column = "fund_id",property = "fundId"),
            @Result(column = "factor_id",property = "factorId"),
            @Result(column = "data",property = "data"),
            @Result(column = "create_time",property = "createTime"),
    })
    List<TestData> getByFactorIdList(@Param("factorIds") List<String> factorIds);


    @Select(  "<script>"
            + "SELECT *"
            + "FROM fund_factor_data WHERE "
            +"fund_id in"
            + "<foreach item='item' index='index' collection='fundIds' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            +"and factor_id IN "
            + "<foreach item='item' index='index' collection='factorIds' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    @ResultMap(value = "TestData")
    List<TestData> getByFundIdAndFactorId(@Param("fundIds") List<String> fundIds,@Param("factorIds") List<String> factorIds);

}
