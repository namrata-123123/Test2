<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%
	String username = request.getParameter("username");
	boolean isUsernameAvailable = new FERServiceImpl().isUsernameAvailable(username);

	out.println(isUsernameAvailable ? "Y" : "N");
%>