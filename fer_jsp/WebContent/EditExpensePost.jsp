<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
FERService ferService =  new FERServiceImpl();
Expense expense = new Expense();

    expense = (Expense) session.getAttribute("expense");
	expense.setType(request.getParameter("expenseType"));
	expense.setDate(request.getParameter("date"));
	expense.setPrice(Float.parseFloat(request.getParameter("price").toString()));
	expense.setNumberofitems(Integer.parseInt(request.getParameter("numberOfItems").toString()));
	expense.setTotal(Float.parseFloat(request.getParameter("total").toString()));
	expense.setByWhom(request.getParameter("byWhom"));
		String username = (session.getAttribute("username") != null ? session.getAttribute("username").toString() : "");
	
		boolean isEdited = ferService.editExpense(expense);
%>
	<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />
<%
	if (isEdited) {
		out.println("Expense edited successfully");
		
} else {
		out.println("failed");

	}
%>
	<jsp:include page="Layout\Footer.html" />

