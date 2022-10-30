package com.example.kafkaTest.controller;

import com.example.kafkaTest.service.KafkaService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j
public class BaseController {

    @Autowired
    private KafkaService service;

    @GetMapping("/sendMessage/{msg}")
    public String sendMessage(@PathVariable("") String message){
        service.sendMessage(message, "test-1");
        return "message Sent!";
    }

    @KafkaListener(topics = "test-1, test-2")
    public void listenMessage(ConsumerRecord<String, String> record, @Payload String payload){
        ;
    }
}
