package concurrent;

import org.junit.Test;

import java.util.List;

/**
 * @Date 2022/10/17 14:18
 * @Created by taoyuanyuan
 */
public class ParallelStream {


    @Test
    public void test10() {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
        long l1 = System.currentTimeMillis();
        List<Integer> list1 = list.parallelStream().map(this::block).toList();
        long l2 = System.currentTimeMillis();
        List<Integer> list2 = list.stream().map(this::block).toList();
        long l3 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        System.out.println(l3 - l2);

    }

    private int block(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i * 2;
    }


}
