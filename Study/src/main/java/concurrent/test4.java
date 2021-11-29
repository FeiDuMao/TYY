package concurrent;

public class test4 {

    private static volatile int m=0;

    public static void main(String[] args) {

        int t=0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (m==0){
                        System.out.println("AAA");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        m=1;
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                ThreadLocal<Integer> integerThreadLocal=new ThreadLocal<>();
                integerThreadLocal.set(1);
                while (true){
                    if (m==1){
                        System.out.println("BBB");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        m=0;
                    }
                }
            }
        }).start();


        ThreadLocal<String> local=new ThreadLocal<>();

        local.set("123");
        local.remove();

        System.out.println(local.get());
        System.out.println("Lock Test");
    }

}
