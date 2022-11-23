package concurrent;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname Lock
 * @Date 2022/2/6 19:35
 * @Created by taoyuanyuan
 */
public class Lock {


    static int x = 100;

    @SneakyThrows
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            System.out.println(x--);
            try {
                lock.notifyAll();
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println(x--);
            try {
                lock.notifyAll();
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    @SneakyThrows
    @Test
    public void DeadLock() {
        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();

        Thread a = new Thread(() -> {
            lockA.lock();
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                lockB.tryLock();
            }


        }, "A");

        Thread b = new Thread(() -> {
            lockB.lock();
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                lockA.tryLock();
            }

        }, "B");

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("111");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        a.start();
        b.start();
        a.join();
        b.join();

    }


}
