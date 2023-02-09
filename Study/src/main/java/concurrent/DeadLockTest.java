package concurrent;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;


/**
 * 如何找到死锁位置
 *
 *  法一： 1.使用jps 找到该死锁进程的id
 *        2.使用jstack [pid] 打印该进程的堆栈
 *        根据打印的信息可以确认是否存在死锁和死锁的具体位置
 *
 *  法二： 1.使用jconsole连接该进程
 *        2.连接成功后在线程那一项下面可以检测死锁和查看死锁的具体位置
 *
 */

public class DeadLockTest {


    @Test
    public void test() throws InterruptedException {

        ReentrantLock a = new ReentrantLock();
        ReentrantLock b = new ReentrantLock();


        new Thread(() -> {
            a.lock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.lock();
            System.out.println("aaa");
        }, "A").start();

        new Thread(() -> {
            b.lock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.lock();
            System.out.println("aaa");
        }, "B").start();

        Thread.sleep(10000000);


    }


}
