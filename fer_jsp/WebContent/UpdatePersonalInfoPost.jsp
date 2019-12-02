<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%

	FERService ferService = new FERServiceImpl();
	User user = (User) session.getAttribute("user");
	boolean isPersonalUpdated = ferService.updatePersonalInfo(user);
%>
<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />

<%	if (isPersonalUpdated) {
		out.println("personal info updated successfully");
	} else {
		out.println("personal info not updated");
	}
%>
	<jsp:include page="Layout\Footer.html" />

