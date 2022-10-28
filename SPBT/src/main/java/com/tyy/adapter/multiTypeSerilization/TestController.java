package com.tyy.adapter.multiTypeSerilization;

import com.tyy.adapter.multiTypeSerilization.test.DashboardMapView;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/9/9 16:53
 * @Created by taoyuanyuan
 */
@RestController
@RequestMapping("/test")
public class TestController {




    @RequestMapping("/serialization")
    public void handle(@RequestBody ListBaseReq listBaseReq){

        System.out.println(listBaseReq.moduleType);
        System.out.println(listBaseReq.requests);

    }



}
