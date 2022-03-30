package normal;

import com.google.common.collect.Comparators;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;


class fruit implements Comparable<fruit> {
    int weight;
    int value;

    public fruit(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public fruit() {
    }


    @Override
    public int compareTo(fruit o) {
        return Integer.compare(weight, o.weight);
    }
}


public class Hello {


    /**
     * 水果重量问题
     * @param args
     */
    public static void main(String[] args) {
        fruit[] fruits = new fruit[]{new fruit(), new fruit(), new fruit(), new fruit(), new fruit()};
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            fruits[i].weight = s.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            fruits[i].value = s.nextInt();
        }
        int maxWeight = s.nextInt();
        s.close();

        ArrayList<fruit> fruitArrayList = Lists.newArrayList(fruits);
        fruitArrayList.sort(fruit::compareTo);

        int maxValue=-1;
        while (true){

            int []  count=new int [5];
            int sum =0;
            int val=0;
            while(sum<=maxWeight){
                for (int i = 0; i < 5; i++) {
                    sum+=fruitArrayList.get(i).weight;
                    val+=fruitArrayList.get(i).value;
                    count[i]++;
                }
            }
            break;
        }
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
        ArrayList<String> list = Lists.newArrayList("123", "321", "222", "123", "321", "222", "123", "321", "222", "1244");
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("111", "111");
        multimap.put("111", "111");
        multimap.put("111", "333");

        Collection<String> strings = multimap.get("111");


        List<List<String>> partition = Lists.partition(list, list.size());


        int size = list.size();
        int p = size / 3;
        List<List<String>> partList = new ArrayList<>();
        int i = 0;
        for (; i < 3; i++) {
            partList.add(list.subList(i * p, (i + 1) * p));
        }
        partList.add(list.subList(i * p, size));

        String join = String.join(",", list);

        System.out.println(join);

    }

    @Test
    public void test3() {

        ArrayList<String> list = Lists.newArrayList("111", "444", "111");


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
            code /= 10;
        }
        return String.valueOf(code.longValue());

    }

    @Test
    public void test4() {
        Double a = 200101041d;
        System.out.println(getQueryCode(a));
    }


    public Double sum(List<? extends Number> list) {
        Double sum = 0d;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }


    @Test
    public void test5() {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();
    }


}
