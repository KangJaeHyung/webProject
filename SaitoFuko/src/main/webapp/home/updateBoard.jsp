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
</style>
</head>
<body>
<script type="text/javascript">
function del() {
	if(confirm("정말 삭제 하시겠습니까?")){
		var id= '${board.board_id}'
		location.replace("../manage/deleteBoard.html?board_id="+id);
	}
}
</script>

<h2 align="center" class="title">게시판 정보 변경</h2>
<div align="center">
<form:form modelAttribute="board" name="board" action="../manage/updateBoard.html" method="post" onsubmit="return check(this)">
		<form:hidden path="board_id"/>
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
					<input type="number" name="board_location" placeholder="게시판 순서" Class="email" size="30" min="1" max="99" value="${board.board_location}"></td>
					<td><div align="center"  class="tooltip">?
						  <span class="tooltiptext">숫자가 높을수록 아래쪽에 위치함
						  </span>
						</div></td>
				</tr>
				<tr>
					<td align="right"><input class="submit" type="button" value="게시판 삭제" onclick="del()" /></td>
					<td align="right"><input class="submit" type="submit" value="제출" /></td>
				</tr>
			</table>
		</form:form>
		</div>
</body>
</html>