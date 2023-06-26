package com.login.model;

public class User {

	public String emailId;
	public String password;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + password + "]";
	}
	
	
}
