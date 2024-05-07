package com.sat.tmf.dto;

public class BankAccount {
	String baNumber;
	String baName;
	String acctTypeId;
	String ifscCode;
	int userId;
	double currBal;
	
	public String getBaNumber() {
		return baNumber;
	}
	public void setBaNumber(String baNumber) {
		this.baNumber = baNumber;
	}
	public String getBaName() {
		return baName;
	}
	public void setBaName(String baName) {
		this.baName = baName;
	}
	public String getAcctTypeId() {
		return acctTypeId;
	}
	public void setAcctTypeId(String acctTypeId) {
		this.acctTypeId = acctTypeId;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getCurrBal() {
		return currBal;
	}
	public void setCurrBal(double currBal) {
		this.currBal = currBal;
	}
	
	
}
