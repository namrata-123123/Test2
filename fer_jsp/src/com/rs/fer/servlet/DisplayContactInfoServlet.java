package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/displayContactInfo")
public class DisplayContactInfoServlet extends HttpServlet {
	FERService ferService=new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		User user=(User) session.getAttribute("user");
		int userId=Integer.parseInt(session.getAttribute("userId").toString());

		user.setFirstname(request.getParameter("firstName"));
		user.setMiddlename(request.getParameter("middleName"));
		user.setLastname(request.getParameter("lastName"));
		user.setId(userId);
		PrintWriter out=response.getWriter();
		

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Contact Info</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Mobile</td>");
		out.println("<td><input type='text' name='mobile' value="+user.getMobile()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>email</td>");
		out.println("<td><input type='text' name='email' value="+user.getEmail()+"></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"displayAddressInfo\")'></td>");
		out.println("</tr>");

		out.println("</table>");

		HTMLUtil.displayFooter(request, response, out);

	}

}
