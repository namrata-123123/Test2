package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	FERService ferService = new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creating user object
		User user = new User();
		//Updating user properties
		user.setFirstname(request.getParameter("firstName"));
		user.setMiddlename(request.getParameter("middleName"));
		user.setLastname(request.getParameter("lastName"));
		user.setUsername(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("mobileNumber"));
		user.setMobile(request.getParameter("email"));
		//Calling registration from FERService
		boolean isRegister = ferService.registration(user);
		PrintWriter out=response.getWriter();
		String nextPath=null;
		//checking condition and Displaying the status
		if (isRegister) {
			out.println("Registration completed successfully<br>");
			nextPath="Login.html";
		} else {
			out.println("Registration failed");
			nextPath="Registration.html";
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(nextPath);
		requestDispatcher.include(request,response);
	}

	@Override
	public void destroy() {
		ferService = null;
	}
}
