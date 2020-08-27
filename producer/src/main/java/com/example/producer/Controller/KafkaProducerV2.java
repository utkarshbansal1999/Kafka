package com.example.producer.Controller;

import com.example.producer.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaProducerV2 {

    private static final String TOPIC = "Kafka-Example";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate2;

    @GetMapping("/publish/v2/{name}")
    public String produce2(@PathVariable("name") String name) {
        kafkaTemplate2.send(TOPIC, User.builder()
                .name(name)
                .tech("CSE")
                .price(120L)
                .build()
        );
        return "Published 2 successfully";
    }
}
