<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

</style>
</head>
<body>
<form:form modelAttribute="user_info" action="../login/login.html" method="post">
<table>
<tr>
	<td><form:input path="user_id" placeholder="ID" cssClass="id" size="20"/></td>
	<td rowspan="2"><input class="button" type="submit" value="Login"/></td>
</tr>
<tr>
<td>
	<form:password path="password" placeholder="password" cssClass="pwd" size="20"/>
</td>
</tr>
</table>
<div align="right">
<a href="../find/findIdForm.html"><font size="2" color="gray" style="">계정찾기</font></a>&nbsp;
<a href="../entry/entryForm.html"><font size="2" color="gray" style="">회원가입</font></a>
</div>
</form:form>
</body>
</html>