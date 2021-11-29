package concurrent;


public class Test3 {

    //ThreadLocal Test
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName()+"     "+threadLocal.get());
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName()+"     "+threadLocal.get());
                }
            }
        }).start();

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+"     "+threadLocal.get());
        }
    }

}
