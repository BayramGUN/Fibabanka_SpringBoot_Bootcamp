package io.employee.department.repository;

import java.util.List;

import io.employee.department.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	
	@Query("select e from Employee e where e.department.departmentId = :departmentId")
	List<Employee> findAllByDepartmentId(long departmentId);
	
	
	
}
