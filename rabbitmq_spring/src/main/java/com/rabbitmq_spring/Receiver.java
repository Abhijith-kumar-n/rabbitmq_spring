package com.rabbitmq_spring;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@RestController
@Component
@RequestMapping("/receive")
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    @GetMapping("/")
    public CountDownLatch recimsg(){
        return latch;
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}

