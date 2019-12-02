<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<script >
function validateForm(nextPath){
	var form=document.DashboardForm;
	var errorMessages='';
	if (form.firstName.value ==''){
		errorMessages='please enter firstName.';
		}
	if (form.middleName.value ==''){
		errorMessages+='<BR>please enter middleName.';
		}
	
	if (form.lastName.value ==''){
		errorMessages+='<BR>please enter lastName.';
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

	FERService ferService=new FERServiceImpl();
	
	int userId=Integer.parseInt(session.getAttribute("userId").toString());
	
	User user = ferService.getPersonalInfo(userId);
	session.setAttribute("user",user);
	
	out.println("<table border='1' align='center'>");
	out.println("<tr>");
	out.println("<td colspan='2' align='center'>Personal Info</td>");
	out.println("</tr>");
	out.println("<tr style='display:none;' id='errorTrId'>");
	out.println("<td colspan='2'id='errorTdId'>");
	out.println("</td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>First Name<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='firstName' value="+user.getFirstname()+"></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Middle Name<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='middleName' value="+user.getMiddlename()+"></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Last Name<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='lastName' value="+user.getLastname()+"></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td colspan='2' align='centre'><input type='button' value='Next' onclick='javascript:validateForm(\"ContactInfo.jsp\")'></td>");
	out.println("</tr>");
	out.println("</table>");

%>
<jsp:include page="Layout\Footer.html" />