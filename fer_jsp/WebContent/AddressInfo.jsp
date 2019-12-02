<%@page import="com.rs.fer.bean.User"%>
<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />

<script >
function validateForm(nextPath){
	var form=document.DashboardForm;
	var errorMessages='';
	if (form.addressLine1.value ==''){
		errorMessages='please enter addressline1.';
		}
	if (form.city.value ==''){
		errorMessages+='<BR>please enter city.';
		}
	
	if (form.state.value ==''){
		errorMessages+='<BR>please enter state.';
		}
	if (form.country.value ==''){
		errorMessages+='<BR>please enter country .';
		}
	if (form.zip.value ==''){
		errorMessages+='<BR>please enter zip.';
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
		form.submit();
	}
	
	
}

</script>



<%


	
	User user=(User) session.getAttribute("user");
	
	user.setMobile(request.getParameter("mobile"));
	user.setEmail(request.getParameter("email"));
	
	
	
	out.println("<table border='1' align='center'>");
	out.println("<tr>");
	out.println("<td colspan='2' align='center'>Address Info</td>");
	out.println("</tr>");
	out.println("<tr style='display:none;' id='errorTrId'>");
	out.println("<td colspan='2'id='errorTdId'>");
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>AddressLine1<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='addressLine1' value="+user.getAddress().getLineOne()+"></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>AddressLine2<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='addressLine2' value="+user.getAddress().getLineTwo()+"></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>City<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='city' value="+user.getAddress().getCity()+"></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>State<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='state' value="+user.getAddress().getState()+"></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Country<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='country' value="+user.getAddress().getCountry()+"></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Pincode<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='zip' value="+user.getAddress().getZip()+"></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<td colspan='2' align='centre'><input type='button' value='Next' onclick='javascript:validateForm(\"PersonalReview.jsp\")'></td>");
	out.println("</tr>");
	out.println("</table>");

	
%>
<jsp:include page="Layout\Footer.html" />