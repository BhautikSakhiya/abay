<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.userbean,dao.userdao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
		li {
 			display: inline-block;
  		 	color: #e6d86d;
		}
		a {
      		padding : 40px;
 			 overflow: hidden;
		}
		a {
 			color: #e6d86d;
 			text-align: center;
 			padding: 20px 20px;
 			text-decoration: none;
  			font-size: 20px;
		}
		a:hover {
			 font-weight: bold;
 			 background-color: #e6d86d;
 			 color: white;
		}
		a.active {
  			background-color: #b18c31;
  			color: white;
		}
		
</style>
</head>
<body>
<h1>Admin Section</h1>

	<li><a href="viewuser">View User</a></li>
    <li><a href="index.jsp">Logout</a></li>
    
</body>
</html>