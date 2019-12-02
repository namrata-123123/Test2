<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Layout\HeaderAndLeftFrame.jsp" />

<script >
function validateForm(nextPath){
	var form=document.DashboardForm;
	var errorMessages='';
	if (form.mobile.value ==''){
		errorMessages='please enter mobile.';
		}
	if (form.email.value ==''){
		errorMessages+='<BR>please enter email.';
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
	
	}}


</script>

<%
FERService ferService=new FERServiceImpl();


	
	User user=(User) session.getAttribute("user");
	int userId=Integer.parseInt(session.getAttribute("userId").toString());

	user.setFirstname(request.getParameter("firstName"));
	user.setMiddlename(request.getParameter("middleName"));
	user.setLastname(request.getParameter("lastName"));
	user.setId(userId);
	
	


	out.println("<table border='1' align='center'>");
	out.println("<tr>");
	out.println("<td colspan='2' align='center'>Contact Info</td>");
	out.println("</tr>");
	out.println("<tr style='display:none;' id='errorTrId'>");
	out.println("<td colspan='2'id='errorTdId'>");
	out.println("</td>");
	out.println("<tr>");
	out.println("<td>Mobile<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='mobile' value="+user.getMobile()+"></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>email<font color='red'>*</font></td>");
	out.println("<td><input type='text' name='email' value="+user.getEmail()+"></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td colspan='2' align='centre'><input type='button' value='Next' onclick='javascript:validateForm(\"AddressInfo.jsp\")'></td>");
	out.println("</tr>");

	out.println("</table>");

	
%>
<jsp:include page="Layout\Footer.html" />