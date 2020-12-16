package com.zengc.kafka.controller;

import com.zengc.kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping(value = "/publish/{message}")
    public void sendMessageToKafkaTopic(@PathVariable("message") String message) {
        this.producer.sendMessage(message);
    }
}