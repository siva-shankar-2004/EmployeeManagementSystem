package com.example.Employees.repository;

import com.example.Employees.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Contactdetails extends JpaRepository<Contact,String> {
}
