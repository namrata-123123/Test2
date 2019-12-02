
<jsp:include page="Layout/HeaderAndLeftFrame.jsp" />

<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	FERService ferService = new FERServiceImpl();

	Expense expense = new Expense();
	// Getting expense properties
	expense.setType(request.getParameter("expenseType"));
	expense.setDate(request.getParameter("date"));
	expense.setPrice((Float.parseFloat(request.getParameter("price"))));
	expense.setNumberofitems((Integer.parseInt(request.getParameter("numberOfItems"))));
	expense.setTotal((Float.parseFloat(request.getParameter("total"))));
	expense.setByWhom((request.getParameter("byWhom")));
	expense.setUserid(Integer.parseInt(session.getAttribute("userId").toString()));
	//calling AddExpense from FERService
	boolean isExpenseAdded = ferService.addExpense(expense);

	//Checking condition and Displaying the status
	if (isExpenseAdded) {
		out.println("Expeneses addition success");
	} else {
		out.println("Expeneses addition failed");
	}
%>
<jsp:include page="Layout/Footer.html" />
