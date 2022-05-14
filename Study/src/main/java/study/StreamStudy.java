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

        Double a=null;

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


        final List<String> strings;
        strings=new ArrayList<>();
        strings.add("111");
        strings.remove("111");


    }



    @Test
    @SneakyThrows
    public void test4(){
        File file=new File("C:\\Users\\s\\1\\2\\a.txt");
        if (!file.exists()){
            //创建父目录
            file.getParentFile().mkdirs();
            //创建本身
            file.createNewFile();
            FileOutputStream out=new FileOutputStream(file);
            out.write("tyy".getBytes());
            out.close();
        }


        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        FileInputStream in=new FileInputStream(file);

        byte[] bytes = in.readAllBytes();
        System.out.println(new String(bytes));

//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//        System.out.println(bufferedReader.readLine());

    }




}
