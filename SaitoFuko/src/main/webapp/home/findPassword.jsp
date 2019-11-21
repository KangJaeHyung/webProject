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
<h2 class="title">비밀번호 찾기</h2>
<a href="../find/findIdForm.html"><input type="button" class="findBtn" value="아이디 찾기"></a>
<form:form modelAttribute="user_info" action="../find/findPassword.html" method="post">
<table>
<tr>
	<td><form:input path="user_id" placeholder="Id" cssClass="user_id" size="20"/></td>
</tr>
<tr>
	<td><form:input path="user_name" placeholder="Name" cssClass="name" size="20"/></td>
</tr>
<tr>
<td>
	<form:input path="email" placeholder="Email" cssClass="email" size="50"/>
</td>
</tr>
<tr>
<td>
	<input type="submit" class="submit"/>
</td>
</tr>
</table>
</form:form>
</body>
</html>