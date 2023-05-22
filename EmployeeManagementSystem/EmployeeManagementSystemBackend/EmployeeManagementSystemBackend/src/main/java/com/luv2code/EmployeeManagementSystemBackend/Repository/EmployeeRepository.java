package com.luv2code.EmployeeManagementSystemBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.EmployeeManagementSystemBackend.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
