package com.tyy;

import com.tyy.test.A;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

@SpringBootTest
class AuthApplicationTests {

    @Autowired
    A a;

    @Test
    void contextLoads() throws InterruptedException {




    }

    @Test
    public void test2() {
        a.print();
    }

}
