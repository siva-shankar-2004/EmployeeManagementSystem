package com.example.Employees.service;

import com.example.Employees.model.Contact;
import com.example.Employees.model.employeedetails;
import com.example.Employees.model.employeelogin;
import com.example.Employees.model.employeetask;
import com.example.Employees.repository.Contactdetails;
import com.example.Employees.repository.employeelogindetails;
import com.example.Employees.repository.employeeregisterddetails;
import com.example.Employees.repository.employeetaskdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private employeeregisterddetails employeeregisterddetails;

    @Autowired
    private employeelogindetails employeelogindetails;

    @Autowired
    private employeetaskdetails employeetaskdetails;

    @Autowired
    private Contactdetails contactdetails;

    // GET all employees
    public List<employeedetails> getemployeedetails() {
        return employeeregisterddetails.findAll();
    }

    // POST employee
    public void employeedetails(String id, String name, int age, String gender, String employeeroll, String salary) {
        employeedetails employee = new employeedetails(id, name, age, gender, employeeroll, salary);
        employeeregisterddetails.save(employee);
    }

    // PUT employee
    public boolean updateEmployee(String id, String name, int age, String gender, String employeeroll, String salary) {
        Optional<employeedetails> existing = employeeregisterddetails.findById(id);
        if (existing.isPresent()) {
            employeedetails emp = existing.get();
            emp.setName(name);
            emp.setAge(age);
            emp.setGender(gender);
            emp.setEmployeeroll(employeeroll);
            emp.setSalary(salary);
            employeeregisterddetails.save(emp);
            return true;
        }
        return false;
    }

    // DELETE employee
    public boolean deleteEmployee(String id) {
        Optional<employeedetails> existing = employeeregisterddetails.findById(id);
        if (existing.isPresent()) {
            employeeregisterddetails.deleteById(id);
            return true;
        }
        return false;
    }

    // GET login
    public List<employeelogin> getlogindetails() {
        return employeelogindetails.findAll();
    }

    // POST login
    public void employeelogin(String email, String password) {
        employeelogin login = new employeelogin(email, password);
        employeelogindetails.save(login);
    }

    // Login verification
    public boolean verifyLogin(String email, String password) {
        return employeelogindetails.findById(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    // GET all tasks
    public List<employeetask> getemployeetask() {
        return employeetaskdetails.findAll();
    }

    // POST task
    public void employeetasks(String taskId, String employeeId, String taskname, String taskmanager, String deadline) {
        employeetask task = new employeetask(taskId, employeeId, taskname, taskmanager, deadline);
        employeetaskdetails.save(task);
    }

    // PUT task
    public boolean updateTask(String taskId, String employeeId, String taskname, String taskmanager, String deadline) {
        Optional<employeetask> existing = employeetaskdetails.findById(taskId);
        if (existing.isPresent()) {
            employeetask task = existing.get();
            task.setEmployeeId(employeeId);
            task.setTaskname(taskname);
            task.setTaskmanager(taskmanager);
            task.setDeadline(deadline);
            employeetaskdetails.save(task);
            return true;
        }
        return false;
    }

    // DELETE task
    public boolean deleteTask(String taskId) {
        Optional<employeetask> existing = employeetaskdetails.findById(taskId);
        if (existing.isPresent()) {
            employeetaskdetails.deleteById(taskId);
            return true;
        }
        return false;
    }

    public void contactdetails(String email, String name, String message) {
        Contact cont =new Contact(email,name,message);
        contactdetails.save(cont);
    }
}
