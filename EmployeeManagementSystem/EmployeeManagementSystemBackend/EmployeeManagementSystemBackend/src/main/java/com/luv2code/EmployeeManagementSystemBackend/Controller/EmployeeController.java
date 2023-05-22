package com.luv2code.EmployeeManagementSystemBackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.EmployeeManagementSystemBackend.Entity.Employee;
import com.luv2code.EmployeeManagementSystemBackend.Service.ServiceImpl;

import jakarta.validation.Valid;

@CrossOrigin(origins= "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	
	private ServiceImpl service;

	@Autowired
	public EmployeeController(ServiceImpl service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> emps = service.getAllEmployess();
		
		return emps;
	}
	
	
	 @PostMapping("employee/save")
	 public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
	     return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
	        
	  }
	 
	 
	   @GetMapping("employee/{id}")
	    public ResponseEntity<Employee> getPostById(@PathVariable(name = "id") long id){
	        return ResponseEntity.ok(service.getEmployeeById(id));
	    }
	   
	   @PutMapping("employee/update/{id}")
	    public ResponseEntity<Employee> updatePost(@Valid@RequestBody Employee employee, @PathVariable(name = "id") long id){

	      

	       return new ResponseEntity<>(service.updateEmployee(employee, id), HttpStatus.OK);
	    }
	   
	   
	   @DeleteMapping("employee/delete/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") long id){

	        service.deletePostById(id);

	        return new ResponseEntity<>("Employee entity deleted successfully.", HttpStatus.OK);
	    }
	
	
	
}
