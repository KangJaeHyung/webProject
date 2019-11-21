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
.btnWrite {
  background-color: gray;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 25px;
  margin: 4px 2px;
  cursor: pointer;
  width: 100%;
}

</style>
</head>
<body>
<a href="../post/PostForm.html" class="btnWrite">글쓰기</a>
<ul >
	<li><a href="../post/postList.html" style="text-decoration:none"><font color="black">전체 게시판</font></a></li>
</ul>
<hr style="border: solid #dedede; border-width: 1px 0 0;">
<ul >
	<c:forEach var="board" items="${boardList}">
		<li><a href="../post/postList.html?board_id=${board.board_id}" style="text-decoration:none"><font color="black">${board.board_name }</font></a></li>
	</c:forEach>
</ul>
</body>
</html>