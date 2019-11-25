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

.id,.pwd{
  font-family: "Roboto", sans-serif;
  background: #f2f2f2;
  width: 100%;
  border: 1;
  padding: 5px;
  margin:5px;
  margin-left:10px;
  margin-right:10px;
  font-size: 90px;
}
.button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: gray;
  width: 100%;
  border: 1;
  padding: 10px;
  color: #FFFFFF;
  margin:10px;
  font-size: 80px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}

</style>
</head>
<body>
<br/>
<br/>
<div align="center"><a href="../home/mobile.jsp"><img alt="" src="../cssImage/logo.png"></a> </div>
<form:form modelAttribute="user_info" action="../login/login.html" method="post">
<table>
<tr>
	<td><form:input path="user_id" placeholder="ID" cssClass="id" size="20"/></td>
</tr>
<tr>
<td>
	<form:password path="password" placeholder="password" cssClass="pwd" size="20"/>
</td>
</tr>
<tr>
<td><input class="button" type="submit" value="Login"/></td>
</tr>
</table>
<br/>
<br/>
<div align="center">
<a href="../find/findIdForm.html"><font size="7" color="gray" style="">계정찾기</font></a>&nbsp;&nbsp;&nbsp;
<a href="../entry/entryForm.html"><font size="7" color="gray" style="">회원가입</font></a>
</div>
</form:form>
</body>
</html>