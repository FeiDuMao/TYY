package concurrent;

import Entity.Person;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class threadLocal {

    static AtomicInteger  integer=new AtomicInteger(1);

    public static  ThreadLocal<Integer> localId=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return integer.getAndAdd(1);
        }
    };

    ThreadLocal<Person>personThreadLocal=new ThreadLocal<>();


    public static int get(){
        return localId.get();
    }
    public static void remove(){
        localId.remove();
    }

    public static void main(String[] args) {




        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"     "+threadLocal.get());
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"     "+threadLocal.get());
            }
        },"B").start();


        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+"     "+threadLocal.get());
        }
    }



    @Test
    public void test(){

        personThreadLocal.set(new Person("tyy",10));


    }



}
