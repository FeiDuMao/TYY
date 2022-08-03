package study;

import Entity.Person;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import lombok.SneakyThrows;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.io.*;
import java.nio.CharBuffer;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamStudy {


    /**
     * flatMap 返回的是一个stream流，合并Map时
     */
    @Test
    public void flatMapStudy() {
        Map<String, Map<String, String>> map = Map.of("m1", Map.of("k1", "v1", "k2", "v2"), "m2", Map.of("k3", "v3", "k4", "v4"));
        Map<String, String> result = map.entrySet().stream()
                .flatMap(stringMapEntry -> stringMapEntry.getValue().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        result.forEach((key, value) -> System.out.println(key + value));


        ArrayList<Map<String, String>> maps = Lists.newArrayList(Map.of("k1", "v1", "k2", "v2"), Map.of("k3", "v3", "k4", "v4"));
        Map<String, String> result2 = maps.stream()
                .flatMap(e -> e.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        result2.forEach((key, value) -> System.out.println(key + value));

    }

    /**
     * sum max n value
     *
     * @param values
     * @param countInt
     * @return
     */
    public static Double factorSumList(List<Double> values, int countInt) {
        return values
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(countInt)
                .mapToDouble(value -> value).sum();
    }

    @Test
    public void toList() {

        List<Double> doubles = List.of(1d, 2d, 3d, 4d);
        //生成的List可变
        List<Double> collect1 = doubles.stream().map(d -> ++d).collect(Collectors.toList());
        //生成的List不可变
        List<Double> collect2 = doubles.stream().map(d -> ++d).toList();
        collect1.add(5d);
//        collect2.add(5d);
        collect1.forEach(System.out::println);
        collect2.forEach(System.out::println);
    }

    @Test
    public void test() {

        ArrayList<Double> doubles = Lists.newArrayList(1.1, 2.2, 3.3, 4.4);
        double sum = doubles.stream().flatMapToDouble(d -> DoubleStream.of(d)).sum();
        Optional<Double> max = doubles.stream().max(Double::compareTo);

    }

    public List<Person> personList(Person person) {
        return Lists.newArrayList(new Person(person.getName(), person.getAge() + 1));
    }

    @Test
    public void test2() {

        Double a = null;

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

    }


    @Test
    @SneakyThrows
    public void test4() {
        File file = new File("C:\\Users\\s\\1\\2\\a.txt");
        if (!file.exists()) {
            //创建父目录
            file.getParentFile().mkdirs();
            //创建本身
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);
            out.write("tyy".getBytes());
            out.close();
        }


        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        FileInputStream in = new FileInputStream(file);

        byte[] bytes = in.readAllBytes();
        System.out.println(new String(bytes));

//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//        System.out.println(bufferedReader.readLine());

    }


}
