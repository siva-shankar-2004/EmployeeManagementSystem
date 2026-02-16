package com.example.Employees.controller;

import com.example.Employees.model.employeedetails;
import com.example.Employees.model.employeelogin;
import com.example.Employees.model.employeetask;
import com.example.Employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // Get all employees
    @GetMapping("/employees")
    public List<employeedetails> getAllEmployees() {
        return employeeService.getemployeedetails();
    }

    // Add employee
    @PostMapping("/employees")
    public String addEmployee(@RequestParam("id") String id,
                              @RequestParam("name") String name,
                              @RequestParam("age") int age,
                              @RequestParam("gender") String gender,
                              @RequestParam("employeeroll") String employeeroll,
                              @RequestParam("salary") String salary) {
        employeeService.employeedetails(id, name, age, gender, employeeroll, salary);
        return "success";
    }

    // Update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable String id,
                                                 @RequestParam("name") String name,
                                                 @RequestParam("age") int age,
                                                 @RequestParam("gender") String gender,
                                                 @RequestParam("employeeroll") String employeeroll,
                                                 @RequestParam("salary") String salary) {
        boolean updated = employeeService.updateEmployee(id, name, age, gender, employeeroll, salary);
        return updated ? ResponseEntity.ok("Employee updated successfully.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
    }

    // Delete employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        boolean deleted = employeeService.deleteEmployee(id);
        return deleted ? ResponseEntity.ok("Employee deleted successfully.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
    }

    // Get all login users
    @GetMapping("/employees/login")
    public List<employeelogin> getAllLogins() {
        return employeeService.getlogindetails();
    }

    // Verify login
    @PostMapping("/employees/login")
    public ResponseEntity<String> verifyLogin(@RequestParam("email") String email,
                                              @RequestParam("password") String password) {
        boolean isValid = employeeService.verifyLogin(email, password);
        return isValid ? ResponseEntity.ok("Login successful")
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    // Get all tasks
    @GetMapping("/employees/task")
    public List<employeetask> getAllTasks() {
        return employeeService.getemployeetask();
    }

    // Add task
    @PostMapping("/employees/task")
    public String addTask(@RequestParam("taskId") String taskId,
                          @RequestParam("employeeId") String employeeId,
                          @RequestParam("taskname") String taskname,
                          @RequestParam("taskmanager") String taskmanager,
                          @RequestParam("deadline") String deadline) {
        employeeService.employeetasks(taskId, employeeId, taskname, taskmanager, deadline);
        return "successfully added task";
    }

    // Update task
    @PutMapping("/employees/task/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable String taskId,
                                             @RequestParam("employeeId") String employeeId,
                                             @RequestParam("taskname") String taskname,
                                             @RequestParam("taskmanager") String taskmanager,
                                             @RequestParam("deadline") String deadline) {
        boolean updated = employeeService.updateTask(taskId, employeeId, taskname, taskmanager, deadline);
        return updated ? ResponseEntity.ok("Task updated successfully.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
    }

    // Delete task
    @DeleteMapping("/employees/task/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable String taskId) {
        boolean deleted = employeeService.deleteTask(taskId);
        return deleted ? ResponseEntity.ok("Task deleted successfully.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
    }

    @PostMapping("/contact")
    public String contactdetails(@RequestParam String email,
                                 @RequestParam String name,
                                 @RequestParam String message)
    {
        employeeService.contactdetails(email,name,message);
        return "message sent";
    }
}
