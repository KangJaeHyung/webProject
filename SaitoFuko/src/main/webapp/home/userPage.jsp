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
<h2 class="title" align="left">
	회원정보
</h2>
<div class="column">
	<div class="space">
		<p class="pfont1">ID</p>
		<p class="pfont2"> ${sessionScope.loginUser.user_id}</p>
		<p class="pfont2"></p>
	</div>
	<div class="space">
		<p class="pfont1">Password</p>
		<p class="pfont2"> ${sessionScope.loginUser.markingPwd}</p>
		<p align="right"><a href="../modify/modifyForm.html?form=Password"><input type="button" class="modifyBtn" value="정보 수정"></a><p>
	</div>
	<div class="space">
		<p class="pfont1">닉네임</p>
		<p class="pfont2"> ${sessionScope.loginUser.nickname}</p>
		<p align="right"><a href="../modify/modifyForm.html?form=Nickname"><input type="button" class="modifyBtn" value="정보 수정"></a><p>
	</div>
	<div class="space">
		<p class="pfont1">성별</p>
		<p class="pfont2"> ${sessionScope.loginUser.gender}</p>
		<p align="right"><a href="../modify/modifyForm.html?form=Gender"><input type="button" class="modifyBtn" value="정보 수정"></a><p>
	</div>
	<div class="space">
		<p class="pfont1">이메일</p>
		<p class="pfont2"> ${sessionScope.loginUser.email}</p>
		<p align="right"><a href="../modify/modifyForm.html?form=Email"><input type="button" class="modifyBtn" value="정보 수정"></a><p>
	</div>
	<div class="space">
		<p class="pfont1">내 이름</p>
		<p class="pfont2"> ${sessionScope.loginUser.user_name}</p>
		<p align="right"><a href="../modify/modifyForm.html?form=Name"><input type="button" class="modifyBtn" value="정보 수정"></a><p>
	</div>
	<div class="space">
		<p class="pfont1">내 생일</p>
		<p class="pfont2"> ${sessionScope.loginUser.birthday}</p>
		<p align="right"><a href="../modify/modifyForm.html?form=Birthday"><input type="button" class="modifyBtn" value="정보 수정"></a><p>
	</div>
	<div class="space">
		<p class="pfont1">회원탈퇴</p>
		<p class="pfont2">종말 탈퇴 할꼬야??</p>
		<p align="right"><a href="../modify/delete.html"><input type="button" class="modifyBtn" value="회원 탈퇴"></a><p>
	</div>
</div>
</body>
</html>