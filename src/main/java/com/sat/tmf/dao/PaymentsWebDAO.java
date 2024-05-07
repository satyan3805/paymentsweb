package com.sat.tmf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sat.tmf.dto.BankAccount;
import com.sat.tmf.dto.User;

public class PaymentsWebDAO {
	public boolean isValidUser(String uname, String upass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentsweb","root","root");
			Statement stmt = con.createStatement();
			String query = "select * from users where phoneno='"+uname+"' and PassWord='"+upass+"'";
			System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				return true;
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean insertUser(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentsweb","root","root");
			Statement stmt = con.createStatement();
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			
			String query = "insert into users(FirstName, LastName,PhoneNo,DateOfBirth,Address,Password,CurrWalletBal)\r\n"
					+ "values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getPhNo()+"','"+df.format(user.getDob())+"','"+user.getAddress()+"','"+user.getPassword()+"',"+user.getCurrWallBalance()+")";
			System.out.println(query);
			stmt.executeUpdate(query);
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean isUserExistsWithPhNo(String phno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentsweb","root","root");
			Statement stmt = con.createStatement();

			String query = "select * from users u where u.PhoneNo='"+phno+"'";
			System.out.println(query);
			ResultSet rs= stmt.executeQuery(query);
			if(rs.next()) {
				return true;
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
		
	}
	
	public User getUserByUserPhNo(String phno) {
		User user = new User();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentsweb","root","root");
			Statement stmt = con.createStatement();

			String query = "select * from users u where u.PhoneNo='"+phno+"'";
			System.out.println(query);
			ResultSet rs= stmt.executeQuery(query);
			if(rs.next()) {
				String fName = rs.getString("firstname");
				String lName = rs.getString("LastName");
				String phNo = rs.getString("PhoneNo");
				int userId = rs.getInt("UserId");
				double currWABal = rs.getDouble("CurrWalletBal");
				
				user.setFirstName(fName);
				user.setLastName(lName);
				user.setCurrWallBalance(currWABal);
				user.setPhNo(Long.parseLong(phNo));
				user.setUserId(userId);
				
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return user;
		
	}
	
	public List<BankAccount> getBADetailsByuserId(int userId) {
		List<BankAccount> baList = new ArrayList<BankAccount>();
		User user = new User();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentsweb","root","root");
			Statement stmt = con.createStatement();

			String query = "select * from BankAccounts ba where ba.userId="+userId;
			System.out.println(query);
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next()) {
				BankAccount ba = new BankAccount();
				
				//BankAcctPin

				String baNumber = rs.getString("BankAcctNo");
				String baName = rs.getString("BankName");
				String acctType = rs.getString("AcctTypeId");
				String ifscCode = rs.getString("BankIFSCCode");
//				String userId = rs.getString("UserId");
				String currBaBal = rs.getString("CurrBankAcctBalance");
				
				ba.setAcctTypeId(acctType);
				ba.setBaName(baName);
				ba.setBaNumber(baNumber);
				ba.setCurrBal(Double.parseDouble(currBaBal));
				ba.setIfscCode(ifscCode);
				ba.setUserId(userId);
				baList.add(ba);

			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return baList;
		
	}
	
}
