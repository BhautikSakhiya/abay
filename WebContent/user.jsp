<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

  <style type="text/css">
  		body{
  			margin:0;
  			padding: 0;
  			background-color: #d6eae3;
  			font-family:georgia;
  		}
  		h1{
  			margin-top: 0px;
  			padding: 10px 0px 10px 50px;
			margin-bottom: 0px;
  			font-size:35px;
  			display: inline-block;
  			
  		}
		a {
			padding:16px 7px 16px 7px ;
 			text-align: center;
 			text-decoration: none;
  			font-size: 25px;
  			color: #002939;
		}
		a:hover {
			 
 			 color: white;
		}
		.fright{
			padding: 16px 50px 16px 0px;
			float: right;
		}
		.header{
		height: 60px;
			background-color: #aad4c8;
			font-family:georgia;
			color: #002939;
		}
		
</style>

</head>
<body>
	<div class="header">
	<h1>Abay</h1>
	<div class="fright">
		<a style="margin-right: 20px;" href="itemadd.jsp">Sell</a>
    	<a href="logout">Logout</a>
	</div>
	</div>
	
	 <sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/abay"
     	user="root" password="root"/>
 
	<sql:query dataSource="${snapshot}" var="result">
		SELECT p.*,i.* FROM product p JOIN image i on p.productid = i.productid;
	</sql:query>

	<table>
<!--	<tr>
   		<th>Category </th>
   		<th>Name </th>
   		<th>Detail </th>
   		<th>Price </th>
   		<th>Mobile No. </th>
   		<th>Address </th>
	</tr>-->

	<c:forEach var="row" items="${result.rows}">
	<tr>
   		<td><c:out value="${row.category}"/></td>
   		<td><c:out value="${row.image}"/></td>
   	</tr>
   	<tr>
   		<td><c:out value="${row.productname}"/></td>
   	</tr>
   	<tr>
   		<td><c:out value="${row.productdetail}"/></td>
   	</tr>
   	<tr>
   		<td><c:out value="${row.price}"/></td>
   	</tr>
   	<tr>
   		<td><c:out value="${row.mobileno}"/></td>
   	</tr>
   	<tr>
   		<td><c:out value="${row.address}"/></td>	
	</tr>
	<tr><td>&nbsp;</td></tr>
	
	</c:forEach>
	</table>
	
</body>
</html>