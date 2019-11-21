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
	<c:if test="${result=='no' }">
	<script type="text/javascript">
		alert("계정정보가 일치 하지 않습니다. 정확하게 입력해 주세요.")
		location.replace("../find/findPasswordForm.html");
	</script>
	</c:if>
	<c:if test="${result=='ok' }">
	<script type="text/javascript">
		alert("기입하신 이메일에 비밀번호를 전송해 드렸습니다. 확인 부탁드립니다.")
		location.replace("../home/main.jsp");
	</script>
	</c:if>
</body>
</html>