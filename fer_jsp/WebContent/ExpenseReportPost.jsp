<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />


<%@page import="java.util.Iterator"%>
<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
	
<%
FERService ferService = new FERServiceImpl();

int userId=Integer.parseInt(session.getAttribute("userId").toString());
	String expenseType = request.getParameter("expenseType");
	String fromDate = request.getParameter("FromDate");
	String toDate = request.getParameter("toDate");

	

	
	List<Expense> expenseReport = ferService.expenseReport(userId, expenseType, fromDate, toDate);

	if (expenseReport != null && !expenseReport.isEmpty()) {
		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='6' align='center'>Expense Report</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td>Date</td>");
		out.println("<td>Price</td>");
		out.println("<td>Number of Items</td>");
		out.println("<td>Total</td>");
		out.println("<td align='center'>Actions</td>");
		out.println("</tr>");

		Iterator<Expense> iterator = expenseReport.iterator();
		Expense expense = null;
		while (iterator.hasNext()) {
			expense = iterator.next();
			out.println("<tr>");
			out.println("<td>" + expense.getType() + "</td>");
			out.println("<td>" + expense.getDate() + "</td>");
			out.println("<td>" + expense.getPrice() + "</td>");
			out.println("<td>" + expense.getNumberofitems()+ "</td>");
			out.println("<td>" + expense.getTotal() + "</td>");

			out.println("<td><a href='#'>Edit</a>&nbsp&nbsp&nbsp<a href='#'>Delete</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");

	} else {
		out.println("No expense records found");
	}
%>
<jsp:include page="Layout\Footer.html" />