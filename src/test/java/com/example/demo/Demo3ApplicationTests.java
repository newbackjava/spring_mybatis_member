package com.example.demo;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class Demo3ApplicationTests {

    @Test
    void contextLoads() {
        log.info("test start");
    }

}
