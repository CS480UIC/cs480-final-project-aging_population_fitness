<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Exercise</title>
    
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
  <h1>Delete Exercise</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/ExerciseServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="exercise_id" value="${exercise.getExerciseID() }"/>
	Exercise Name    :<input type="text" name="exercise_name" value="${exercise.getExerciseName() }" disabled/>
	<br/>
	
	Exercise Description：<input type="text" name="exercise_description" value="${exercise.getExerciseDescription() }" disabled/>
	<br/>
	exercise Difficulty	：<input type="text" name="exercise_difficulty" value="${exercise.getExerciseDifficulty()}" disabled/>
	<br/>
	<input type="submit" value="Delete Exercise"/>
</form>

</body>
</html>
