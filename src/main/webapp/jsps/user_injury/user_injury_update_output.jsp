<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Update User Injury</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Injury ID    :<input type="text" name="injury_id" value="${user_injury.getInjuryID() }" disabled/>
	<br/>
	User ID    :<input type="text" name="user_id" value="${user_injury.getUserID() }" disabled/>
	<br/>
	User Injury Name：<input type="text" name="user_injury_name" value="${user_injury.getUserInjuryName() }" disabled/>
	<br/>
	User Injury Description	：<input type="text" name="user_injury_description" value="${user_injury.getUserInjuryDescription() }" disabled/>
	<br/>
	User Injury Severity	：<input type="text" name="user_injury_severity" value="${user_injury.getUserInjurySeverity() }" disabled/>
	<br/>
	User Injury Date	：<input type="text" name="user_injury_date" value="${user_injury.getUserInjuryDate() }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/User_injuryServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="injury_id" value="${user_injury.getInjuryID() }"/>
	User ID：<input type="text" name="user_id" value="${form.user_id }"/>
	<span style="color: red; font-weight: 900">${errors.user_id }</span>
	<br/>
	User Injury Name	：<input type="text" name="user_injury_name" value="${form.user_injury_name }"/>
	<span style="color: red; font-weight: 900">${errors.user_injury_name }</span>
	<br/>
	User Injury Description	：<input type="text" name="user_injury_description" value="${form.user_injury_description }"/>
	<span style="color: red; font-weight: 900">${errors.user_injury_description }</span>
	<br/>
	User Injury Severity	：<input type="text" name="user_injury_severity" value="${form.user_injury_severity }"/>
	<span style="color: red; font-weight: 900">${errors.user_injury_severity }</span>
	<br/>
	User Injury Date	：<input type="text" name="user_injury_date" value="${form.user_injury_date }"/>
	<span style="color: red; font-weight: 900">${errors.user_injury_date }</span>
	<br/>
	<input type="submit" value="Update User Injury"/>
</form>

</body>
</html>
