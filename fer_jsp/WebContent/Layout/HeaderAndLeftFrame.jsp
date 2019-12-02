<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title></html>
<style>
body {
   background-image: url("file:///C:/Users/Priya/eclipse-workspace/FER_Servlet/WebContent/Layout/texture-pattern-background-paint-wallpaper-preview.jpg");
  background-position: 50% 50%;
  background-repeat: no-repeat;
}
</style>
		<script>
			function submitForm(nextPath) {
				var form = document.DashboardForm;
				form.action = nextPath;
				form.submit();
			}
		</script>
	</head>
	
	<body>
	
	
		<form action="" name="DashboardForm" method="post">
			<table border="1" align="center" height="600px" width="600px">
				<tr height="100px">
					<td colspan="2" align="center">Family Expense Report :${username}
					</td>

</tr>
<tr>
	<td width="150px" align="center"><a
		href="javascript:submitForm('AddExpense.jsp')">Add Expense</a><Br></br>
		<a href="javascript:submitForm('EditExpenseOption.jsp')">Edit Expense</a><br></br> 
		<a href="javascript:submitForm('DeleteExpense.jsp')">Delete Expense</a><br></br> <a
		href="javascript:submitForm('ExpenseReport.jsp')">Expense report</a><br></br> <a
		href="javascript:submitForm('ResetPassword.jsp')">Reset Password</a><br></br> <a
		href="javascript:submitForm('PersonalNameInfo.jsp ')">Update Personal</a></td>
	<td align="center">