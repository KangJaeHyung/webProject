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



<form:form modelAttribute="board" action="../manage/changeLoca.html" id="board" name="board">
	<input type="hidden" name="board_id" value="${oriBoard.board_id}">
	<input type="hidden" name="board_name" value="${oriBoard.board_name}">
	<input type="hidden" name="board_grade" value="${oriBoard.board_grade}">
	<input type="hidden" name="board_location" value="${oriBoard.board_location}">
	<input type="submit">
</form:form>
<script type="text/javascript">
var oriBoardName="${oriBoard.board_name}"
if(confirm("이미 "+oriBoardName+"에서 사용중입니다. 바꾸 시겠습니까??")){
	document.getElementById("board").submit();
}else{
	location.replace("../manage/BoardManage.html");
}
</script>
</body>
</html>