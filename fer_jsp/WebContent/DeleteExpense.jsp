 <jsp:include page="Layout\HeaderAndLeftFrame.jsp" />
 <%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<%
int userId = Integer.parseInt(session.getAttribute("userId").toString());
FERService ferService = new FERServiceImpl();



List<Expense> expenses = ferService.getExpenses(userId);

out.println("ExpenseId:");
out.println("<select name='expenseId'>");

for (Expense expense : expenses) {
	out.println("<option value=" + expense.getId() + ">" + expense.getType() + "," + expense.getPrice()
			+ "</option>");
}
out.println("</select>");
out.println("<br></br>");
out.println("<input type='button' value='Delete Expense' onclick='javascript:submitForm(\"DeleteExpensePost.jsp\")'>");

%>
<jsp:include page="Layout\Footer.html" />