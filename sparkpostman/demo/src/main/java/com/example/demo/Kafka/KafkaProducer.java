package com.example.demo.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


        private KafkaTemplate<String, String> kafkaTemplate;

        public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
            this.kafkaTemplate = kafkaTemplate;
        }

        public void sendMessage(String message){
            kafkaTemplate.send("TaskOfTheDay", message);
        }
    }

