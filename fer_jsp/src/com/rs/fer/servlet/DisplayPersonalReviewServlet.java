package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;
@WebServlet("/displayPersonalReview")
public class DisplayPersonalReviewServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		Address address=new Address();
		User user=(User) session.getAttribute("user");
		address.setLineOne(request.getParameter("addressLine1"));
		address.setLineTwo(request.getParameter("addressLine2"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setCountry(request.getParameter("country"));
		address.setZip(request.getParameter("zip"));
		user.setAddress(address);
		
		PrintWriter out=response.getWriter();
		
		String username = (session.getAttribute("username") != null ? session.getAttribute("username").toString() : "");

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, username);

		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Review</td>");
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
		out.println("<td>Mobile</td>");
		out.println("<td><input type='text' name='mobile' value="+user.getMobile()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>email</td>");
		out.println("<td><input type='text' name='email' value="+user.getEmail()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>AddressLine1</td>");
		out.println("<td><input type='text' name='mobile' value="+user.getAddress().getLineOne()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>AddressLine2</td>");
		out.println("<td><input type='text' name='mobile' value="+user.getAddress().getLineTwo()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='text' name='email' value="+user.getAddress().getCity()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='text' name='email' value="+user.getAddress().getState()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("<td><input type='text' name='email' value="+user.getAddress().getCountry()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Pincode</td>");
		out.println("<td><input type='text' name='email' value="+user.getAddress().getZip()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button' value='Update' onclick='javascript:submitForm(\"updatePersonalInfo\")'></td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response, out);

	}

		
		
		
	}		

