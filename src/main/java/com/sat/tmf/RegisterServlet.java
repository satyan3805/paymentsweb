package com.sat.tmf;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sat.tmf.dao.PaymentsWebDAO;
import com.sat.tmf.dto.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PaymentsWebDAO dao = new PaymentsWebDAO();
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		String phNo = request.getParameter("phno");
		String email = request.getParameter("email");
		String address = request.getParameter("addr");
		
		if(dao.isUserExistsWithPhNo(phNo)) {
			response.setContentType("text/html");  
			response.getWriter().write("User Account Exists with Phone Number:"+phNo+".Please try with another Phone Numeber");
			RequestDispatcher rd =  request.getRequestDispatcher("/signup.jsp");
			rd.include(request, response);
		}else {
			User user = new User();
			user.setAddress(address);
			user.setCurrWallBalance(0.0d);

			SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			
			Date dateOfBirth;
			try {
				dateOfBirth = df.parse(dob);
				user.setDob(dateOfBirth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			user.setFirstName(fName);
			user.setLastName(lName);
			user.setPassword(password);
			user.setPhNo(Long.parseLong(phNo));
			
			dao.insertUser(user);
			
			RequestDispatcher rd =  request.getRequestDispatcher("/welcome.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
