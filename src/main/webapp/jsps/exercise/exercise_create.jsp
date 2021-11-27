<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Exercise</title>
    
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
  <h1>Create Exercise</h1>
<form action="<c:url value='/ExerciseServletCreate'/>" method="post">
	
	Exercise Name	：<input type="text" name="exercise_name" value="${form.exercise_name }"/>
	<span style="color: red; font-weight: 900">${errors.exercise_name }</span>
	<br/>
	Exercise Description	：<input type="text" name="exercise_description" value="${form.exercise_description }"/>
	<span style="color: red; font-weight: 900">${errors.exercise_description }</span>
	<br/>
	Exercise Difficulty	：<input type="text" name="exercise_difficulty" value="${form.exercise_difficulty }"/>
	<span style="color: red; font-weight: 900">${errors.exercise_difficulty }</span>
	<br/>
	<input type="submit" value="Create Exercise"/>
</form>
  </body>
</html>
