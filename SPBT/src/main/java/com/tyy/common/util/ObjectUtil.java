package com.tyy.common.util;

import com.tyy.common.exception.BadRequestParamExceptioin;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @Date 2022/9/19 17:12
 * @Created by taoyuanyuan
 */

public class ObjectUtil {

    @SneakyThrows
    public static void validateParam(Object o) {

        Class<?> clazz = o.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(o) == null) {
                throw new BadRequestParamExceptioin(clazz.getName(), field.getName());
            }
        }

    }

}
