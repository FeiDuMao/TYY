package concurrent;

import java.util.concurrent.locks.Condition;

/**
 * @Classname Lock
 * @Date 2022/2/6 19:35
 * @Created by taoyuanyuan
 */
public class Lock {


    static int x=100;

    public static void main(String[] args) {

        Lock lock=new Lock();



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
