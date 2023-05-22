package com.luv2code.EmployeeManagementSystemBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luv2code.EmployeeManagementSystemBackend.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT MAX(employee.id) FROM Employee employee")
	public Long findMaxId();

}
