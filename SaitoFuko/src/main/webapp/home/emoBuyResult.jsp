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
if(result=="ok"){
	alert("구매가 완료되었습니다.");
	self.close();
	opener.location.reload();
}
if(result=="no"){
	alert("구매중 문제가 발생하였습니다 관리자에게 문의 부탁드립니다.");
	self.close();
	opener.location.reload();
}

</script>

</body>
</html>