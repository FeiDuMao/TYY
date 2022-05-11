package concurrent;


public class Test3 {

    //ThreadLocal Test
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName()+"     "+ ThreadLocal.get());
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName()+"     "+ ThreadLocal.get());
                }
            }
        }).start();

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+"     "+ ThreadLocal.get());
        }
    }

}
