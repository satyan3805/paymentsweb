package com.sat.tmf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie ck = new Cookie("uname","");
//		response.addCookie(ck);
		response.setContentType("text/html");  
		response.getWriter().write("User Successfully Logged out");
		
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		RequestDispatcher rd =  request.getRequestDispatcher("/welcome.jsp");
		rd.include(request, response);
	}

}
