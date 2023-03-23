package com.codewithfahim.rabbitmq.controller;

import com.codewithfahim.rabbitmq.dto.User;
import com.codewithfahim.rabbitmq.producer.RabbitMQJsonProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JsonMessageController {

    private RabbitMQJsonProducer rabbitMQJsonProducer;
    public JsonMessageController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMQJsonProducer.sendMessage(user);
        return new ResponseEntity<>("Json message sent successfully !!", HttpStatus.CREATED);
    }
}
