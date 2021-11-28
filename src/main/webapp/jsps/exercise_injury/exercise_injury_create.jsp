<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Exercise Injury</title>
    
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
  <h1>Create Exercise Injury</h1>
<form action="<c:url value='/Exercise_injuryServletCreate'/>" method="post">
	
	Exercise ID	：<input type="text" name="exercise_id" value="${form.exercise_id }"/>
	<span style="color: red; font-weight: 900">${errors.exercise_id }</span>
	<br/>
	Exercise Injury Name	：<input type="text" name="exercise_injury_name" value="${form.exercise_injury_name }"/>
	<span style="color: red; font-weight: 900">${errors.exercise_injury_name }</span>
	<br/>
	Exercise Injury Description	：<input type="text" name="exercise_injury_description" value="${form.exercise_injury_description }"/>
	<span style="color: red; font-weight: 900">${errors.exercise_injury_description }</span>
	<br/>
	<input type="submit" value="Create Exercise Injury"/>
</form>
  </body>
</html>
