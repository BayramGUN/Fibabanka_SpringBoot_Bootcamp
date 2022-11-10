package io.employee.department.mvc;

import java.util.List;

import io.employee.department.entity.Employee;
import io.employee.department.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees/bydepartment")
	@ResponseBody
	public String getEmployeesByDepartmentId()
	{
		long departmentId = 1;
		List<Employee> employees = employeeRepository.findAllByDepartmentId(departmentId);
		int count = 0;
		for(Employee employee: employees) {
			System.out.println(employee.getEmployeeId()+" "+
					employee.getEmployeeName() + " " +
					employee.getMonthlySalary());
			count++;
		}
		
		return "Total emloyee number in this department: " + count;
	}
}
