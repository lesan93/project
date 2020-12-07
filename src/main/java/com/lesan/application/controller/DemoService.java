package com.lesan.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    DemoController demoController;
    public void sayHello() {
        System.out.println(demoController);
        System.out.println("say hello");
    }
}
