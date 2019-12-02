<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />	
	<script >
function validateForm(nextPath){
	var form=document.DashboardForm;
	var errorMessages='';
	if (form.expenseType.value ==''){
		errorMessages='please enter expenseType.';
		}
	if (form.fromDate.value ==''){
		errorMessages+='<BR>please enter fromDate.';
		}
	
	if (form.toDate.value ==''){
		errorMessages+='<BR>please enter toDate.';
		}
	
	if(errorMessages!=''){
		//alert(errorMessages);
		
		var errorTrIdObj=document.getElementById('errorTrId')
		var errorTdIdObj=document.getElementById('errorTdId')
		errorTdIdObj.innerHTML=errorMessages;
		errorTrIdObj.style.color='red';   
		errorTrIdObj.style.display='';
	}else{
		form.action=nextPath;
		
	}
	
	
}

</script>
					<table border="1" align="center">
						<tr>
							<td colspan="2" align="center">Expense Report</td>
						</tr>
						<tr style='display:none;' id='errorTrId'>
	<td colspan="2"id='errorTdId'>
	</td>
	</tr>
						<tr>
							<td>Expense Type<font color='red'>*</font></td>
							<td><input type="text" name="expenseType"></td>
						</tr>
						<tr>
							<td>From Date<font color='red'>*</font></td>
							<td><input type="text" name="fromDate"></td>
						</tr>
						<tr>
							<td>To Date<font color='red'>*</font></td>
							<td><input type="text" name="toDate"></td>
						</tr>
<tr>
		<td colspan="2" align="center"><input type="button"
			value="Get Report"onclick="javascript:validateForm('ExpenseReportPost.jsp')">
			</td>
		</td>
	</tr>
					</table>
<jsp:include page="Layout\Footer.html" />	