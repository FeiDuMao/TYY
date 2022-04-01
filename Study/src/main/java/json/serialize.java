package json;

import Entity.Person;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import scala.util.parsing.combinator.testing.Str;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname serialize
 * @Date 2022/4/1 10:38
 * @Description 一个对象的序列化与反序列化
 * @Created by taoyuanyuan
 */
public class serialize implements Serializable {


    @SneakyThrows
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();


        Person person = new Person();

        //这里将属性名字都转换为了小写
        String json = objectMapper.writeValueAsString(person);
        //普通反序列化一个对象
        Person value = objectMapper.readValue(json, Person.class);

        /*
        反序列化为list
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Person.class);
        Object o = objectMapper.readValue(json, javaType);
        */
    }


}
