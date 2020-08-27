package com.example.consumer.Configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ConfigConsumer {

    @Bean
    public ConsumerFactory<String,String> consumerFactory()
    {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"c1");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringSerializer.class);

        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> kafkaListener()
    {
        ConcurrentKafkaListenerContainerFactory<String,String> concurrentKafkaListenerContainerFactory=new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
        return concurrentKafkaListenerContainerFactory;
    }
}
