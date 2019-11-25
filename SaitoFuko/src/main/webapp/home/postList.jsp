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
.btnEmo {
  color: black;
  border: 2px solid #555555;
}

.btnEmo:hover {
  background-color: #555555;
  color: white;
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
cursor:pointer;
}

#customers th{
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: rgb(80,80,80);
  color: white;
}

</style>
</head>
<body>
<h2 class="title" align="center">${board_name}</h2>
<table id="customers" class="moblieT">
				<tr>
					<th id="no" width="70">no</th>
					<th width="700" >제목</th>
					<th width="80">id</th>
					<th width="80">날짜</th>
					<th id="no" width="50">조회</th>
				</tr>
				<c:forEach var="post" items="${postList}">
					<tr onclick="location.href='../post/postRead.html?post_no='+'${post.post_no}'">
						<td id="postFont">${post.post_no}</td>
						<td id="postTitle"><a>[${post.board_name}]</a>${post.title}</td>
						<td id="postFont">${post.nickname}(${post.user_id})</td>
						<td>${post.post_date}</td>
						<td id="postFont">${post.post_views}</td>
					</tr>
				</c:forEach>
			</table>
<table id="pageNumber">
<tr>
<td>
<c:if test="${pageNum==1}">
<font color="red">◀</font>
</c:if>
<c:if test="${pageNum!=1}">
<c:if test="${board_id==null}">
	<a href="../post/postList.html?pageNum=${pageNum-1}" style="text-decoration: none;"><font color="gray">◀</font></a>
</c:if>
<c:if test="${board_id!=null}">
	<a href="../post/postList.html?pageNum=${pageNum-1}&board_id=${board_id}" style="text-decoration: none;"><font color="gray">◀</font></a>
</c:if>
</c:if>
</td>
<c:forEach var="cnt" begin="1"  end="${pageCount}">
	<td>
	<c:if test="${pageNum!=cnt}">
		<c:if test="${board_id==null}">
		<a href="../post/postList.html?pageNum=${cnt}" style="text-decoration: none;"><font color="gray">${cnt}</font></a>
		</c:if>
		<c:if test="${board_id!=null}">
		<a href="../post/postList.html?pageNum=${cnt}&board_id=${board_id}" style="text-decoration: none;"><font color="gray">${cnt}</font></a>
		</c:if>
	
	
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
		<c:if test="${board_id==null}">
		<a href="../post/postList.html?pageNum=${pageNum+1}" style="text-decoration: none;"><font color="gray">▶</font></a>
		</c:if>
		<c:if test="${board_id!=null}">
		<a href="../post/postList.html?pageNum=${pageNum+1}&board_id=${board_id}" style="text-decoration: none;"><font color="gray">▶</font></a>
		</c:if>
</c:if>
</td>
</tr>
</table>
<c:if test="${board_id==null}">
<div align="right"><a href="../post/PostForm.html"><input type="button" class="btnEmo" value="게시글 쓰기"></a></div>
</c:if>
<c:if test="${board_id!=null}">
<div align="right"><a href="../post/PostForm.html?board_id=${board_id}"><input type="button" class="btnEmo" value="게시글 쓰기"></a></div>
</c:if>		
			
			
</body>
</html>