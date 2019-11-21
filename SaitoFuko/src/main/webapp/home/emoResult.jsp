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
var pageNum="${pageNum}"
if(result=="noLogin"){
	alert("로그인 먼저 해주세요.");
	location.replace("../shop/shopPage.html?pageNum="+pageNum);
}
if(result=="inYes"){
	alert("찜 되었습니다.");
	location.replace("../shop/shopPage.html?pageNum="+pageNum);
}
if(result=="outYes"){
	alert("찜이 해제 되었습니다.");
	location.replace("../shop/shopPage.html?pageNum="+pageNum);
}
if(result=="haveCart"){
	alert("이상한 짓좀 하지마라...");
	location.replace("../shop/shopPage.html?pageNum="+pageNum);
}
</script>

</body>
</html>