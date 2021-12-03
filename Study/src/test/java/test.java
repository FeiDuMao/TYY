
import Entity.ListNode;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class test {


    //0 1 1 2 3 5 8
    public int Fibonacci(int n){
        if (n==0||n==1)return n;
        int pre=0,cur=1,tmp;
        for (int i = 2; i <n ; i++) {
            tmp=pre+cur;
            pre=cur;
            cur=tmp;
        }

        return cur;
    }





    @Test
    public void test(){
        String[]arr=new String[]{"a","tb","tc","d"};
        Map<Integer,String>map= Maps.newHashMap();
        Set<String>set= Sets.newHashSet("a","b","c");
        ArrayList<String> list = Lists.newArrayList("a", "b", "c");

        //set.stream().filter(str->str.equals("a")).forEach(System.out::println);



        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(k -> k, k -> 0));

        List<String> a = list.stream().filter(x -> x.startsWith("a")).collect(Collectors.toList());
        a.forEach(System.out::println);

        collect.forEach((key,val)->{
            System.out.println(key+": "+val);
        });

        //Stream<String>stream=Stream.of(arr);
        Stream<String>stream= Arrays.stream(arr);




        stream.filter(str->str.startsWith("t")).forEach(System.out::println);


    }


    @Test
    public void test2(){

        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(LocalTime.now());
        System.out.println(now);

    }


    @Test
    public void test3(){


    }





}
