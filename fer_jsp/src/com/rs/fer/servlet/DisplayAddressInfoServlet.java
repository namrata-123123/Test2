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
@WebServlet("/displayAddressInfo")
public class DisplayAddressInfoServlet extends HttpServlet {
	FERService ferService=new FERServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		User user=(User) session.getAttribute("user");
		
		user.setMobile(request.getParameter("mobile"));
		user.setEmail(request.getParameter("email"));
		
		PrintWriter out=response.getWriter();
		

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Address Info</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>AddressLine1</td>");
		out.println("<td><input type='text' name='addressLine1' value="+user.getAddress().getLineOne()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>AddressLine2</td>");
		out.println("<td><input type='text' name='addressLine2' value="+user.getAddress().getLineTwo()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='text' name='city' value="+user.getAddress().getCity()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='text' name='state' value="+user.getAddress().getState()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("<td><input type='text' name='country' value="+user.getAddress().getCountry()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Pincode</td>");
		out.println("<td><input type='text' name='zip' value="+user.getAddress().getZip()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		
		out.println("<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"displayPersonalReview\")'></td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response, out);

	}

	
}
