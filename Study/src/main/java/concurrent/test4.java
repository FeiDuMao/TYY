package concurrent;

import lombok.SneakyThrows;
import org.junit.Test;

public class test4 {

    private static volatile int m=0;

    private static int x=100;

    @Test
    @SneakyThrows
    public void main() {

        new Thread(()->{

            while (true){
                if (m==0){
                    System.out.println(Thread.currentThread().getName()+ x--);
                    m=1;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        },"A").start();


        new Thread(()->{

            while (true){
                if (m==1){
                    System.out.println(Thread.currentThread().getName()+ x--);
                    m=0;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"B").start();



        Thread.sleep(100000);

    }

}
