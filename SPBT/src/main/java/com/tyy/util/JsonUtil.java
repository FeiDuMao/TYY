package com.tyy.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Collection;

public class JsonUtil {

    private JsonUtil() {
    }

    static final ObjectMapper mapper;
    static final String EMPTY_STRING = "";


    static {
        JsonFactory jsonFactory = JsonFactory.builder()
                .configure(JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS, true)
                .build();
        mapper = JsonMapper.builder(jsonFactory)
                .disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .addModule(new JavaTimeModule())
                .addModule(new Jdk8Module())
                .addModule(new SimpleModule())
                .build();
    }

    public static  String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("");
    }


    public static <T> Collection<T> fromJsonToCollection(String json, Class<T> clazz) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(Collection.class, clazz);
        try {
            return mapper.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("");
    }
}
