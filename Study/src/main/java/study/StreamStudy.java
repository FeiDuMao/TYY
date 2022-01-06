package study;

import Entity.Person;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy {


    @Test
    public void test() {
        String[] arr = new String[]{"a", "tb", "tc", "d"};

        //Stream<String>stream=Stream.of(arr);
        Stream<String> stream = Arrays.stream(arr);

        stream.filter(str -> str.startsWith("t")).forEach(System.out::println);


        ArrayList<Person> people = Lists.newArrayList(new Person("tyy", 12), new Person("aaa", 13));

        //List转map
        Map<String, Integer> personMap = people.stream().collect(Collectors.toMap(
                Person::getName,  //key
                Person::getAge    //val  p->p 表示将对象作为val
        ));

        //people.stream().flatMap();


        personMap.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });


    }

    public List<Person> personList(Person person) {
        return Lists.newArrayList(new Person(person.getName(), person.getAge() + 1));
    }

    @Test
    public void test2() {


        Map<String, Double> result = new HashMap<>();
        result.put("1", 1.1);
        result.put("2", 1.6);
        result.put("3", -1.1);
        result.put("4", -1.6);

        String condition = "R";

        if ("R".equals(condition)) {
            result.keySet().forEach(k -> {
                Double num = result.get(k);
                result.put(k, (double) Math.round(num));
            });
        }
        if ("U".equals(condition)) {
            result.keySet().forEach(k -> {
                Double num = result.get(k);
                result.put(k, Math.ceil(num));
            });
        }
        if ("D".equals(condition)) {
            result.keySet().forEach(k -> {
                Double num = result.get(k);
                result.put(k, Math.floor(num));

            });
        }

        result.values().forEach(System.out::println);


        Stream<String> stream = result.keySet().stream().filter(k -> k.contains("1"));


    }


    @Test
    public void test3() {
        HashMultimap<String, String> map = HashMultimap.create();
        map.put("123","a");
        map.put("123","b");
        map.put("123","c");


    }

}
