package com.tyy.asset.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Slf4j
public class JsonUtil {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public static ObjectMapper getMapper() {
        return objectMapper;
    }

    private JsonUtil() {

    }

    public static <T> String toJson(T obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> String toJson(Supplier<T> supplier) {
        return toJson(supplier.get());
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) return null;
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> List<T> toList(String json, Class<T> clazz) {
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            return objectMapper.readValue(json, javaType);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static <T> T fromJson(String json, TypeReference<T> reference) {
        try {
            return objectMapper.readValue(json, reference);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static <T> T fromJson(Supplier<String> supplier, Class<T> clazz) {
        return fromJson(supplier.get(), clazz);
    }

    public static <T> T fromJsonWithNoCatch(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }
}
