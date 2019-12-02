<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />

<script >
function validateForm(nextPath){
	var form=document.DashboardForm;
	var errorMessages='';
	if (form.currentPassword.value ==''){
		errorMessages='please enter currentpassword.';
		}
	if (form.newPassword.value ==''){
		errorMessages+='<BR>please enter newPassword.';
		}
	
	if (form.confirmPassword.value ==''){
		errorMessages+='<BR>please enter confirmPassword.';
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
							<td colspan="2" align="center">Reset Password</td>
						</tr>
						<tr style='display:none;' id='errorTrId'>
			<td colspan="2"id='errorTdId'>
			</td>
			</tr>
						
						<tr>
							<td>Current Password<font color='red'>*</font></td>
							<td><input type="text" name="currentPassword"></td>
						</tr>
						<tr>
							<td>New Password<font color='red'>*</font></td>
							<td><input type="text" name="newPassword"></td>
						</tr>
						<tr>
							<td>Confirm Password<font color='red'>*</font></td>
							<td><input type="text" name="confirmPassword"></td>
						</tr>
						
						<tr>
							<td colspan="2" align="center"><input type="button"
								value="Reset Password" onclick="javascript:validateForm('ResetPasswordPost.jsp')"> </td>
						</tr>
					</table>
<jsp:include page="Layout\Footer.html" />