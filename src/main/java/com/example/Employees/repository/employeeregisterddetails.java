package com.example.Employees.repository;

import com.example.Employees.model.employeedetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeregisterddetails extends JpaRepository<employeedetails,String> {
}
