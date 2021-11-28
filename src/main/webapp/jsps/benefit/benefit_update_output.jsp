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
  <h1>Update Benefit</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Benefit ID    :<input type="text" name="benefit_id" value="${benefit.getBenefitID() }" disabled/>
	<br/>
	Exercise ID    :<input type="text" name="exercise_id" value="${benefit.getExerciseID() }" disabled/>
	<br/>
	Benefit Name：<input type="text" name="benefit_name" value="${benefit.getBenefitName() }" disabled/>
	<br/>
	Benefit Description	：<input type="text" name="benefit_description" value="${benefit.getBenefitDescription() }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/BenefitServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="benefit_id" value="${benefit.getBenefitID() }"/>
	Exercise ID：<input type="text" name="exercise_id" value="${form.exercise_id }"/>
	<span style="color: red; font-weight: 900">${errors.exercise_id }</span>
	<br/>
	Benefit Name：<input type="text" name="benefit_name" value="${form.benefit_name }"/>
	<span style="color: red; font-weight: 900">${errors.benefit_name }</span>
	<br/>
	Benefit Description	：<input type="text" name="benefit_description" value="${form.benefit_description }"/>
	<span style="color: red; font-weight: 900">${errors.benefit_description }</span>
	<br/>
	<input type="submit" value="Update Benefit"/>
</form>

</body>
</html>
