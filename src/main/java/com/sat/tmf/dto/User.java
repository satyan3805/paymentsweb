package com.sat.tmf.dto;

import java.util.Date;

public class User {
	
	int userId;
	String firstName;
	String lastName;
	long phNo;
	Date dob;
	String address;
	String password;
	double currWallBalance;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	public double getCurrWallBalance() {
		return currWallBalance;
	}
	public void setCurrWallBalance(double currWallBalance) {
		this.currWallBalance = currWallBalance;
	}
}
