<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Exercise Injury</title>
    
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
  <h1>Update Exercise Injury</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	Injury ID    :<input type="text" name="injury_id" value="${form.username }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	Exercise ID	：<input type="text" name="exercise_id" value="${form.password }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Exercise Injury Name	：<input type="text" name="exercise_injury_name" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	Exercise Injury Description	：<input type="text" name="exercise_injury_description" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>

	<input type="submit" value="Update Exercise Injury"/>
</form>
  </body>
</html>
