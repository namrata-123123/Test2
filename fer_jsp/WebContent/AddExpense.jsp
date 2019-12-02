<jsp:include page="Layout/HeaderAndLeftFrame.jsp" />
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
<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">Add Expense</td>
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
		<td>Date<font color='red'>*</font></td>
		<td><input type="text" name="date"></td>
	</tr>
	<tr>
		<td>Price<font color='red'>*</font></td>
		<td><input type="text" name="price"></td>
	</tr>
	<tr>
		<td>Number of Items</td>
		<td><input type="number" name="numberOfItems"></td>
	</tr>
	<tr>
		<td>Total<font color='red'>*</font></td>
		<td><input type="number" name="total"></td>
	</tr>
	<tr>
		<td>By Whom<font color='red'>*</font></td>
		<td><input type="text" name="byWhom"></td>
	</tr>

	<tr>
		<td colspan="2" align="center"><input type="button"
			value="Add Expense"
			onclick="javascript:validateForm('AddExpensePost.jsp')"></td>
	</tr>
</table>

<jsp:include page="Layout/Footer.html" />
