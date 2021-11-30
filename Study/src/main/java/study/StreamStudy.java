package study;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StreamStudy {



    @Test
    public void test(){
        String[]arr=new String[]{"a","tb","tc","d"};

        //Stream<String>stream=Stream.of(arr);
        Stream<String>stream=Arrays.stream(arr);

        stream.filter(str->str.startsWith("t")).forEach(System.out::println);




    }
}
