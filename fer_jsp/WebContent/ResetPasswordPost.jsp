<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
FERService ferService =  new FERServiceImpl();

	int id= Integer.parseInt(session.getAttribute("userId").toString());
	
	String currentPassword = request.getParameter("currentPassword");
	String newPassword = request.getParameter("newPassword");
	String confirmPassword = request.getParameter("confirmPassword");
	
	boolean isValiduser = ferService.resetPassword(id, currentPassword, newPassword);
	
	String nextPath = null;
%>
<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />
<%	
	if (isValiduser) {
		out.println("Password Reset Successfull...");
%>
<jsp:include page="Layout\Footer.html" />
<%} else {
		out.println("Password Reset failed");
%>
<jsp:include page="Layout\Footer.html" />
<%
	}	
%>
