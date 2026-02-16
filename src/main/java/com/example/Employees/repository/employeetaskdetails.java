package com.example.Employees.repository;

import com.example.Employees.model.employeetask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeetaskdetails extends JpaRepository<employeetask,String> {
}
