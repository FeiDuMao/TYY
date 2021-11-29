package concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test2 {

    class Phone{

        int count=100;

        Lock lock=new ReentrantLock();
        //通过condition可以实现多线程通讯。
        Condition condition=lock.newCondition();
        public void exec(){

            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"====>"+ --count);
                //TimeUnit.SECONDS.sleep(1);
                condition.await();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public synchronized void exec2(){
            System.out.println(Thread.currentThread().getName());
        }

    }


    @Test
    public void test(){

        ExecutorService executorService=
                new ThreadPoolExecutor(5,10,
                        10,TimeUnit.SECONDS,new SynchronousQueue<>());

        Phone phone=new Phone();

        AtomicStampedReference<Integer> a=new
                AtomicStampedReference<>(10,1);
        //乐观锁实现原理，比较对象和版本号。
        int stamp = a.getStamp();

        new Thread(()->{
            System.out.println("0===>"+a.getStamp());
            System.out.println("a===>"+a.getReference());
            boolean b = a.compareAndSet(10, 11, stamp, a.getStamp() + 1);
            System.out.println(b);
            System.out.println("1===>"+a.getStamp());
            System.out.println("a===>"+a.getReference());
            b=a.compareAndSet(11,10,a.getStamp(),a.getStamp()+1);
            System.out.println(b);
            System.out.println("2===>"+a.getStamp());
            System.out.println("a===>"+a.getReference());
        },"A").start();

        new Thread(()->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = a.compareAndSet(10, 12, stamp, a.getStamp() + 1);
            System.out.println(b);
            System.out.println("3===>"+a.getStamp());
            System.out.println("a===>"+a.getReference());
            System.out.println(stamp);
        },"B").start();



        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
