package com.pharmacy.model;

import javax.validation.constraints.NotBlank;

public class LoginForm 
{
	@NotBlank(message = "*Email can not be blank.")
	private String email;
	@NotBlank(message = "*Password is required")
	private String password;
	
	
	public LoginForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginForm(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
