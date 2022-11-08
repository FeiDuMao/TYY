package com.tyy.adapter.controller.paramTest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @Date 2022/9/19 16:09
 * @Created by taoyuanyuan
 */
@RestController
@RequestMapping("/param")
public class ParamTestController {

    public ParamTestController(@Qualifier("remote") FeignClientTest feignClientTest) {
        this.feignClientTest = feignClientTest;
    }

    private final FeignClientTest feignClientTest;


    @GetMapping("/get/{name}")
    public String testGet(@PathVariable("name") String name,//使用@PathVariable获取路径参数
                          @RequestParam("addr") String address) {//当入参名字不一样时，使用@RequestParam，相同可以不加！！！
        System.out.println(name);
        return "ok";
    }

    @GetMapping("/date")//@DateTimeFormat(pattern = "yyyy-MM-dd") 可以反序列化一个LocalDate的入参类型
    public String test2(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, String name) {
        System.out.println(date);
        System.out.println(name);
        return "ok";
    }

    @PostMapping("/resp")
    public RespTest respTest(@RequestBody ReqTest reqTest) {
        System.out.println(reqTest);
        return new RespTest("tyy", "123");
    }


    @PostMapping("/httpReqStudy")
    public ResponseEntity<List<ReqTest>> httpReqStudy(@RequestBody ReqTest reqTest) {
        System.out.println(reqTest);
        return ResponseEntity.ok(List.of(reqTest, reqTest));
    }

    @GetMapping("/feign")
    public ReqTest feign() {
        ReqTest req = new ReqTest("tyy", "123");
        ReqTest resp = feignClientTest.query(req);
        return resp;
    }

    @GetMapping("/feign2")
    public String feign2() {
        String json = "{\"scenarios\":[\"1987 Black Monday - current correlations\"],\"primary_market_shocks\":[{\"fund_name\":\"GRE\",\"scenario\":\"1987 Black Monday - current correlations\",\"pnl_rate\":0.0},{\"fund_name\":\"PI\",\"scenario\":\"1987 Black Monday - current correlations\",\"pnl_rate\":0.0},{\"fund_name\":\"AI\",\"scenario\":\"1987 Black Monday - current correlations\",\"pnl_rate\":0.0}],\"adjust_aum\":[{\"fund_name\":\"Total Return Portfolio\",\"aum_dollar\":998392.01},{\"fund_name\":\"PI\",\"aum_dollar\":983.31}]}";
        return feignClientTest.query2(json).toString();
    }

}
