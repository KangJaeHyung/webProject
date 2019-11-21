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
</head>
<body>
<c:if test="${result=='noUser'}">
<br/>
<br/>
<h2 align="center"  class="title">정보와 일치하는 ID를 찾을수 없습니다.</h2>
<h2 align="center" class="title">이름과 이메일을 정확하게 입력해 주세요.</h2>
<a href="../find/findIdForm.html"><input class="findBtn" type="button" value="되돌아가기"></a>
</c:if>
<c:if test="${result=='multipleUser'}">
<br/>
<br/>
<h2 align="center"  class="title">정보와 일치하는 ID가 다수 있습니다.</h2>
<h2 align="center" class="title">일치하는 ID</h2>
<div align="center">
<table>
<c:set var="cnt" value="0"></c:set>
<c:forEach var="user" items="${userList}">
	<tr>
		<td><p><font color="green">${user}</font> 님</p>
		</td>
	</tr>
	<c:set var="cnt" value="${cnt+1}"></c:set>
</c:forEach>
</table>
</div>
<h2 align="center" class="title">총 ${cnt}건의 ID가 있습니다.</h2>
<a href="../find/findIdForm.html"><input class="findBtn" type="button" value="되돌아가기"></a>
</c:if>

<c:if test="${result=='oneUser'}">
<br/>
<br/>
<h2 align="center" class="title">정보와 일치하는 ID를 찾았습니다.</h2>
<div align="center"><p><font color="green">${user}</font> 입니다.</p></div>
<a href="../find/findIdForm.html"><input class="findBtn" type="button" value="되돌아가기"></a>
</c:if>

</body>
</html>