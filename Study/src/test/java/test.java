
import Entity.ListNode;
import Entity.Person;
import Spring.A;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import pachong.DailyReturnEntity;
import scala.util.parsing.combinator.testing.Str;
import scala.util.parsing.json.JSON;

import javax.sql.rowset.spi.SyncResolver;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.math.RoundingMode;
import java.nio.BufferUnderflowException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Slf4j
public class test {


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
        String[] arr = new String[]{"a", "tb", "tc", "d"};
        Map<Integer, String> map = Maps.newHashMap();
        Set<String> set = Sets.newHashSet("a", "b", "c");
        ArrayList<String> list = Lists.newArrayList("a", "b", "c");

        //set.stream().filter(str->str.equals("a")).forEach(System.out::println);


        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(k -> k, k -> 0));

        List<String> a = list.stream().filter(x -> x.startsWith("a")).collect(Collectors.toList());
        a.forEach(System.out::println);

        collect.forEach((key, val) -> {
            System.out.println(key + ": " + val);
        });

        //Stream<String>stream=Stream.of(arr);
        Stream<String> stream = Arrays.stream(arr);


        stream.filter(str -> str.startsWith("t")).forEach(System.out::println);


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

        long l = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        LocalDateTime localDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(1648692346760L), ZoneId.systemDefault());

        System.out.println(localDate);

        System.out.println(l);

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
        UUID u1 = UUID.randomUUID();
        UUID u2 = UUID.nameUUIDFromBytes("123".getBytes());
        UUID u3 = UUID.nameUUIDFromBytes("123".getBytes());
        System.out.println(u1);
        System.out.println(u1.getMostSignificantBits());
        System.out.println(u1.getLeastSignificantBits());
        System.out.println(u1.version());
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u2.version());

    }



}
