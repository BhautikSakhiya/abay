<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	.center {
  		margin-left: auto;
  		margin-right: auto;
	}
	body {
		text-align: center;
		background-color: #d6eae3;
  		color: #002939;
  		font-family:georgia;
	}
	input[type="text"] {
    	width: 300px;
	}
	input[type="password"] {
   	 	width: 300px;
	}
	input[type="submit"] {
    	width: 200px;
	}
</style>

<script type="text/javascript">
function myFunction() {
	  var x = document.getElementById("pass");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
</script>
</head>
<body >
<form action="adduser" method="post">
<h1>Welcome to ABay</h2>
<br> <br><br>
<table class="center" >
<tr><td>Enter Name : </td>
    <td> <input type="text" name="name" required > </td></tr>
    
<tr><td>Enter Mobile No : </td>
     <td><input type="text" name="mobile" required> </td></tr>

<tr><td>Enter EmailId :</td> 
     <td><input type="text" name="email" required></td>
      
<tr><td>Enter Address :</td>
     <td><input type="text" name="address" required> </td></tr>

<tr><td>Enter Password : </td>
     <td><input type="password" name="password" id="pass" required> </td></tr>
     <tr><td><input type="checkbox" onclick="myFunction()">Show Password</td></tr>
     
<tr><td colspan="2">
     <input type="Submit" value="Submit"></td></tr>
     
</table>
</form>

</body>
</html>