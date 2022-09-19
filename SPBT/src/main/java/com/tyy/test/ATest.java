package com.tyy.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/9/9 16:34
 * @Created by taoyuanyuan
 */
@Data
@NoArgsConstructor
public class ATest {
    private String name;
    private String addr;

    public ATest(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }
}
