package concurrent;

import org.junit.Test;


/**
 * @Classname test5
 * @Description TODO
 * @Date 2022/2/8 09:59
 * @Created by taoyuanyuan
 */
public class test5 {


    private final Thread[] tasks = new Thread[3];

    @Test
    public void test() {

        tasks[0] = new Thread(() -> {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println("a is interrupted");
                e.printStackTrace();
            }
        }, "A");

        tasks[0] = new Thread(() -> {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println("b is interrupted");
                e.printStackTrace();
            }
        }, "B");

        tasks[0].start();

        try {
            Thread.sleep(1000);
            tasks[0].interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
