package com.tyy.application.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Date 2022/9/9 16:54
 * @Created by taoyuanyuan
 */
@Data
@AllArgsConstructor
public class RespView implements Serializable {

    @Serial
    private static final long serialVersionUID = -6292736464221883748L;
    private String name;
    private String addr;

}
