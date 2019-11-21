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
  border-radius: 40px / 40px;
  border: none;
  color: white;
  padding: 4px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  margin: 0px 2px;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
}

.btnEmo {
  color: black;
  border: 2px solid #555555;
}

.btnEmo:hover {
  background-color: #555555;
  color: white;
}


</style>
</head>
<body>
<script type="text/javascript">
function checkDelete() {
	var no=${post.post_no};
	if(confirm("정말 삭제합니까?")){
		location.replace("../post/deletePost.html?post_no="+no);
	}
} 


</script>
<div align="right"><a href="../post/postList.html?board_id=${post.board_id}">${post.board_name}</a></div>
<div style="border-bottom:1px solid; width: 90%;margin:auto; margin-bottom:5px;">
<h3 align="left" class="title" style="margin-bottom:3px;">${post.title}</h3>
<div style="margin-bottom:3px;">
<span>${post.nickname}(${post.user_id})&nbsp;</span>
<span>${post.post_date}</span>
<span style="float:right; margin-right: 10px;">조회수 : ${post.post_views}</span>
</div>
</div>
<div style="width: 90%;  height:auto; padding:2%; margin: auto; border:solid 1px; background-color: white">
	<div>${post.content}</div><br/>
</div>
<c:if test="${sessionScope.loginUser.user_id==post.user_id||sessionScope.loginUser.user_stat=='M'}">
<div align="right" style="margin-right: 5%; margin-top:5px;">
<a href="../post/updatePostForm.html?post_no=${post.post_no}"><input type="button" class="btnEmo" value="수정"></a>
<a href="#" onclick="checkDelete()"><input type="button" class="btnEmo" value="삭제"></a>
</div>
</c:if>
<div style="margin: auto; width:90%;">
<jsp:include page="../comment/readComment.html"></jsp:include>
</div>
</body>
</html>


