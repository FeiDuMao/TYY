package concurrent;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Date 2022/9/21 09:42
 * @Created by taoyuanyuan
 */
public class ThreadPoolStudy {

    @Test
    public void test() {

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                availableProcessors,
                availableProcessors * 2,
                10,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(availableProcessors * 3),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        Future<Integer> future = executor.submit(() -> 10);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> 10, executor);

    }


}
