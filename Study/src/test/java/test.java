
import Entity.ListNode;
import Entity.Person;
import com.fasterxml.jackson.databind.DeserializationFeature;
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

import javax.sql.rowset.spi.SyncResolver;
import java.time.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.groupingBy;

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


}
