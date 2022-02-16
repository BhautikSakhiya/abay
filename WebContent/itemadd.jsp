<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	input {
		width: 300px;
	}
	form {
		margin-top: 150px;
	}
	body{
  			margin:0;
  			padding: 0;
  			background-color: #d6eae3;
  			font-family:georgia;
  		}
  	
</style>
</head>
<body>
<div align="center">

	<form action="item" method="post" enctype="multipart/form-data" required="required">
	
		<label for="item">category:</label> 
		<select name="category" id="item">
				<option value="Mobile & Accessories">Mobile & Accessories</option>
				<option value="Vehicle">vehicle</option>
				<option value="Electronics & Appliances">Electronics & Appliances</option>
				<option value="Furniture">Furniture</option>
				<option value="Books,Sports & Hobbies">Books, Sports & Hobbies</option>
			</select><br> <br> 
	
		Add Photos: <input type="file" name="image" multiple ><br> <br> 
	
		<input type="text" name="name" placeholder="What you want to sell:" ><br> <br> 
		<input type="text" name="detail" placeholder="Give some more detail of your Item:"><br> <br> 
		<input type="text" name="price" placeholder="Price of Item:"><br><br> 
		<input type="text" name="mobileno" placeholder="Mobile Number:"><br> <br> 
		<input type="text" name="address" placeholder="Address:"><br><br> 
		<input type="submit" value="sell">
	

	</form>
	</div>
</body>
</html>