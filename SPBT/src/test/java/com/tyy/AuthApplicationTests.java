package com.tyy;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

@SpringBootTest
class AuthApplicationTests {


    @Test
    void contextLoads() throws InterruptedException {

        StopWatch watch = new StopWatch();
        watch.start();
        watch.start();
        watch.stop();
        watch.stop();
        watch.prettyPrint();

    }
}
