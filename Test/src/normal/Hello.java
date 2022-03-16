package normal;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

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
        ArrayList<String> list = Lists.newArrayList("123", "321", "222","123", "321", "222","123", "321", "222","1244");
        Multimap<String,String>multimap= HashMultimap.create();
        multimap.put("111","111");
        multimap.put("111","111");
        multimap.put("111","333");

        Collection<String> strings = multimap.get("111");


        List<List<String>> partition = Lists.partition(list, list.size());



        int size = list.size();
        int p = size / 3;
        List<List<String>>partList=new ArrayList<>();
        int i = 0;
        for (; i < 3; i++) {
            partList.add(list.subList(i*p,(i+1)*p));
        }
        partList.add(list.subList(i*p,size));

        String join = String.join(",", list);

        System.out.println(join);

    }

    @Test
    public void test3() {

        ArrayList<String> list = Lists.newArrayList("111", "444","111");


        Collections.reverse(list);


        Map<String, Integer> map2 = new HashMap<>();
        map2.put("2021-01-01", 1);
        map2.put("2021-01-05", -5);
        map2.put("2021-01-03", 3);
        map2.put("2021-01-04", 4);
        map2.put("2021-01-02", -2);
        map2.put("2021-01-06", 6);


        List<Integer> collect4 = map2.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getValue).collect(Collectors.toList());

        Collections.reverse(collect4);


        ArrayList<Map.Entry<String, Integer>> entries1 = new ArrayList<>(map2.entrySet());


        List<String> collect2 = entries1.stream().map(Map.Entry::getKey).collect(Collectors.toList());
        List<Integer> collect3 = entries1.stream().map(Map.Entry::getValue).collect(Collectors.toList());

        System.out.println("xxx");

    }

    private String getQueryCode(Double code) {

        while (code % 10 == 0) {
            code/=10;
        }
        return String.valueOf(code.longValue());

    }

    @Test
    public void test4(){
        Double a=200101041d;
        System.out.println(getQueryCode(a));
    }




    @Test
    public void test5(){

    }



}
