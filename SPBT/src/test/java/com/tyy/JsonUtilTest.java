package com.tyy;

import com.tyy.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class JsonUtilTest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class A {
        int a;
        String b;
        List<C> c;
        Double d;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class C {
        int c1;
        LocalDate c2;
        String c3;
    }


    @Test
    public void test() {


        A a = new A(1, null, List.of(new C(2,LocalDate.now(),"ccc")),Double.NaN);

        String json1 = JsonUtil.toJson(a);
        String json2 = JsonUtil.toJson(List.of(a));
        System.out.println(json1);
        System.out.println(json2);

        String json3= "{\"e\":10,\"a\":null,\"b\":null,\"c\":[{\"c1\":2,\"c2\":[2022,12,6],\"c3\":\"ccc\"}]}";

        A fromJson1 = JsonUtil.fromJson(json1, A.class);
        Collection<A> fromJson2 = JsonUtil.fromJsonToCollection(json2, A.class);
        A fromJson3 = JsonUtil.fromJson(json3, A.class);


        System.out.println(fromJson1);
        System.out.println(fromJson2);
        System.out.println(fromJson3);


    }


}
