<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Benefit</title>
    
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
  <h1>Delete Benefit</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/BenefitServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="benefit_id" value="${benefit.getBenefitID() }"/>
	Benefit ID    :<input type="text" name="benefit_id" value="${benefit.getBenefitID() }" disabled/>
	<br/>
	Exercise ID    :<input type="text" name="exercise_id" value="${benefit.getExerciseID() }" disabled/>
	<br/>
	Benefit Name：<input type="text" name="benefit_name" value="${benefit.getBenefitName() }" disabled/>
	<br/>
	Benefit Description	：<input type="text" name="benefit_description" value="${benefit.getBenefitDescription() }" disabled/>
	<br/>
	<input type="submit" value="Delete Benefit"/>
</form>

</body>
</html>
