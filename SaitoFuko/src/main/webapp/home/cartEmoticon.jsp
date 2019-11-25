<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.shopTitle{
	border-radius: 40px 80px;
	border: solid;
	border-color: gray;
}
.shopContent{
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
  	grid-auto-rows: 265px;
    width: 100%;
    margin: 5px;
    padding: 15px;
}

@media(max-width: 700px){
.shopBtn {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: gray;
  width: 130px;
  border: 1;
  padding-right: 5px;
  padding-left: 5px;
  padding-top:2px;
  padding-bottom:2px;
  color: #FFFFFF;
  font-size: 35px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.shopBtn2{
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #AAAAAA;
  width: 130px;
  border: 1;
  padding-right: 10px;
  padding-left: 10px;
  padding-top:2px;
  padding-bottom:2px;
  color: #FFFFFF;
  font-size: 35px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}

}
.shopBtn {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: gray;
  width: 90px;
  border: 1;
  padding-right: 5px;
  padding-left: 5px;
  padding-top:2px;
  padding-bottom:2px;
  color: #FFFFFF;
  font-size: 10px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.shopBtn2{
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #AAAAAA;
  width: 90px;
  border: 1;
  padding-right: 10px;
  padding-left: 10px;
  padding-top:2px;
  padding-bottom:2px;
  color: #FFFFFF;
  font-size: 10px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.emoDiv{
margin-right: 20px;
}
.emoDiv:hover{
	border: solid 1px;
	border-color: gray;
	
	

}
</style>
<script type="text/javascript">
var result="${result}"
	if(result=='noLogin'){
		alert("로그인 먼저 해주세요.");
		self.close();
	}
	if(result=='outYes'){
		alert("찜이 해제되었습니다.");
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="shopTitle"><h2 align="center" class="title">내가 찜한 이모티콘!</h2></div>
<c:if test="${!empty sessionScope.myCartList}">
<div><a href="../shop/buyEmo.html"><input type="button" class="shopBtn" value="전부 구입하기" /></a></div>
<div class="shopContent" align="center">
	<c:forEach items="${sessionScope.myCartList}" var="emo">
	<div class="emoDiv">
		<table>
			<tr>
			<td><a href="#"><img alt="" src="../emoticon/${emo.emo_picture}" width="150" height="150"></a></td>
			</tr>
			<tr>
			<td>${emo.emo_name}</td>
			</tr>
			<tr>
			<td>${emo.emo_info}</td>
			</tr>
			<tr>
			<td align="center">
			<a href="../shop/buyEmo.html?emo_id=${emo.emo_id}"><input type="button" class="shopBtn" value="구입하기" /></a>
			<a href="../shop/outCartEmoPage.html?emo_id=${emo.emo_id}"><input type="button" class="shopBtn2" value="찜 해제" /></a>
			</td>
			</tr>
		</table>
	</div>
	</c:forEach>
</div>
</c:if>
<c:if test="${empty sessionScope.myCartList || sessionScope.myCartList==null}">
찜한 목록이 없습니다.
</c:if>
</body>
</html>