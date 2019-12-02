package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;
@WebServlet("/displayPersonalNameInfo")
public class DisplayPersonalNameInfoServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService=new FERServiceImpl();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
		
		User user = ferService.getPersonalInfo(userId);
		session.setAttribute("user",user);

		String username = (session.getAttribute("username") != null ? session.getAttribute("username").toString() : "");

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, username);

		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Personal Info</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>First Name</td>");
		out.println("<td><input type='text' name='firstName' value="+user.getFirstname()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Middle Name</td>");
		out.println("<td><input type='text' name='middleName' value="+user.getMiddlename()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Last Name</td>");
		out.println("<td><input type='text' name='lastName' value="+user.getLastname()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"displayContactInfo\")'></td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response, out);

	}


}
