<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
			prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function idOK(){
	opener.document.form.user_id.readOnly=true;
	opener.document.form.idchecked.value="YES";
	self.close();
}
function idCancle(){
	self.close();
}
</script>
</head>
<body>
<h2 align="center">아이디 중복 확인</h2>
<c:if test="${DUP == 'YES'}">
	<script type="text/javascript">
	opener.document.form.user_id.value='';
	opener.document.form.idchecked.value='';
	</script>
${user_id}는 이미 사용중입니다.
<input type="button" value="취소" onClick="idCancle()"/>
</c:if>
<c:if test="${DUP != 'YES'}">
${user_id}는 사용 가능합니다. 사용하시겠습니까?
<input type="button" value="사용" onClick="idOK()"/>
</c:if>
</body>
</html>













