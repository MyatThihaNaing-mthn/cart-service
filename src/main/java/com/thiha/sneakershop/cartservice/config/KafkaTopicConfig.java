package com.thiha.sneakershop.cartservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    
    @Bean
    NewTopic cartCheckOutTopic(){
        return TopicBuilder.name("cartCheckout").build();
    }
}
