package com.example.demo.Configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ConfigTopic {

    @Bean
    public NewTopic javaTaskTopic(){
        return TopicBuilder.name("TaskOfTheDay")
                .build();
    }
}

