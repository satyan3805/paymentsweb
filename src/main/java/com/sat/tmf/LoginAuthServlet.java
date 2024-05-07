package com.sat.tmf;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sat.tmf.dao.PaymentsWebDAO;
import com.sat.tmf.dto.BankAccount;
import com.sat.tmf.dto.User;

/**
 * Servlet implementation class LoginAuthServlet
 */
@WebServlet("/LoginAuthServlet")
public class LoginAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginAuthServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config=getServletConfig();  
		

		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		PaymentsWebDAO dao = new PaymentsWebDAO();
		
		if(dao.isValidUser(uname, upass)) {
			User user = dao.getUserByUserPhNo(uname);
			
			request.setAttribute("user", user);
			List<BankAccount> baList=  dao.getBADetailsByuserId(user.getUserId());
			request.setAttribute("baList", baList);
			Cookie ck = new Cookie("uname",uname);
			response.addCookie(ck);
			RequestDispatcher rd =  request.getRequestDispatcher("/DashBoardServlet");
			rd.forward(request, response);
		}else {
			response.setContentType("text/html");  
			response.getWriter().write("Invalid Credentials");
			RequestDispatcher rd =  request.getRequestDispatcher("/welcome.jsp");
			rd.include(request, response);
			
		}
	}

}
