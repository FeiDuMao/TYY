package study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class knack {


    /**
     * 1 2 3 4 5 6 7 8  9
     * 0 1 1 2 3 5 8 13 21
     */
    //Fibonacci数列递归法：效率低
    public Double Fibonacci(int n) {
        if (n == 1) return 0d;
        if (n == 2) return 1d;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
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

        List<CompletableFuture<Double>> futures = new ArrayList<>();
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            futures.add(CompletableFuture.supplyAsync(() -> getFibonacci(50)));
        }

        futures.parallelStream().forEach(
                f -> {
                    try {
                        System.out.println(f.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
        );


    }


}
