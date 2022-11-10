package io.employee.department.repository;

import org.springframework.data.repository.CrudRepository;

import io.employee.department.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>{

}
