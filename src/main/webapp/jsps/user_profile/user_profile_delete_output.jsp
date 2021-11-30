<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete User Profile</title>
    
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
  <h1>Delete User Profile</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/User_profileServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="user_id" value="${user_profile.getUserID() }"/>
	User ID    :<input type="text" name="user_id" value="${user_profile.getUserID() }" disabled/>
	<br/>
	Username：<input type="text" name="username" value="${user_profile.getUserName() }" disabled/>
	<br/>
	Profile Name	：<input type="text" name="profile_name" value="${user_profile.getProfileName() }" disabled/>
	<br/>
	<input type="submit" value="Delete User Profile"/>
</form>

</body>
</html>
