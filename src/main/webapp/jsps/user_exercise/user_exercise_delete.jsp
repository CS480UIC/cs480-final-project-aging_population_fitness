<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete User Exercise</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delete User Exercise</h1>
<form action="<c:url value='/User_exerciseServletDelete'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	Delete User ID    :<input type="text" name="user_id" value="${form.user_id }"/>
	<span style="color: red; font-weight: 900">${errors.user_id }</span>
	<br/>
	Delete Exercise ID    :<input type="text" name="exercise_id" value="${form.exercise_id }"/>
	<span style="color: red; font-weight: 900">${errors.exercise_id }</span>
	<br/>

	<input type="submit" value="Delete User Exercise"/>
</form>
  </body>
</html>