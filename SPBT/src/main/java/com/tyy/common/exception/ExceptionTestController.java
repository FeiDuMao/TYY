package com.tyy.common.exception;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/exception")
public class ExceptionTestController {


    @SneakyThrows
    @RequestMapping("/custom")
    public String testCustomException() {
        throw new TyyIllegalOperationException("aaa", "cccc", List.of(111, 222, 333).toArray());
    }

    @RequestMapping("/common")
    public String testException() {
        throw new IllegalArgumentException("IllegalArgumentException");
    }


}
