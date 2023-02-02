package com.pharmacy.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UserForm 
{
	@NotBlank(message = "*Email can not be blank")
	private String email;
	@NotBlank(message = "*Frist name can not be blank")
	private String firstName;
	@NotBlank(message = "*Last name can not be blank")
	private String lastName;
	@NotBlank(message = "*Address is required")
	private String address;
	@NotBlank(message = "*Password is required")
	@Min(value = 5, message = "*Password must have at least 5 characters")
	private String password;
	
	public UserForm()
	{
		
	}

	public UserForm(String email, String firstName, String lastName, String address, String password) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
