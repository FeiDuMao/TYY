import Entity.Person;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.ObjectUtils;
import pachong.DailyReturnEntity;
import utils.CollectionUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

@Slf4j
public class test {


    //person的指向不能被改变，但是内部的熟悉可以改变
    private final Person person = new Person("tyy", 1);

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
        String name = person.getName() + "11";
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

        String s = "tyy is %s,%c";
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
        String[] result2 = new String[list.size()];
        String[] result1 = list.toArray(new String[]{});
        String[] result3 = list.toArray(result2);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);


    }

    @SneakyThrows
    @Test
    public void test6() {


        Double d = Double.NaN;
        System.out.println(Double.NaN == d);
        System.out.println(d.isNaN());

    }


    private void throwExceptionWhenArgsContainsNull(Object... args) {
        for (Object arg : args) {
            if (ObjectUtils.isEmpty(arg))
                throw new IllegalArgumentException();
        }
    }


    @SneakyThrows
    @Test
    public void test7() {

        HashMap<String, List<String>> map = new HashMap<>();
        map.put("1", List.of("1"));
        map.put("2", null);
        map.put(null, List.of());
        map.forEach((k, v) -> {
            if (ObjectUtils.isEmpty(v))
                System.out.println(k + "is empty");

            if (ObjectUtils.isEmpty(k))
                System.out.println(k + "is empty");
        });


    }

    @SneakyThrows
    @Test
    public void test8() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now1 = LocalDateTime.of(2022, 1, 1, 12, 10, 1);
        LocalDateTime now2 = LocalDateTime.of(2022, 1, 1, 12, 10, 2);

        LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(1), ZoneId.systemDefault());
        System.out.println(time);

        System.out.println(now);
        System.out.println(now.toEpochSecond(ZoneOffset.UTC));
        System.out.println(now.toInstant(ZoneOffset.UTC).toEpochMilli());
        System.out.println(now1);
        System.out.println(now1.toEpochSecond(ZoneOffset.UTC));
        System.out.println(now1.toInstant(ZoneOffset.UTC).toEpochMilli());
        System.out.println(now2);
        System.out.println(now2.toEpochSecond(ZoneOffset.UTC));
        System.out.println(now2.toInstant(ZoneOffset.UTC).toEpochMilli());
    }


    @Test
    public void test10() {
        List<Integer> c1 = List.of(1, 2, 3);
        List<Integer> c2 = List.of(2, 3, 4);

        Collection<Integer> intersection = CollectionUtil.intersection(c1, c2);
        System.out.println(intersection);
    }

    @Test
    public void test11() {
        List<Integer> c1 = Lists.newArrayList(1, 2, 3);
        List<Integer> c2 = f1(c1);
        System.out.println(c1);
        System.out.println(c2);
    }

    private List<Integer> f1(List<Integer> c1) {
        c1.add(1);
        return c1;
    }


    @Test
    public void test12() {

        int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0};
        int index = 3;
        System.arraycopy(arr1, index, arr1, index + 1, arr1.length - index - 1);
        arr1[index] = 100;
        System.out.println(Arrays.toString(arr1));


    }

    @SneakyThrows
    @Test
    public void test13() {

        JsonFactory jsonFactory = JsonFactory.builder()
                .configure(JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS, true)
                .build();
        JsonMapper jsonMapper = JsonMapper.builder(jsonFactory)
                .disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
                .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .addModule(new JavaTimeModule())
                .addModule(new Jdk8Module())
                .addModule(new SimpleModule())
                .build();

        Double result = jsonMapper.readValue("NaN", Double.class);
        System.out.println(result);


    }


}



















