


<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%

FERService ferService = new FERServiceImpl();
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
String nextPath=null;
//checking condition and Displaying the status
if (isRegister) {
	%>
	<jsp:forward page="Login.html"/>
<%} else {
	out.println("Registration failed");

%>
	<jsp:include page="Registration.html"/>
<%
}
%>