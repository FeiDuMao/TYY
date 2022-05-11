package concurrent;

import Entity.Person;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocal {

    static AtomicInteger  integer=new AtomicInteger(1);

    public static final java.lang.ThreadLocal<Integer> localId= java.lang.ThreadLocal
            .withInitial(() -> integer.getAndAdd(1));

    java.lang.ThreadLocal<Person> personThreadLocal=new java.lang.ThreadLocal<>();


    public static int get(){
        return localId.get();
    }
    public static void remove(){
        localId.remove();
    }

    public static void main(String[] args) {




        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"     "+ ThreadLocal.get());
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"     "+ ThreadLocal.get());
            }
        },"B").start();


        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+"     "+ ThreadLocal.get());
        }
    }



    @Test
    public void test(){

        personThreadLocal.set(new Person("tyy",10));
        Person person = personThreadLocal.get();
        System.out.println(person);
    }



}
