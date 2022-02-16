<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript">
function myFunction() {
	  var x = document.getElementById("pin");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
</script>

</head>
<body>
<form action="adminlogin" method="post">
<h1>Admin Login Form</h1>
<table class="center">

<tr><td>  Enter Email :</td>
 	 <td><input type="text" name="email" required></td></tr><br>

<tr><td>Four Password : </td>
     <td><input type="password" name="password"  id="pin" required> </td>
     <td><input type="checkbox" onclick="myFunction()">Show Password</td></tr>

	<td><input type="submit" value="Login"></td></tr>
	
<tr><td>	<a href="forgotpassadmin.jsp">Forgot Password?</a></td></tr>
	
</table>
</form>
</body>
</html>