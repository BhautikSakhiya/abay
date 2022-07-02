<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
	body {		
		background-color: #d6eae3;
  		color: #002939;
  		font-family:georgia;
  	}
	
	input[type=text], input[type=password] {
  		width: 100%;
  		padding: 12px 20px;
  		margin: 8px 0;
  		display: inline-block;
  		border: 1px solid #ccc;
  		box-sizing: border-box;
	}
	button {
  		background-color: #04AA6D;
 		color: white;
  		padding: 14px 20px;
  		margin: 8px 0;
  		border: none;
  		cursor: pointer;
  		width: 100%;
	}
	button:hover {
  		opacity: 0.8;
	}
	
	.imgcontainer {
		width:350px;
  		text-align: center;
  		margin-left: auto;
  		margin-right: auto;
	}
	img.avatar {
  		width: 40%;
  		border-radius: 50%;
	}
	.container {
  		padding: 16px;
	}
	span.psw {
  		float: right;
  		padding-top: 16px;
	}

/* Change styles for span and cancel button on extra small screens 
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }*/
	.header{
		margin-top: 0px;
		height: 60px;
		background-color: #aad4c8;
		font-family:georgia;
		color: #002939;
	}
	h1{
  			margin-top: 0px;
  			padding: 10px 0px 10px 50px;
			margin-bottom: 0px;
  			font-size:35px;
  			display: inline-block;
  			
  		}
    .cancelbtn {
    	width: 100%;
  	}
}
</style>


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
<form action="userlogin" method="post" required="required">
<div class="header">
	<h1>Abay</h1>	
</div>

  <div class="imgcontainer">
    <img src="guest.jpg" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="uname"><b>Enter Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label for="pin"><b>Enter Password</b></label>
    <input type="password" placeholder="Enter Password" id="pin" name="password" required>
    <input type="checkbox" onclick="myFunction()">Show Password
        
    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>
	<a href="registration.jsp">Create New Account?</a>
 
    <span class="psw"><a href="forgotpassword.jsp">Forgot password?</a></span>

</form>

</body>
</html>
