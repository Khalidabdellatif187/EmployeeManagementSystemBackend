package com.luv2code.EmployeeManagementSystemBackend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="employee")
public class Employee {

	
	
	@Id
	@Column(name="id")
	private Long id;
	
	
	@Column(name="first_name")
	@NotEmpty(message="First name cannot be empty")
	@Size(min = 2 , message = "First name must have at least two charcters")
	private String first_name;
	
	@Column(name="second_name")
	@NotEmpty(message="Second name cannot be empty")
	@Size(min = 2 , message = "Second name must have at least two charcters")
	private String second_name ; 
	
	@Column(name="email")
	@NotEmpty(message="Email cannot be empty")
	@Pattern(regexp = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$" , message = "email is not valid")
	private String email;
	
	
	@Column(name="role")
	@NotEmpty(message="Role cannot be empty")
	@Size(min = 2 , message = "Role must have at least two charcters")
	private String role;

	
	
	public Employee() {
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getSecond_name() {
		return second_name;
	}



	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", second_name=" + second_name + ", email=" + email
				+ ", role=" + role + "]";
	}



	public Employee(
			@NotEmpty(message = "First name cannot be empty") @Size(min = 2, message = "First name must have at least two charcters") String first_name,
			@NotEmpty(message = "Second name cannot be empty") @Size(min = 2, message = "Second name must have at least two charcters") String second_name,
			@NotEmpty(message = "Email cannot be empty") @Pattern(regexp = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", message = "email is not valid") String email,
			@NotEmpty(message = "Role cannot be empty") @Size(min = 2, message = "Role must have at least two charcters") String role) {
		super();
		this.first_name = first_name;
		this.second_name = second_name;
		this.email = email;
		this.role = role;
	}



	public Employee(Long id,
			@NotEmpty(message = "First name cannot be empty") @Size(min = 2, message = "First name must have at least two charcters") String first_name,
			@NotEmpty(message = "Second name cannot be empty") @Size(min = 2, message = "Second name must have at least two charcters") String second_name,
			@NotEmpty(message = "Email cannot be empty") @Pattern(regexp = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", message = "email is not valid") String email,
			@NotEmpty(message = "Role cannot be empty") @Size(min = 2, message = "Role must have at least two charcters") String role) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.second_name = second_name;
		this.email = email;
		this.role = role;
	}
	
	


}
