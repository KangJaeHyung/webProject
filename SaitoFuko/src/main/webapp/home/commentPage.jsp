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
.divP{
	display: grid;
	grid-template-columns: 140px 140px 140px;
  	grid-auto-rows: 140px;
    width: 100%;
    margin: 5px;
    padding: 15px;
}

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
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #EEEEEE;
  padding:1px;
  padding-left: 8px;
  
}

#customers tr:nth-child(even){
background-color: #f2f2f2;
}
#customers tr{
background-color: #E2E2E2;
}

#customers tr:hover{
background-color: #CCC;
}

#customers th{
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: rgb(80,80,80);
  color: white;
}
#myEmoList{
border: solid 1px;
position: absolute;
    background: #fff;
    z-index: 100;
    text-align: left;
}

</style>
<script type="text/javascript">
function emoClick() {
	 document.getElementById("myEmoList").style.display="block";
	 document.getElementById("btnEmo2").style.display="block";
	 document.getElementById("btnEmo1").style.display="none";
}
function emoClick2() {
	 document.getElementById("myEmoList").style.display="none";
	 document.getElementById("btnEmo2").style.display="none";
	 document.getElementById("btnEmo1").style.display="block";
	 
}

function tableClick(num,par){
	
	var html = "<form action='../comment/commentWrite.html' method='post'  onsubmit='return check(this)'>";
	html=html+'<table id="nob">';
	html=html+'<tr>';
	html=html+'<td><textarea rows="4" cols="100" style="width: 98%;height: auto; resize: none;" name="comment_content"></textarea></td>';
	html=html+'<td><input type="submit"  style="width: 75px; height: 75px;" value="답글 달기" /></td>';
	html=html+'</tr>';
	html=html+'<tr>';
	html=html+'<td align="left"><input type="button" id="btnEmo1" class="btnEmo" value="이모티콘" onclick="emoClick()" style="display: block;">';
	html=html+'<input type="button" id="btnEmo2" class="btnEmo" value="닫기" onclick="emoClick2()" style="display: none;">';
	html=html+'<div id="myEmoList" style="display: none; overflow:auto; max-height:450px; max-width:480px;">';
	html=html+'<div class="divP">';
	html=html+'<c:forEach  var="emo" items="${sessionScope.myEmoList}">'
	html=html+'<div>';
	html=html+'<a href="../comment/commentWrite.html?emo_id=${emo.emo_id}&post_no=${post.post_no}&comment_parent='+num+'">';
	html=html+'<img alt="" src="../emoticon/${emo.emo_picture}" width="130px" height="130px">';
	html=html+'</a>';
	html=html+'</div>';
	html=html+'</c:forEach>';
	html=html+'</div>';
	html=html+'</div>';
	html=html+'</td>';	
	html=html+'<td><input type="button" class="btnEmo" value="취소" onclick="tableClickClose('+num+')"></td>';
	html=html+'</tr>';
	html=html+'</table>';
	html=html+'<input type="hidden" name="post_no" value="${post.post_no}">';
	html=html+'<input type="hidden" name="comment_parent" value="'+num+'">';
	html=html+'	</form>';
    document.getElementById("div_"+num).innerHTML = html;
    document.getElementById("div_"+num).style.display="block";
    
 }

function tableClickClose(num) {
	document.getElementById("div_"+num).innerHTML = '';
    document.getElementById("div_"+num).style.display="none";
}

function emoticonSelect(emo,parent,post) {
	var href="../comment/commentWrite.html?emo_id="+emo+"&post_no="+post;
	if(parent!=null){
		href=href+"&comment_parent="+parent;
	}
	location.replace(href);
}

function check(frm){
	if(frm.comment_content.value==''){
		alert("내용을 입력해 주세요.")
		return false;
	}
	return true;
}
</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="customers" style="margin: 5px;">
	<c:forEach items="${commentList}" var="comment">
	<tr id="td_${comment.comment_no}_close">
		<td id="td_${comment.comment_no}_close" width="90" onclick="tableClick(${comment.comment_no})">
			${comment.nickname}
		</td>
		<td id="td_${comment.comment_no}_close" width="400" onclick="tableClick(${comment.comment_no})">
			<div >
				<c:if test="${comment.comment_content!=null}">
					${comment.comment_content}
				</c:if>
				<c:if test="${comment.emo_id!=null}">
					<br/><img alt="" src="../emoticon/${comment.emo_picture}" width="130px" height="130px">
				</c:if>
			</div>
		</td>
		<td id="td_${comment.comment_no}_close" width="120" onclick="tableClick(${comment.comment_no},${comment.comment_parent})">
			<font size=2>
				${comment.comment_date}
			</font>
		</td>
		<td width="50">
		<c:if test="${sessionScope.loginUser.user_id==comment.user_id||sessionScope.loginUser.user_id=='M'}">
		<a href="../comment/deleteComment.html?comment_no=${comment.comment_no}&post_no=${post.post_no}"><input type="button" class="btnEmo" value="삭제"></a>
		</c:if>
		</td>
	</tr>
	<tr ><td colspan="4"><div id="div_${comment.comment_no}" style="display:none;"></div></td></tr>
	</c:forEach>
</table>


<form action="../comment/commentWrite.html" method="post" onsubmit="return check(this)">
<table >
<tr>
<td><textarea rows="5" cols="100" style="width: 98%;height: auto; resize: none;" name="comment_content"></textarea>  </td>
<td><input type="submit"  style="width: 75px; height: 75px;" value="댓글 달기" /></td>
</tr>
<tr>
<td align="left"><input type="button" id="btnEmo1" class="btnEmo" value="이모티콘" onclick="emoClick()" style="display: block;">
<input type="button" id="btnEmo2" class="btnEmo" value="닫기" onclick="emoClick2()" style="display: none;">
<div id="myEmoList" style="display: none; overflow:auto; max-height:450px; max-width:480px;">
	<div class="divP">
	<c:forEach  var="emo" items="${sessionScope.myEmoList}">
		<div>
			<a href="../comment/commentWrite.html?emo_id=${emo.emo_id}&post_no=${post.post_no}">
				<img alt="" src="../emoticon/${emo.emo_picture}" width="130px" height="130px">
			</a>
		</div>
	</c:forEach>
	</div>
</div>
</td>
<td></td>
</tr>
</table>
<input type="hidden" name="post_no" value="${post.post_no}"> 
</form>
</body>
</html>