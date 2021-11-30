<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Query Exercise table and benefits table to show benefits for exercises with chest in exercise description </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Benefit ID</th>
		<th>Exercise ID</th>
		<th>Benefit Name</th>
		<th>Benefit Description</th>
		
	</tr>
<c:forEach items="${TableList}" var="table">
	<tr>
		<td>${table.getCol1()}</td>
		<td>${table.getCol2()}</td>
		<td>${table.getCol3()}</td>
		<td>${table.getCol4()}</td>
		
	</tr>
</c:forEach>
</table>
</body>
</html>
