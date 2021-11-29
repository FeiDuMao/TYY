package concurrent;

import java.util.concurrent.*;

public class CallableStudy {
    /**
     * Callable与Future接收返回值
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @org.junit.Test
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
        FutureTask futureTask=new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 200;
            }
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }
}
