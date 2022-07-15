package study;

import Entity.Person;
import org.junit.Test;

import java.util.List;

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


}
