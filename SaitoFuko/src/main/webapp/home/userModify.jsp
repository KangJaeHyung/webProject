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
	return true;
}

</script>
<h2 class="title" align="center">비밀번호를 입력해 주세요.</h2>
<br/>
<br/>
<form action="../modify/userModifyForm.html" onsubmit="return doIt(this)" method="post">
<div align="center">
<input type="hidden" name="form" id="form" value="${form}"/>
<input type="password" placeholder="password" name="password" id="password" class="password" size="30" />
</div>
<div align="center"><input type="submit" class="findBtn" value="확인" ></div>
</form>
</body>
</html>