package study;

import Entity.Person;
import lombok.SneakyThrows;
import org.junit.Test;
import scala.util.parsing.combinator.testing.Str;
import utils.CollectionUtil;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date 2022/7/15 11:07
 * @Created by taoyuanyuan
 */
public class CollectionStudy {


    /**
     * filter 后为空的话，不会导致后面map中操作nep
     */
    @Test
    public void test() {

        List<Person> list = List.of(new Person("a", 10), new Person("b", 20));
        List<Integer> list1 = list.stream()
                .filter(p -> p.getName().equals("c"))
                .map(p -> {
                    p.getName().equals("d");
                    return p.getAge();
                })
                .toList();


    }

    @Test
    @SneakyThrows
    public void test2() {

        String code1 = "c1";
        String code2 = "c2";
        String code3 = "c3";
        String code4 = "c4";
        String code5 = "c5";
        String code6 = "c6";

        LocalDate date1 = LocalDate.of(2022, 1, 1);
        LocalDate date2 = LocalDate.of(2022, 1, 2);
        LocalDate date3 = LocalDate.of(2022, 1, 3);


        Map<LocalDate, Integer> data1 = Map.of(date1, 1, date2, 2, date3, 3);
        Map<LocalDate, Integer> data2 = Map.of(date2, 2, date3, 3);
        Map<LocalDate, Integer> data3 = Map.of(date3, 3);

        Map<String, Map<LocalDate, Integer>> result = Map.of(code1, data1, code2, data2, code3, data3, code4, data1, code5, data2, code6, data3);
        Map<LocalDate, Map<String, Integer>> transformMap = CollectionUtil.transformMap(result);

        Thread.sleep(10000);

    }


}
