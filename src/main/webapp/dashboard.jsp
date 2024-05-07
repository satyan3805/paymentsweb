<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.sat.tmf.dto.User" %>
<%@ page import="com.sat.tmf.dto.BankAccount" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payments Web App Dash Board</title>
</head>
<body>
	<center>
		<div>
		<table border="0">
			<tr>
				<td>
					<h1>Payments Web App</h1>
				</td>
			</tr>
			<tr>
				<td>
					<h3>Welcome <%=((User)request.getAttribute("user")).getLastName()%> ! </h3>
				</td>
				<td align="right">
					<form action="http://localhost:8080/PaymentsWebApp/LogoutServlet">
						<input type="submit" value="Logout"/>
					</form>
				</td>
			</tr>
		</table>
		</div>
		
		<div>
			<% List<BankAccount> baList = (List<BankAccount>)request.getAttribute("baList"); %>
			<table border="">
				<tr>
				<%for(int i=0;i<baList.size();i++){
					BankAccount ba = baList.get(i);
				%>
					<td>
						BANK NAME: <%=ba.getBaName() %></br>
						BANK Acct No: <%=ba.getBaNumber() %></br>
						Curr Balance: <%=ba.getCurrBal() %></br>
						IFSC CODE: <%=ba.getIfscCode() %></br>
						BRANCH:
					</td>
				<%} %>
					<td>
						<form>
							<input type="submit" value="Add Bank Account" />
						</form>
					</td>
				</tr>
			</table>
			
				
			
			
			
		</div>
	</center>
	
	
</body>
</html>