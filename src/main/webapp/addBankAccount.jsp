<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bank Account</title>
</head>
<body>
	<%
		String sessionUser =null;
		Cookie[] ckArr = request.getCookies();
		for(int i=0;i<ckArr.length;i++){
			if(ckArr[i].getName().equals("uname")){
				sessionUser = ckArr[i].getValue();
	%>
	
	<%
			}
		}
	%>
	
	<%
		if(sessionUser != null && !"".equals(sessionUser.trim())){
			%>
				<h1> Add Bank Account</h1><%=sessionUser %>
				
			<%
		}else{
			response.setContentType("text/html");  
			response.getWriter().write("Invalid User");
			RequestDispatcher rd =  request.getRequestDispatcher("/welcome.jsp");
			rd.include(request, response);
		}
	%>
	
</body>
</html>