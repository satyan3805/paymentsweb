package com.sat.tmf;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sat.tmf.dto.User;

/**
 * Servlet implementation class DashBoardServlet
 */
@WebServlet("/DashBoardServlet")
public class DashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet @ DashBoardServlet");
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String uname =request.getParameter("uname");
//		ArrayList<String> attribOne = (ArrayList<String>)request.getAttribute("dummyAttrib");
//		System.out.println("doPost @ DashBoardServlet ::"+uname+"::"+attribOne);
//		Cookie ck = new Cookie("uname", "satya");
//		response.addCookie(ck);
//		Cookie ck1 = new Cookie("uid", "12341234");
//		response.addCookie(ck1);
		HttpSession  session = request.getSession();
		User sessionUser = (User)session.getAttribute("user");
		if(sessionUser != null) {
			response.setContentType("text/html");  
			request.setAttribute("uname", sessionUser);
			RequestDispatcher rd =  request.getRequestDispatcher("/dashboard.jsp");
			rd.forward(request, response);
		}else {
			response.setContentType("text/html");  
			response.getWriter().write("Invalid Credentials");
			RequestDispatcher rd =  request.getRequestDispatcher("/welcome.jsp");
			rd.include(request, response);
		}
		
		
	}

}
