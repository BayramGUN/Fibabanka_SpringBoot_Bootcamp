package io.employee.department.mvc;

import java.util.ArrayList;

import io.employee.department.entity.Department;
import io.employee.department.entity.Employee;
import io.employee.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/company")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/department/insert")
	@ResponseBody
	public String insertDepartment()
	{
		Department departmentIT = new Department(0,"IT Department");
		departmentIT.setEmployeeList(new ArrayList<>());
		
		Employee employee1 = new Employee(0,"Harun Kiraz",54.22);
		employee1.setDepartment(departmentIT);
		departmentIT.getEmployeeList().add(employee1);
		
		Employee employee2 = new Employee(0,"Cem Demir",54.22);
		employee2.setDepartment(departmentIT);
		departmentIT.getEmployeeList().add(employee2);
		
	
		
		departmentRepository.save(departmentIT);
		
		return "Added department: " + departmentIT.getDepartmentId();
		
		
	}
	
}
