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
var result="${result}";
if(result=="yes"){
	location.replace("../home/main.jsp");
}
if(result=="noAccount"){
	alert("없는 아이디 입니다.");
	location.replace("../home/main.jsp");
}
if(result=="no"){
	alert("아이디 비밀번호가 정확하지 않습니다.");
	location.replace("../home/main.jsp");
}
if(result=="banUser"){
	alert("밴당한 유저입니다.");
	location.replace("../home/main.jsp");
}
if(result=="deleteUser"){
	alert("회원 탈퇴 한 유저입니다. 관리자에게 문의 부탁드립니다.");
	location.replace("../home/main.jsp");
}
</script>
</body>
</html>