package com.lesan.application;

import com.lesan.application.controller.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    DemoService demoService;
    @Test
    void contextLoads() {
        demoService.sayHello();
    }

}
