package com.example.producer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaProducer {

    private static final String TOPIC = "Kafka-Example";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/publish/{message}")
    public String produce(@PathVariable("message") String message) {
        kafkaTemplate.send(TOPIC, message);
        return "published successfully";
    }
}
