<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register New User</title>
</head>
<body>
	<form action="http://localhost:8080/PaymentsWebApp/RegisterServlet" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="dob" /></td>
			</tr>
			<tr>
				<td>Phone No:</td>
				<td><input type="text" name="phno" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="addr" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Register" /></td>
			</tr>
		</table>
	</form>
</body>
</html>