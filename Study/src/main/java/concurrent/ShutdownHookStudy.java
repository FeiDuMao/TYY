package concurrent;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Date 2022/9/21 10:05
 * @Created by taoyuanyuan
 */

@Slf4j
public class ShutdownHookStudy {


    @SneakyThrows
    @Test
    public void test() {


        Thread a = new Thread(() -> {
            while (true) {
                log.info(Thread.currentThread().getName() + " is exec!");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    log.info(Thread.currentThread().getName() + " is shutdown by " + Thread.currentThread().getThreadGroup().getParent().getName());
                    e.printStackTrace();
                }
            }
        }, "A");

        a.start();


        Thread.sleep(10000);

//        Thread.getAllStackTraces().forEach(
//                (thread, stackTraceElements) -> {
//                    for (StackTraceElement stackTraceElement : stackTraceElements) {
//                        log.info("thread: "+thread.getName() + " class: " + stackTraceElement.getClassName() + " method: " + stackTraceElement.getMethodName());
//                    }
//                }
//        );


        log.info(Thread.currentThread().getThreadGroup().toString());
        log.info(Thread.currentThread().getThreadGroup().getParent().toString());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            a.interrupt();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("shutdown hook !!");
        }));


        log.info("end");


    }

    @Test
    public void test2(){

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup.getParent().getName());


    }


}
