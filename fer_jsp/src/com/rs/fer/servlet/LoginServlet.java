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
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	FERService ferService = new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		//Calling login from FERService
		int userId = ferService.login(username, password);
		PrintWriter out = response.getWriter();
		String nextPath = null;
		//checking condition and Displaying status
		if (userId > 0) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("username", username);
			session.setAttribute("userId", userId);
			
			HTMLUtil.displayHeaderAndLeftFrame(request, response, out, username);
			
			out.println("Welcome to the user: "+username);
			
			HTMLUtil.displayFooter(request, response, out);

		} else {
			out.println("Login failed");
			nextPath = "Login.html";
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPath);
			requestDispatcher.include(request, response);
		}
		
	}
}