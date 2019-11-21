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
function doIt() {
	var form=${form};
	var input = document.getElementsByClassName(form).value;
	if(input==''){
		alert("정보를 입력해 주세요.");
		return false;
	}
	if(form=="Email"){
		var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if(!emailRule.test(input)) {            
			alert("이메일을 정확하게 입력하세요.");
		            return false;
		}
	}
	
	return true;
}

</script>
<c:if test="${form=='no'}">
<script type="text/javascript">
	alert("비밀번호가 틀립니다.");
	location.replace("../home/userPage.html");
</script>
</c:if>
<h2 class="title" align="center">변경하실 ${form}를 입력해 주세요.</h2>
<br/>
<br/>
<form:form modelAttribute="user_info" method="post" action="../modify/modifyUser.html" onsubmit="return doIt(this)">
<div align="center">
<c:if test="${form=='Password'}">
	<form:password path="password" placeholder="password" cssClass="Password" size="30" />
</c:if>
<c:if test="${form=='Nickname'}">
	<form:input path="nickname" placeholder="nickname" cssClass="Nickname" size="30" />
</c:if>
<c:if test="${form=='Gender'}">
	<form:select path="gender" cssClass="Gender">
							<form:option value="남자" />
							<form:option value="여자" />
	</form:select>
</c:if>
<c:if test="${form=='Email'}">
	<form:input path="email" placeholder="Email" cssClass="Email" size="50" />
</c:if>
<c:if test="${form=='Name'}">
	<form:input path="user_name" placeholder="Name" cssClass="Name" size="30" />
</c:if>
<c:if test="${form=='Birthday'}">
	<input type="date" id="birthday" class="Birthday" name="birthday" value="1900-01-01" min="1900-01-01" max="2030-12-31">
</c:if>
</div>
<div align="center"><input type="submit" class="findBtn" value="확인" ></div>
</form:form>
</body>
</html>