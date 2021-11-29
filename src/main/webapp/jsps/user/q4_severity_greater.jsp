<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Exercise Injury Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Injury ID</th>
		<th>User ID</th>
		<th>User Injury Name</th>
		<th>User Injury Description</th>
		<th>User Injury Severity</th>
		<th>User Injury Date</th>
		
	</tr>
<c:forEach items="${TableList}" var="table">
	<tr>
		<td>${table.getCol1()}</td>
		<td>${table.getCol2()}</td>
		<td>${table.getCol3()}</td>
		<td>${table.getCol4()}</td>
		<td>${table.getCol5()}</td>
		<td>${table.getCol6()}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
