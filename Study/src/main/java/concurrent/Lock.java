package concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname Lock
 * @Date 2022/2/6 19:35
 * @Created by taoyuanyuan
 */
public class Lock {


    static int x=100;

    @SneakyThrows
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        new Thread(()->{
            System.out.println(x--);
            try {
                lock.notifyAll();
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            System.out.println(x--);
            try {
                lock.notifyAll();
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


}
