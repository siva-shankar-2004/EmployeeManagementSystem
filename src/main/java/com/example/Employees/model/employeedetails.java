package com.example.Employees.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class employeedetails {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private String employeeroll;
    private String salary;


}
