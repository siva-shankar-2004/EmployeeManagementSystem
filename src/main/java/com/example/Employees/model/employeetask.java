package com.example.Employees.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.SqlReturnType;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class employeetask {
    @Id
    private String taskId;
    private String employeeId;
    private String taskname;
    private String taskmanager;
    private String deadline;

}
