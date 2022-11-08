package com.tyy.adapter.controller.paramTest;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface FeignClientTest {

    @RequestLine("POST /param/httpReqStudy")
    @Headers("Content-type:application/json")
    @Body("{body}")
    ReqTest query(@Param("body") ReqTest reqTest);



    @RequestLine("POST /param/httpReqStudy")
    @Headers("Content-type:application/json")
    @Body("{body}")
    Object query2(@Param("body") String s);





}
