package concurrent;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableStudy {
    /**
     * Callable与Future接收返回值
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test() throws ExecutionException, InterruptedException {
        //通过线程池
        ThreadPoolExecutor executor=
                new ThreadPoolExecutor(2,2,100,TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.AbortPolicy());

        Future<String>future=executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "100";
            }
        });
        System.out.println(future.get());

        //普通方式
        FutureTask futureTask=new FutureTask(()-> {
                Thread.sleep(2000);
                return 200;
            });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }

    @SneakyThrows
    @Test
    public void test4() {

        ArrayList<String> list = Lists.newArrayList("1", "2", "3");
        List<Future<String>> result=new ArrayList<>();

        for (String s : list) {
            FutureTask<String> stringFutureTask = new FutureTask<String>(() -> {
                Thread.sleep(500);
                return s+"aaa";
            });
            new Thread(stringFutureTask).start();
            //将futureTask放到list中，等待线程结束后，可以获取结果
            result.add(stringFutureTask);
        }
        for (Future<String> stringFuture : result) {
            System.out.println(stringFuture.get());
        }
    }


}
