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
<link href="https://fonts.googleapis.com/css?family=Yeon+Sung&display=swap" rel="stylesheet">

<title>Insert title here</title>
<style type="text/css">

</style>

<script type="text/javascript">
function doIt(url) {
	location.replace(url);
}

</script>
</head>


<body>
<table style="width: 100%; ">
	<tr>
		<td colspan="5"><h3 class="title"align="center">${sessionScope.loginUser.nickname} 님 환영합니다.</h3></td>
	</tr>
	<tr>
	<td class="td1"></td>
	<td class="td1"></td>
	<td class="td1"></td>
	<td class="td1"><input type="button" class="btn1" value="내 정보" onclick="doIt('../home/userPage.html')"></td>
	<td class="td1"><input type="button" class="btn1" value="로그아웃" onclick="doIt('../login/logout.html')"></td>
	</tr>
</table>
</body>
</html>