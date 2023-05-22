package com.luv2code.EmployeeManagementSystemBackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.luv2code.EmployeeManagementSystemBackend.Controller.EmployeeController;
import com.luv2code.EmployeeManagementSystemBackend.Entity.Employee;
import com.luv2code.EmployeeManagementSystemBackend.Service.ServiceImpl;



public class ControllerTest {
	
	@Mock
    private ServiceImpl service;

    @InjectMocks
    private EmployeeController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        // Prepare test data
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "John", "Doe", "john@example.com", "Role"));
        employees.add(new Employee(2L, "Jane", "Smith", "jane@example.com", "Role"));

        when(service.getAllEmployess()).thenReturn(employees);

        // Call the controller method
        List<Employee> result = controller.getAllEmployees();

        // Assertions
        assertEquals(employees, result);
        verify(service, times(1)).getAllEmployess();
    }

    @Test
    void testCreateEmployee() {
        // Prepare test data
        Employee employee = new Employee("John", "Doe", "john@example.com", "Role");
        Employee savedEmployee = new Employee(1L, "John", "Doe", "john@example.com", "Role");

        when(service.createEmployee(employee)).thenReturn(savedEmployee);

        // Call the controller method
        ResponseEntity<Employee> response = controller.createEmployee(employee);

        // Assertions
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedEmployee, response.getBody());
        verify(service, times(1)).createEmployee(employee);
    }

    @Test
    void testGetEmployeeById() {
        // Prepare test data
        long id = 1L;
        Employee employee = new Employee(id, "John", "Doe", "john@example.com", "Role");

        when(service.getEmployeeById(id)).thenReturn(employee);

        // Call the controller method
        ResponseEntity<Employee> response = controller.getPostById(id);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee, response.getBody());
        verify(service, times(1)).getEmployeeById(id);
    }

    @Test
    void testUpdateEmployee() {
        // Prepare test data
        long id = 1L;
        Employee employee = new Employee(id, "John", "Doe", "john@example.com", "Role");
        Employee updatedEmployee = new Employee(id, "John", "Smith", "john@example.com", "Role");

        when(service.updateEmployee(employee, id)).thenReturn(updatedEmployee);

        // Call the controller method
        ResponseEntity<Employee> response = controller.updatePost(employee, id);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedEmployee, response.getBody());
        verify(service, times(1)).updateEmployee(employee, id);
    }

    @Test
    void testDeleteEmployee() {
        // Prepare test data
        long id = 1L;

        // Call the controller method
        ResponseEntity<String> response = controller.deleteEmployee(id);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Employee entity deleted successfully.", response.getBody());
        verify(service, times(1)).deletePostById(id);
    }

}
