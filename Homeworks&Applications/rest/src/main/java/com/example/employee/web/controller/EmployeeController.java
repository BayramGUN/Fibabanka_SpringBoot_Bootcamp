package com.example.employee.web.controller;


import com.example.employee.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class EmployeeController {

    @GetMapping("/employee")
    @ResponseBody
    public String getEmployee() {
        long employeeId = 360;
        String url = "http://localhost:8080/api/employee/" + employeeId;
        RestTemplate restTemplate = new RestTemplate();
        Employee employee = restTemplate.getForObject(url, Employee.class);
        System.out.println("Ürün: " + employee.getEmployeeName());
        return "<h1>Edinme başarılı!</h1><br>"
                + employee.getEmployeeName()
                + " adlı çalışanın aylık maaşı: "
                + employee.getMonthlySalary() + " TL";
    }
    @GetMapping("/employee/post")
    @ResponseBody
    public String postEmployee() {
        Employee employee = new Employee(0, "Firitöz", 2199.99);
        String url = "http://localhost:8080/api/employee/";
        RestTemplate restTemplate = new RestTemplate();
        Employee result = restTemplate.postForObject(url, employee, Employee.class);
        return "<h1>Yollama başarılı!</h1><br>" + result.getEmployeeId() + " numaralı id ile çalışan oluşturuldu!";
    }
    @GetMapping("/employee/put")
    @ResponseBody
    public String putEmployee() {
        Employee employee = new Employee(302, "Tablet Bilgisayar", 3199.99);
        String url = "http://localhost:8080/api/employee/";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<Employee>(employee),
                Void.class
        );

        // restTemplate.put(url, employee);

        return "<h1>Koyma başarılı!</h1><br>" + employee.getEmployeeId() + " idli çalışan güncellendi";
    }
    @GetMapping("/employee/delete")
    @ResponseBody
    public String deleteEmployee() {
        long employeeId = 303;
        String url = "http://localhost:8080/api/employee/" + employeeId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "<h1>Silme başarılı!</h1><br>" + employeeId + " idli çalışan silindi";
    }
}
