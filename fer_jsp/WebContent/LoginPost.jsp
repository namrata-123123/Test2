<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
    FERService ferService = new FERServiceImpl();
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	int userId = ferService.login(username, password);
	
	String nextPath = null;

	if (userId > 0) {
				
		session.setAttribute("username", username);
		session.setAttribute("userId", userId);
%>
<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />
<% 
		out.println("Welcome to the user: "+username);
%>
<jsp:include page="Layout\Footer.html" />
<%

	} else {
		out.println("Login failed due to incorrect username/password. Please try again..");
			

%>
<jsp:include page="Login.html" />
<%
}
%>
