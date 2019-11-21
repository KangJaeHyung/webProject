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
	grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-rows: 330px 330px 330px;
    width: 100%;
    margin: 5px;
    padding: 15px;
}
.shopBtn {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: gray;
  width: 90px;
  border: 1;
  padding: 10px;
  color: #FFFFFF;
  font-size: 14px;
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
  padding: 10px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.emoDiv:hover{
	border: solid 1px;
	border-color: gray;
	

}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="shopTitle"><h2 align="center" class="title">이모티콘 상점</h2></div>
<div class="shopContent" align="center">
	<c:forEach items="#{emoList}" var="emo">
	<div class="emoDiv">
		<table>
			<tr>
			<td><a href="#" onclick="window.open('../shop/buyEmo.html?emo_id=${emo.emo_id}','cart','width=600,height=400').focus()"><img alt="" src="../emoticon/${emo.emo_picture}" width="200" height="200"></a></td>
			</tr>
			<tr>
			<td>${emo.emo_name}</td>
			</tr>
			<tr>
			<td>${emo.emo_info}</td>
			</tr>
			<tr>
			<td>${emo.emo_price} 원</td>
			</tr>
			<tr>
			<td align="center">
			<a href="#" onclick="window.open('../shop/buyEmo.html?emo_id=${emo.emo_id}','cart','width=600,height=400').focus()"><input type="button" class="shopBtn" value="구입하기" /></a>
			<c:if test="${emo.emo_cart==false}">
			<a href="../shop/inCartEmo.html?emo_id=${emo.emo_id}&pageNum=${pageNum}"><input type="button" class="shopBtn" value="찜하기"/></a>
			</c:if>
			<c:if test="${emo.emo_cart==true}">
			<a href="../shop/outCartEmo.html?emo_id=${emo.emo_id}&pageNum=${pageNum}"><input type="button" class="shopBtn2" value="찜 해제"/></a>
			</c:if>
			</td>
			</tr>
		</table>
	</div>
	</c:forEach>
</div>
<div align="center">
<table>
<tr>

<td>
<c:if test="${pageNum==1}">
<font color="red">◀</font>
</c:if>
<c:if test="${pageNum!=1}">
<a href="../shop/shopPage.html?pageNum=${pageNum-1}" style="text-decoration: none;"><font color="gray">◀</font></a>
</c:if>
</td>
<c:forEach var="cnt" begin="1"  end="${pageCount}">
	<td>
	<c:if test="${pageNum!=cnt}">
		<a href="../shop/shopPage.html?pageNum=${cnt}" style="text-decoration: none;"><font color="gray">${cnt}</font></a>
	</c:if>
	<c:if test="${pageNum==cnt}">
		<font color="red">${cnt}</font>
	</c:if>
	</td>	
</c:forEach>
<td>
<c:if test="${pageNum==pageCount}">
<font color="red">▶</font>
</c:if>
<c:if test="${pageNum!=pageCount}">
<a href="../shop/shopPage.html?pageNum=${pageNum+1}" style="text-decoration: none;"><font color="gray">▶</font></a>
</c:if>
</td>
</tr>
</table>
</div>
</body>
</html>