package study;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;
import utils.CollectionUtil;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class knack {


    /**
     * 1 2 3 4 5 6 7 8  9
     * 0 1 1 2 3 5 8 13 21
     */
    //Fibonacci数列递归法：效率低
    public Double fibonacci(int n) {
        if (n == 1) return 0d;
        if (n == 2) return 1d;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //非递归
    public Double getFibonacci(int n) {
        if (n == 1) return 0d;
        if (n == 2) return 1d;
        //pre:前一个数，cur：后一个数，tmp：暂存下一个数
        double pre = 0d;
        double cur = 1d;
        double tmp;
        for (int i = 2; i < n; i++) {
            tmp = pre + cur;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }


    @Test
    public void test() {

        Map<UUID, Integer> map = IntStream.range(0, 10).boxed().collect(Collectors.toMap(
                i -> UUID.randomUUID(),
                Function.identity()
        ));
        Set<UUID> keys = map.keySet();
        long l1 = System.currentTimeMillis();
        List<Double> list1 = keys.parallelStream().map(uuid -> getFibonacci(map.get(uuid))).toList();
        long l2 = System.currentTimeMillis();
        List<Double> list2 = keys.stream().map(uuid -> getFibonacci(map.get(uuid))).toList();
        long l3 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        System.out.println(l3 - l2);
    }


    @Test
    public void test2() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("1", 4d);
        map.put("2", 2d);
        map.put("3", 2d);
        map.put("4", 1d);

        HashMap<String, Double> valueMaps = new HashMap<>();
        valueMaps.put("1", 10d);
        valueMaps.put("2", 20d);
        valueMaps.put("3", 30d);
        valueMaps.put("4", 40d);


        Map<Double, List<String>> group = CollectionUtil.groupMapByValue(map);
        List<List<String>> result = group.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
        Map<String, Double> result2 = new HashMap<>();
        for (List<String> keys : result) {
            double preVal = result2.keySet().stream().map(valueMaps::get).mapToDouble(Double::doubleValue).sum();
            Double tmpVal = valueMaps.get(keys.get(0)) + preVal;
            Map<String, Double> tmpMap = keys.stream().collect(Collectors.toMap(
                    Function.identity(),
                    key -> tmpVal
            ));
            result2.putAll(tmpMap);
        }
        System.out.println(result2);
    }

    private void addMiss(Map<String, Double> map) {
        map.putIfAbsent("3", 3d);
    }


    @Test
    public void test10() {

        Table<String, LocalDate,Double>table= HashBasedTable.create();
        table.put("000001",LocalDate.of(2021,12,31),1.1d);
        table.put("000002",LocalDate.of(2021,12,31),1.1d);
        table.put("000003",LocalDate.of(2021,12,31),1.1d);
        table.put("000001",LocalDate.of(2022,12,31),1.1d);
        table.put("000002",LocalDate.of(2022,12,31),1.1d);
        table.put("000003",LocalDate.of(2022,12,31),1.1d);
        System.out.println(table.rowMap());
        System.out.println(table.columnMap());

    }


}
