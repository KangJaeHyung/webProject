<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	
	<script type="text/javascript">
	function doIt() {
		var nowDate=new Date();
		var date = new Date(2020,10,30,8,0,0,0);
		var gap = date.getTime()-nowDate.getTime();
		var gapDate=Math.floor(gap/(1000*60*60*24));
		alert(gapDate+"일 차이");
	}
	
	</script>
	<body>
		<a href="" onclick="doIt()">asdf</a>
	
		<c:url value="/home/main.jsp" var="messageUrl" />
		<a href="${messageUrl}">Click to enter</a>
	</body>
</html>
