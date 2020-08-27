package com.example.consumer.Controller;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka-Example",groupId = "c1")
    public void consume(String message)
    {
        System.out.println(message);
    }
}
