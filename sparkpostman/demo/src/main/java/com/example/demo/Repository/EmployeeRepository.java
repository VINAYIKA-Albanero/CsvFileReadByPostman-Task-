package com.example.demo.Repository;

import com.example.demo.model.Details;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Details,String> {
    //static void SaveAll(List<Details> employeeList) {

    }

