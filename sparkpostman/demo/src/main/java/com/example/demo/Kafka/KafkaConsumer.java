package com.example.demo.Kafka;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.model.Details;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    private EmployeeRepository employeeRepository;
    @KafkaListener(topics = "TaskOfTheDay", groupId = "myGroup")
    public void consume(String message){
        String [] words = message.split(",");
        employeeRepository.save(new Details(words[0],words[1],words[2]));

    }
}