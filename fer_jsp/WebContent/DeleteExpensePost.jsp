<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
FERService ferService = new FERServiceImpl();


	int expenseId = Integer.parseInt(request.getParameter("expenseId").toString());

	boolean isDeleted = ferService.deleteExpense(expenseId);

%>

	<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />
<%
	if (isDeleted) {
		out.println("Expense deleted successfully");

} else {
		out.println("Expense not deleted");

	}
%>
	<jsp:include page="Layout\Footer.html" />

