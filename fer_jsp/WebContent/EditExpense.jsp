<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />
<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<script>
function validateForm(nextPath){
	var form=document.DashboardForm;
	var errorMessages='';
	if (form.expenseType.value ==''){
		errorMessages='please enter expenseType.';
		}
	if (form.date.value ==''){
		errorMessages+='<BR>please enter date.';
		}
	
	if (form.price.value ==''){
		errorMessages+='<BR>please enter price.';
		}
	if (form.total.value ==''){
		errorMessages+='<BR>please enter total .';
		}
	if (form.byWhom.value ==''){
		errorMessages+='<BR>please enter byWhom.';
		}
	
	if(errorMessages!=''){
		//alert(errorMessages);
		
		var errorTrIdObj=document.getElementById('errorTrId')
		var errorTdIdObj=document.getElementById('errorTdId')
		errorTdIdObj.innerHTML=errorMessages;
		errorTrIdObj.style.color='red';   
		errorTrIdObj.style.display='';
	}else{
		submitForm(nextPath);
	}
	
	
}

</script>
<%
FERService ferService = new FERServiceImpl();



int expenseId = Integer.parseInt(request.getParameter("expenseId").toString());
Expense expense = ferService.getExpense(expenseId);

session.setAttribute("expense", expense);

	out.println("<table border='1' align='center'>");
	out.println("<tr>");
	out.println("<td colspan='2' align='center'>Edit Expense</td>");
	out.println("</tr>");
	out.println("<tr style='display:none;' id='errorTrId'>");
	out.println("<td colspan='2'id='errorTdId'>");
	out.println("</td>");
	out.println("<tr>");
	out.println("<tr>");
	out.println("<td>Expense Type<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='expenseType' value=" + expense.getType() + "></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Date<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='date' value=" + expense.getDate() + "></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Price<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='price' value=" + expense.getPrice() + "></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Number of Items</td>");
	out.println("<td><input type='number' name='numberOfItems' value=" + expense.getNumberofitems() + "></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Total<font color='red'>*</font></td>");
	out.println("<td><input type='number' name='total' value=" + expense.getTotal() + "></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>By Whom<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='byWhom' value=" + expense.getByWhom() + "></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<input type='button' value='Edit' onclick='javascript:validateForm(\"EditExpensePost.jsp\")'>");
	out.println("</tr>");
	out.println("</table>");

	
%>
<jsp:include page="Layout\Footer.html" />