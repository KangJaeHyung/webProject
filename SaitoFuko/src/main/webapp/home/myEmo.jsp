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
.divP{
	display: grid;
	grid-template-columns: 140px 140px 140px;
  	grid-auto-rows: 140px;
    width: 100%;
    margin: 5px;
    padding: 15px;
}


</style>
<script type="text/javascript">
function emoClick(emo) {
	var href="../comment/commentWrite.html?emo_id="+emo;
	location.replace(href);
}


</script>

</head>
<body>

</body>
</html>