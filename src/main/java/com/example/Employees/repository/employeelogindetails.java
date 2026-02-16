package com.example.Employees.repository;
import com.example.Employees.model.employeelogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeelogindetails extends JpaRepository<employeelogin,String> {
}
