package com.luv2code.EmployeeManagementSystemBackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luv2code.EmployeeManagementSystemBackend.CustomExceptions.ResourceNotFoundExceptions;
import com.luv2code.EmployeeManagementSystemBackend.Entity.Employee;
import com.luv2code.EmployeeManagementSystemBackend.Repository.EmployeeRepository;



@Service
public class ServiceImpl implements EmployeeService{
	
	private EmployeeRepository repo;

	@Autowired
	public ServiceImpl(EmployeeRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		
		Employee emp = new Employee();
		
		emp.setFirst_name(employee.getFirst_name());
		emp.setSecond_name(employee.getSecond_name());
		emp.setEmail(employee.getEmail());
		emp.setRole(employee.getRole());
		
		
		
		
		
		try {
			
			
			Long maxId = repo.findMaxId();
			
			Long newId = maxId != null ? maxId + 1 : 1;
			
			emp.setId(newId);
			
			
	        repo.save(emp);
	    } catch (DataIntegrityViolationException e) {
	        // Handle the exception here
	        if (e.getMessage().contains("unique_name")) {
	            throw new IllegalArgumentException("Employee with the same first name and last name already existed.");
	        } else if (e.getMessage().contains("unique_email")) {
	            throw new IllegalArgumentException("Email is already existed in the database.");
	        } else {
	            throw new IllegalArgumentException("Duplicate entry error.");
	        }
	    }
		
		
		
		return emp;
	}

	
	@Override
	public List<Employee> getAllEmployess() {
		
		List<Employee> emps = repo.findAll();
		
		return emps;
		
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		Employee emp = repo.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Employee", "id", id));
	    
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		
		Employee emp = repo.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Employee", "id", id));
		
		emp.setFirst_name(employee.getFirst_name());
		emp.setSecond_name(employee.getSecond_name());
		emp.setEmail(employee.getEmail());
		emp.setRole(employee.getRole());
		
		
		try {
	        repo.save(emp);
	    } catch (DataIntegrityViolationException e) {
	        // Handle the exception here
	        if (e.getMessage().contains("unique_name")) {
	            throw new IllegalArgumentException("Employee with the same first name and last name already existed.");
	        } else if (e.getMessage().contains("unique_email")) {
	            throw new IllegalArgumentException("Email is already existed in the database.");
	        } else {
	            throw new IllegalArgumentException("Duplicate entry error.");
	        }
	    }
		
		
		return emp;
		
	}

	@Override
	public void deletePostById(Long Id) {
		Employee emp = repo.findById(Id).orElseThrow(() -> new ResourceNotFoundExceptions("Employee", "id", Id));
		
		repo.delete(emp);
		
	}
	
	
	
	
	

}
