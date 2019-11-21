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
<script type="text/javascript">
function check(fm){
	if(fm.board_name.value == ''){
		alert("게시판 이름을 입력해주세요."); 
		fm.board_name.focus();		return false;
	}
	if(fm.board_location.value ==''){
		alert("게시판 위치를 입력해 주세요.");
		fm.board_location.focus();	return false;
	}
	if(confirm("등록하시겠습니까?")){
		return true;
	}
	return false;
}


</script>

<style type="text/css">
.setConttent{
	display: grid;
	grid-template-columns: 1fr 1fr;
	height:auto;
    width: 100%;
    margin: 5px;
    padding: 15px;
    grid-gap : 5px;
}

.tooltip {
border-radius: 50%;
	border: solid;
	border-color: gray;
	background: gray;
	font-size:10;
	width: 23px;
	color: white;
}

.tooltip {
  position: relative;
  display: inline-block;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 420px;
  background-color: #555;
  
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;
  position: absolute;
  z-index: 1;
  bottom: 125%;
  left: 50%;
  margin-left: -60px;
  opacity: 0;
  transition: opacity 0.3s;
}

.tooltip .tooltiptext::after {
  content: "";
  position: absolute;
  top: 100%;
  left: 15%;
  margin-left: -7px;
  border-width: 5px;
  border-style: solid;
  border-color: #555 transparent transparent transparent;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
  opacity: 1;
}

#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding:1px;
  padding-left: 8px;
}

#customers tr:nth-child(even){
background-color: #f2f2f2;
}

#customers tr:hover{
background-color: #ddd;
}

#customers th{
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: rgb(80,80,80);
  color: white;
}

.btnUp {
  border-radius: 40px / 40px;
  border: none;
  color: white;
  padding: 4px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
}

.btnUp {
  color: black;
  border: 2px solid #555555;
}

.btnUp:hover {
  background-color: #555555;
  color: white;
}
</style>

</head>
<body>
<h2 class="title" align="center">
게시판 관리
</h2>
<div class="setConttent">
	<div style="border:inset 1px;">
	<h2 class="title" align="center">
		게시판 생성
	</h2>
	<form:form modelAttribute="board" name="board" action="../manage/addBoard.html" method="post" onsubmit="return check(this)">
			<table>
				<tr>
					<td><form:input path="board_name" placeholder="게시판 이름" cssClass="nickname" size="30" /></td>
				</tr>
				<tr>
					<td>
						<form:select path="board_grade" placeholder="게시판 등급(숫자로)" cssClass="nickname">
							<form:option value="1" />
							<form:option value="2" />
							<form:option value="3" />
						</form:select>
					</td>
					<td>
						<div align="center" class="tooltip">?
						  <span class="tooltiptext">1:모두 볼수있음/매니저만 글작성 가능<br>
							  						2:일반 유저이상 볼수 있음/일반 유저 이상만 글 작성 가능<br>
							  						3:매니저만 볼수 있음/매니저만 글 작성 가능<br>
						  </span>
						</div>
					</td>
				</tr>
				<tr>
					<td>
					<input type="number" name="board_location" placeholder="게시판 순서" Class="email" size="30" min="1" max="99"></td>
					<td><div align="center"  class="tooltip">?
						  <span class="tooltiptext">숫자가 높을수록 아래쪽에 위치함
						  </span>
						</div></td>
				</tr>
				<tr>
					<td align="right"><input class="submit" type="submit" value="제출" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div style="border:inset 1px;">
		<h2 class="title" align="center">
		게시판 수정
		</h2>
		<div align="center" style="margin-left: 5px;margin-right: 5px;">
			<table id="customers">
				<tr>
					<th width="200" style="">이름</th>
					<th width="100">등급</th>
					<th width="100">위치</th>
					<th width="auto"></th>
				</tr>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td >${board.board_name}</td>
						<td >${board.board_grade}</td>
						<td >${board.board_location}</td>
						<td><a href="../manage/boardUpdate.html?board_id=${board.board_id}"><input type="button" class="btnUp" value="정보 수정"></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
	</div>
</div>


</body>
</html>