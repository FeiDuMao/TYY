package concurrent;

import org.junit.Test;

public class test4 {

    private static volatile int m=0;

    @Test
    public void main() {


        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    if (m==1){
                        System.out.println("aaa");
                    }
                    if (m==2){
                        System.out.println("bbb");
                    }
                    if (m==3){
                        System.out.println("ccc");
                    }
                    if (m==4){
                        break;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    m++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
