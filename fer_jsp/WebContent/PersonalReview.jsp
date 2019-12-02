 <%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.bean.Address"%>
<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />
<%

		Address address=new Address();
		User user=(User) session.getAttribute("user");
		address.setLineOne(request.getParameter("addressLine1"));
		address.setLineTwo(request.getParameter("addressLine2"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setCountry(request.getParameter("country"));
		address.setZip(request.getParameter("zip"));
		user.setAddress(address);
		
		

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
		
		out.println("<td colspan='2' align='centre'><input type='button' value='Update' onclick='javascript:submitForm(\"UpdatePersonalInfoPost.jsp\")'></td>");
		out.println("</tr>");
		out.println("</table>");

	


%>
<jsp:include page="Layout\Footer.html" />