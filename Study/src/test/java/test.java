import Entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.ObjectUtils;
import pachong.DailyReturnEntity;
import scala.util.parsing.combinator.testing.Str;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class test {


    //person的指向不能被改变，但是内部的熟悉可以改变
    private final Person person=new Person("tyy",1);


    //0 1 1 2 3 5 8
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        int pre = 0, cur = 1, tmp;
        for (int i = 2; i < n; i++) {
            tmp = pre + cur;
            pre = cur;
            cur = tmp;
        }

        return cur;
    }


    @Test
    public void test() {
        String name =person.getName()+"11";
        person.setName(name);
        Map<String, Integer> map = Map.of("k1", 1, "k2", 2);


    }


    @SneakyThrows
    @Test
    public void test2() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());


        String json2 = "{\"FSRQ\":\"2022-03-30\",\"DWJZ\":\"1.4359\",\"LJJZ\":\"2.1204\",\"SDATE\":null,\"ACTUALSYI\":\"\",\"NAVTYPE\":\"1\",\"JZZZL\":\"2.14\",\"SGZT\":\"限制大额申购\",\"SHZT\":\"开放赎回\",\"FHFCZ\":\"\",\"FHFCBZ\":\"\",\"DTYPE\":null,\"FHSP\":\"\"}";

        String s = json2.toLowerCase();
        DailyReturnEntity entity = objectMapper.readValue(s, DailyReturnEntity.class);
        System.out.println(entity);

    }


    @Test
    public void test3() {

        String s="tyy is %s,%c";
        String result = String.format(s, "aaa");
        System.out.println(result);

    }

    @SneakyThrows
    @Test
    public void test4() {

        ArrayList<String> list = Lists.newArrayList("1", "2", "3");
        List<Future<String>> result = new ArrayList<>();

        for (String s : list) {
            FutureTask<String> stringFutureTask = new FutureTask<String>(() -> {
                Thread.sleep(500);
                return s + "aaa";
            });
            new Thread(stringFutureTask).start();
            result.add(stringFutureTask);
        }
        for (Future<String> stringFuture : result) {
            System.out.println(stringFuture.get());
        }


    }

    @SneakyThrows
    @Test
    public void test5() {

        List<String> list = List.of("1", "2", "3");
        String result = String.join(",", "12","123","aaa");
        System.out.println(result);


    }

    @SneakyThrows
    @Test
    public void test6() {


//        LocalDateTime parse = LocalDateTime.parse("2022-06-30 17:16:32");
        LocalDateTime parse = LocalDateTime.now();
        String result = parse.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(result);
        System.out.println(parse);


    }




    private void throwExceptionWhenArgsContainsNull(Object ...args){
        for (Object arg : args) {
            if (ObjectUtils.isEmpty(arg))
                throw new IllegalArgumentException();
        }
    }











}
