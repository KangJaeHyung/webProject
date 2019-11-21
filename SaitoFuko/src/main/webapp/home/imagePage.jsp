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
function check(frm) {
	if(frm.img.value==''){
		alert("이미지를 선택해주세요.");
		return false;
	}
	return true;
	}

</script>
<form enctype="multipart/form-data" method="post" action="../post/imageUpload.html" onsubmit="return check(this)">
<input type="file" name="img"/>
<input type="submit" value="이미지 올리기"/>
</form>
</body>
</html>