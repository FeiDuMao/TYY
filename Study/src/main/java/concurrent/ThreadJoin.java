package concurrent;

import lombok.SneakyThrows;

/**
 * @Classname ThreadJoin
 * @Description TODO
 * @Date 2022/5/10 10:39
 * @Created by taoyuanyuan
 */
public class ThreadJoin {


    /**
     *  xxx.join(),调用后，调用这个方法的线程会等到xxx线程结束后，才会继续执行后面的代码
     * @param args
     */
    @SneakyThrows
    public static void main(String[] args) {

        Thread a = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("11111");
        }, "A");

        a.start();
        a.join();//a.join()调用后，主线程（当前线程）会等待a线程结束后才会往后面走

        System.out.println("22222");


    }
}
