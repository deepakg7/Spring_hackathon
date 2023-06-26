package com.register.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	public String emailId;
	public String name;
	public String Address;
	public String accountNo;
	public int mobileNo;
	public String password;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String emailId, String name, String address, String accountNo, int mobileNo, String password) {
		super();
		this.emailId = emailId;
		this.name = name;
		Address = address;
		this.accountNo = accountNo;
		this.mobileNo = mobileNo;
		this.password = password;
	}
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", name=" + name + ", Address=" + Address + ", accountNo=" + accountNo
				+ ", mobileNo=" + mobileNo + ", password=" + password + "]";
	}
	
	
}
