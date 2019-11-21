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
<script type="text/javascript">
function doIt(frm) {
	var pwd = frm.password.value;
	if(pwd==''){
		alert("비밀번호를 입력해 주세요.");
		return false;
	}
	var spwd=frm.spwd.value;
	if(spwd==pwd){
		if(confirm("정말로 삭제 하시겠습니까???")){
			alert("회원 정보는 1년간 유지됩니다. 이용해 주셔서 감사합니다.");
			return true;
		}else{
			return false;
		}
	}
	alert("비밀번호가 맞지 않습니다.");
	return false;
}

</script>
<h2 class="title" align="center">비밀번호를 입력해 주세요.</h2>
<br/>
<br/>
<form action="../modify/deleteConfirm.html" onsubmit="return doIt(this)" method="post">
<div align="center">
<input type="hidden" name="spwd" id="spwd" value="${sessionScope.loginUser.password}"/>
<input type="password" placeholder="password" name="password" id="password" class="password" size="30" />
</div>
<div align="center"><input type="submit" class="findBtn" value="확인" ></div>
</form>
</body>
</html>