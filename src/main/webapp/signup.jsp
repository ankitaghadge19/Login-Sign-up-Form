<%@page import="javax.print.attribute.HashPrintRequestAttributeSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>

<script type="text/javascript">
	function validate()
	{
		var email = document.getElementById("email").value;
		var pass = document.getElementById("pass").value;
		var cpass = document.getElementById("cpass").value;
		
		if(email=="")
			{
				document.getElementById("emailError").innerHTML="Please enter your Email Id.";
				return false;
			}
		else
			{
				document.getElementById("emailError").innerHTML="";
			}
		
		if(pass=="")
			{
				document.getElementById("passError").innerHTML="Please enter your Password.";
				return false;
			}
		else
			{
				document.getElementById("passError").innerHTML="";
			}
		if(pass.length<5 || pass.length>8)
			{
				document.getElementById("passError").innerHTML="Password should be in between 5 to 8 character.";
				return false;
			}
		else
			{
				document.getElementById("passError").innerHTML="";
			}
			
		if(cpass=="")
			{
				document.getElementById("cpassError").innerHTML="Please confirm your Password.";
				return false;
			}
		else
			{
				document.getElementById("cpassError").innerHTML="";
			}
		
		if(cpass!=pass)
			{
				document.getElementById("cpassError").innerHTML="Please enter same password";
				return false;
			}
		else
			{
				document.getElementById("cpassError").innerHTML="";
			}
		
		
		return true;
		
	}
</script>

</head>
<body>
	<div align="center">	
	 <fieldset>
		 <%
			String status = (String)request.getAttribute("status");
			if(status != null)
			{
				out.println(status);	
			}
		%>
	 	<h1>Sign up</h1>
	 	<form onsubmit="return validate()" action="signupServlet" method="post">
	 		<table>
	 			<tr>
	 				<td>Email: </td>
	 			    <td><input type="email" id="email" name="email"></td>
	 			    <td><span style="color:red" id="emailError">*</span>
	 			</tr>
	 			<tr>
	 				<td>Password: </td>
	 			    <td><input type="password" id="pass" name="pass"></td>
	 			    <td><span style="color:red" id="passError">*</span>
	 			</tr>
	 			<tr>
	 				<td>Confirm Password: </td>
	 			    <td><input type="password" id="cpass" name="cpass"></td>
	 			    <td><span style="color:red" id="cpassError">*</span>
	 			</tr>
	 			<tr>
	 				<td><input type="submit" value="Register"> </td>
	 			</tr>
	 			
	 		</table>
	 	</form>
	 	<br>
	 	<hr>
	 	Already User?<a href="login.jsp">Login</a>
	 </fieldset>
	</div>
</body>
</html>