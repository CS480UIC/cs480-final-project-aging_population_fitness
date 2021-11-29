<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update User Exercise</title>
    
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
  <h1>Update User Exercise</h1>
<form action="<c:url value='/User_exerciseServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	User ID    :<input type="text" name="user_id" value="${form.user_id }"/>
	<span style="color: red; font-weight: 900">${errors.user_id }</span>
	<br/>
	

	<input type="submit" value="Update User Exercise"/>
</form>
  </body>
</html>
