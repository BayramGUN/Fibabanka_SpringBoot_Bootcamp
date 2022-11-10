package com.example.employee.controller;

import com.example.employee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeResource {
    @GetMapping("/api/employee")
    public Employee getEmployee() {
        Employee employee = new Employee(301, "Ferhat", 10450.0);
        return employee;
    }
    @GetMapping("/api/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") long employeeId) {

        Employee employee = new Employee(employeeId,"Ferhat", 1450.0);
        return employee;
    }
    @GetMapping("/api/employees")
    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(302, "Bayram", 9500.0));
        employeeList.add(new Employee(303, "Gizem", 14499.0));
        employeeList.add(new Employee(304, "Suat", 3490.0));
        return employeeList;
    }
    @PostMapping("/api/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setEmployeeId(310);
        System.out.println("Çalışan eklendi " + employee.getEmployeeId()
                + " " + employee.getEmployeeName()
                + " " + employee.getMonthlySalary()
        );
        return employee;
    }
    @PutMapping("/api/employee")
    public void updateEmployee(@RequestBody Employee employee) {
        System.out.println("Çalışan güncellendi " + employee.getEmployeeId()
                + " " + employee.getEmployeeName()
                + " " + employee.getMonthlySalary()
        );
    }
    @DeleteMapping("/api/employee/{id}")
    public void deleteEmployeeById(@PathVariable("id") long employeeId) {
        System.out.println(employeeId + " idli ürün silindi!");
    }
}
