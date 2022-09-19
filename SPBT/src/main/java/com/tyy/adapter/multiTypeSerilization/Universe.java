package com.tyy.adapter.multiTypeSerilization;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @Date 2022/9/19 10:51
 * @Created by taoyuanyuan
 */
public interface Universe {


    @AllArgsConstructor
    @Getter
    class Dynamic implements Universe {
        private String code;
    }

    @AllArgsConstructor
    @Getter
    class Static implements Universe {
        private List<String> codes;
    }

}
