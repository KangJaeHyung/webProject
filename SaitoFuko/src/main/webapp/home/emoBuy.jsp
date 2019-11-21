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

.title{
font-family: 'Yeon Sung', cursive;
}

.btn{
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #AAAAAA;
  width: 90px;
  border: 1;
  padding: 10px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
</style>
</head>
<body>
<script type="text/javascript">
var result="${result}"
if(result=='noLogin'){
	alert("로그인 먼저 해주세요.");
	self.close();
}

function doIt() {
	if(confirm("정말로 구매 하시겠습니까?")){
		return true;
	}
	return false;
}

</script>
<h2 class="title" style="background-color:gray; color: white; border: solid 2px;" align="center">이모티콘 구입하기</h2>
<div align="center">
<table border="1">
	<tr >
		<td>이모티콘</td><td width="200">이름</td><td width="150">설명</td><td width="120">가격</td>
	</tr>
	<c:set var="total" value="0"/>
	<c:forEach var="list" items="${emoList}">
	<tr>
		<td><img src="../emoticon/${list.emo_picture}" alt="" width="100" height="100"/></td>
		<td>${list.emo_name}</td><td>${list.emo_info}</td><td>${list.emo_price}</td>
	</tr>
	<c:set var="total" value="${total+list.emo_price}"/>
	</c:forEach>
</table>
</div>
<div class="title">총합 : ${total}원 입니다.</div>
<form:form modelAttribute="have_emo_info_list" action="../shop/emoBuyResult.html" method="post" onsubmit="return doIt();">
<c:forEach var="list" items="${emoList}">
<input type="hidden" name="emoList" value="${list}"/>
</c:forEach>
<input class="btn" type="submit" value="구입 하기" />
</form:form >
</body> 
</html>