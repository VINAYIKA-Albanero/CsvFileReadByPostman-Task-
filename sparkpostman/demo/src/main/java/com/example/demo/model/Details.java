package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "EmployeesDetails")
public class Details {
    @Id
    private String _id;
    private String employeeId;
    private  String Fullname;
    private String Email;

    public Details(String employeeId, String Fullname, String Email) {
        this.employeeId = employeeId;
        this.Fullname = Fullname;
       this.Email = Email;
    }
}


