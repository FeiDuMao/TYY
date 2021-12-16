package normal;

import Entity.Person;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalField;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hello {
    public static void main(String[] args) {

        String s = "fd6507a5-561b-471d-9c59-7d3c7c238c6b?_t=1639559238257";
        String substring = s.substring(0, s.indexOf('?'));
        System.out.println(substring);


    }


    @Test
    public void test() {

        LocalDate parse = LocalDate.parse("2004-01-01");
        LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        parse.plusDays(3);
        System.out.println(parse);


        LocalDate start = LocalDate.parse("2020-01-01");
        LocalDate now = LocalDate.now();

        long year, month, day;
        long days = Duration.between(start.atStartOfDay(), now.atStartOfDay()).toDays();

        days = 375;

        long l = Long.parseLong("1102176000000");
        LocalDate date = LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault()).toLocalDate();
        System.out.println(date);

        System.out.println(parse.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

    }


    @Test
    public void test2() {

        List<String> list=new ArrayList<>();
        if (list!=null){
            list.forEach(System.out::println);
        }
        System.out.println("Ss");

    }

    @Test
    public void test3() {

        ArrayList<String> list = Lists.newArrayList("111", "222", "333");

        Collections.reverse(list);


        Map<LocalDate, Integer> map = new HashMap<>();
        map.put(LocalDate.parse("2022-01-01"), 1);
        map.put(LocalDate.parse("2022-01-03"), 3);
        map.put(LocalDate.parse("2022-01-08"), 8);
        map.put(LocalDate.parse("2022-01-06"), 6);
        map.put(LocalDate.parse("2022-01-04"), 4);
        map.put(LocalDate.parse("2022-01-05"), 5);


        map.put(null,null);
        Integer integer = map.get(null);
        ArrayList<Map.Entry<LocalDate, Integer>> entries = new ArrayList<>(map.entrySet());

        List<LocalDate> collect = entries.stream().map(Map.Entry::getKey).collect(Collectors.toList());
        List<Integer> collect1 = entries.stream().map(Map.Entry::getValue).collect(Collectors.toList());

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("2021-01-01",1);
        map2.put("2021-01-05",5);
        map2.put("2021-01-03",3);
        map2.put("2021-01-04",4);
        map2.put("2021-01-02",2);
        map2.put("2021-01-06",6);

        ArrayList<Map.Entry<String, Integer>> entries1 = new ArrayList<>(map2.entrySet());
        List<String> collect2 = entries1.stream().map(Map.Entry::getKey).collect(Collectors.toList());
        List<Integer> collect3 = entries1.stream().map(Map.Entry::getValue).collect(Collectors.toList());

        System.out.println("xxx");

    }


}
