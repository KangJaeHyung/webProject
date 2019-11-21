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
<link href="https://fonts.googleapis.com/css?family=Yeon+Sung&display=swap" rel="stylesheet">
<style type="text/css">

</style>
<script type="text/javascript">
function check(fm){
	if(fm.idchecked.value == ''){
		alert("ID중복 검사를 해주세요.");
		return false;
	}
	if(fm.user_id.value == ''){
		alert("id를 입력해주세요."); 
		fm.user_id.focus();		return false;
	}
	if(fm.nickname.value ==''){
		alert("닉네임을 입력해 주세요.");
		fm.nickname.focus();		return false;
	}
	if(fm.password.value == ''){
		alert("암호를 입력하세요.");
		fm.password.focus(); return false;
	}
	var checkNumber = fm.password.value.search(/[0-9]/g);
	var checkEnglish = fm.password.value.search(/[a-z]/ig);
	var pas=/^[a-zA-Z0-9]{6,20}$/;
	if(!pas.test(fm.password.value)) {            
		alert("6~20 자리 이내의 문자와 숫자로 이루어진 암호를 입력해 주세요.");
	            return false;
	}
	if(checkNumber <0 || checkEnglish <0){
		alert("숫자와 영문자를 혼용하여야 합니다.");
		return false;
	}
	if(fm.password.value!=fm.confirm.value){
		alert("암호가 일치하지 않습니다.");
		fm.password.focus(); return false;
	}
	if(fm.user_name.value == ''){
		alert("이름을 입력하세요."); 
		fm.user_name.focus();		return false;
	}
	if(fm.email.value == ''){
		alert("이메일을 입력하세요.");
		fm.email.focus();	return false;
	}
	var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(!emailRule.test(fm.email.value)) {            
		alert("이메일을 정확하게 입력하세요.");
	            return false;
	}
	
	
	if( confirm("입력한 내용이 맞습니까?")){
		return true;
	}else {
		return false;
	}
}
function idCheck(){
	if(document.form.user_id.value == ''){
		alert("아이디를 입력하세요.");
		document.form.user_id.focus();	
		return;
	}
	var url="../idcheck/idcheck.html?user_id="+document.form.user_id.value;
	window.open(url,"_blank","width=450,height=200");
}
</script>
</head>
<body>
<h1 align="center" class="entryTitle">회원 가입</h1>
		<form:form modelAttribute="user_info" name="form" action="../entry/entry.html" method="post" onsubmit="return check(this)">
		<input type="hidden" name="idchecked" id="idchecked"/>
			<table>
				<tr>
					<td><form:input path="user_id" placeholder="ID" cssClass="user_id" size="30" /></td>
					<td><input type="button" class="idCheck" value="중복 확인" onclick="idCheck()"> </td>
				</tr>
				<tr>
					<td><form:input path="nickname" placeholder="nickname" cssClass="nickname" size="30" /></td>
				</tr>
				<tr>
					<td><form:password path="password" placeholder="password" cssClass="password" size="30" /></td>
				</tr>
				<tr>
					<td><input type="password" placeholder="confirm" id="confirm" class="password" size="30" /></td>
				</tr>
				<tr>
					<td><form:input path="user_name" placeholder="Name" cssClass="name" size="30" /></td>
				</tr>
				<tr>
					<td><form:input path="email" placeholder="Email" cssClass="email" size="50" /></td>
				</tr>
				<tr>
					<td>
						<form:select path="gender" cssClass="gender">
							<form:option value="남자" />
							<form:option value="여자" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td><input type="date" id="birthday" class="birthday" name="birthday" value="1900-01-01" min="1900-01-01" max="2030-12-31"></td>
				</tr>
				<tr>
					<td align="right"><input class="submit" type="submit" value="제출" /></td>
				</tr>
			</table>
		</form:form>
	
</body>
</html>