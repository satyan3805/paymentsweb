<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.sat.tmf.dto.User" %>
<%@ page import="com.sat.tmf.dto.BankAccount" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sat.tmf.dao.PaymentsWebDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1>TMF Payments Web App</h1>

<%
		String sessionUser =null;

		<%--
		Cookie[] ckArr = request.getCookies();
		for(int i=0;i<ckArr.length;i++){
			if(ckArr[i].getName().equals("uname")){
				sessionUser = ckArr[i].getValue();
			}
		}
		--%>
		
		User sessionUser = (User)session.getAttribute("user");
	%>
				
	<%

	%>
	
	<%
		if(sessionUser != null)){
			PaymentsWebDAO dao =new PaymentsWebDAO();
			User user = dao.getUserByUserPhNo(sessionUser);
			
			request.setAttribute("user", user);
			List<BankAccount> baList=  dao.getBADetailsByuserId(user.getUserId());
			request.setAttribute("baList", baList);
			RequestDispatcher rd =  request.getRequestDispatcher("/DashBoardServlet");
			rd.forward(request, response);
	%>
				
				
			<%
		}else{
			%>
				<form action="http://localhost:8080/PaymentsWebApp/LoginAuthServlet" method="post">
					<table>
						<tr>
							<td>User Name:</td>
							<td><input type="text" name="uname" /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="upass" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Login"/></td>
						</tr>
					</table>
				</form>
				<form action="http://localhost:8080/PaymentsWebApp/signup.jsp">
					<input type="submit" value="Register"/>
				</form>
			<%
		}
	%>
	

</body>
</html>