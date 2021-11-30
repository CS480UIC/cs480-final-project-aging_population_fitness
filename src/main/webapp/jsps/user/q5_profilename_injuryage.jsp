<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Exercise Injury joined user profile on user id </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Profile Name</th>
		<th>User Injury Name</th>
		<th>Days Since Injury</th>
		
	</tr>
<c:forEach items="${TableList}" var="table">
	<tr>
		<td>${table.getCol1()}</td>
		<td>${table.getCol2()}</td>
		<td>${table.getCol3()}</td>
		
	</tr>
</c:forEach>
</table>
</body>
</html>
