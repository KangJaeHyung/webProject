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
var result='${result}';
var no=${post_no};
if(result=='commentS'){
}
if(result=='postUploadS'){
	alert("게시글이 등록되었습니다.");
}
if(result=='ok'){
	alert("삭제되었습니다.");
}
if(result=='noLoginC'){
	alert("로그인 먼저 해주세요.");
}
if(result=='noComment'){
	alert("내용을 입력해 주세요.");
}
if(result=='updatePost'){
	alert("변경되었습니다.")
}
location.replace("../post/postRead.html?post_no="+no);

</script>
</body>
</html>