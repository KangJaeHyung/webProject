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
if(result=="no"){
	alert("환불중 문제가 생겼습니다. 관리자에게 문의 드리세요.");
	location.replace("../home/myEmo.html");
}
if(result=="yes"){
	alert("환불 되었습니다.");
	location.replace("../home/myEmo.html");
}
</script>
</body>
</html>