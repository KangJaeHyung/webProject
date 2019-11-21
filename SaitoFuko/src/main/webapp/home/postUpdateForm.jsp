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
.postTitle{
 	width: 400px;
 	border: inset 2px;
}
#text{

	margin:auto;
	moz-appearance: textfield-multiline;
    -webkit-appearance: textarea;
    border: 1px solid gray;
    font: medium -moz-fixed;
    font: -webkit-small-control;
    overflow: auto;
    padding: 2px;
    resize: none;
	width:80%; height:400px; background:#FFFFFF;
	border: inset 2px;

}
#justifyRight,#justifyCenter,#justifyLeft{
width:22px;
height:21px;
border:none;
margin:0px;
}
#justifyRight{
  background: url( "../cssImage/오른쪽 정렬.png" ) no-repeat;
}
#justifyCenter{
  background: url( "../cssImage/가운데 정렬.png" ) no-repeat;
}
#justifyLeft{
  background: url( "../cssImage/왼쪽 정렬.png" ) no-repeat;
}
#justifyRight:active{
  background: url( "../cssImage/오른쪽 정렬 press.png" ) no-repeat;
}
#justifyCenter:active{
  background: url( "../cssImage/가운데 정렬 press.png" ) no-repeat;
}
#justifyLeft:active{
  background: url( "../cssImage/왼쪽정렬 press.png" ) no-repeat;
}

#imageButton{
	margin:3px;		
	margin-right:10%;

}
</style>


<script type="text/javascript">

function formCheck(form) {
    var con = document.getElementById("text").innerHTML;
	form.content.value=con;
	if(form.title.value==''){
		alert("제목을 입력해 주세요.");
		return false;
	}
	if(form.content.value==''){
		alert("내용을 적어주세요.");
		return false;
	}
	if(confirm("수정하시겠습니까??")){
		return true;
	}
	return false;
}


function jung(str) {
	document.execCommand(str);
}
function image(){
	var url="../post/image.html";
	window.open(url,"image","width=450,height=200");
}
</script>

<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script>
  document.execCommand('styleWithCSS', false, true);
  document.execCommand('insertBrOnReturn', false, true);
  $(document).ready(function() {
    $("#text").focus();
 	$("#foreColor").change(function(){ 
   		document.execCommand('foreColor', false, $(this).val());
    });
 	
 	$("#fontSize").change(function(){
  		document.execCommand('fontSize', false, $(this).val());
	});
  });
</script>

</head>
<body>
<h2 align="center" class="title">게시글 수정</h2>
<form:form modelAttribute="post" name="form" method="post" action="../post/postUpdate.html" onsubmit="return formCheck(this)"> 
<form:hidden path="post_no"/>
<form:hidden path="user_id"/>
<form:hidden path="origin_no"/>
<form:hidden path="group_ord"/>
<form:hidden path="groupLayer"/>
<div>
<div style="padding:5px; padding-left:10%; padding-right: 50xp;">
<form:input cssClass="postTitle" path="title" placeholder="제목을 적어 주세요."/>
&nbsp;&nbsp;
<form:select path="board_id">
<c:forEach var="board" items="${boardList}">
<form:option value="${board.board_id}">${board.board_name}</form:option>
</c:forEach>
</form:select>
</div>

<div style="padding-left:10%; align-content: center; align-items: center;margin-top: 5px; margin-bottom:5px;">
<input type="button" id="justifyLeft" class="postBtn" onclick="jung('justifyleft')"/>
<input type="button" id="justifyCenter" class="postBtn" onclick="jung('justifyCenter')"/>
<input type="button" id="justifyRight" class="postBtn" onclick="jung('justifyRight')"/>
<input type="button" id="bold" value="두껍게" class="postBtn" onclick="jung('bold')"/>
<input type="button" id="italic" value="기울기" class="postBtn" onclick="jung('italic')"/>
<input type="button" id="underLine" value="밑줄"class="postBtn" onclick="jung('underLine')"/>
 <select id="fontSize" style="width: 100px;height: 21px; margin:0px;">
        <option value="">글자 크기</option>
        <option value="1">4px</option>
        <option value="2">8px</option>
        <option value="3">10px</option>
        <option value="4">12px</option>
        <option value="5">16px</option>
        <option value="6">20px</option>
        <option value="7">30px</option>
    </select>
     <select id="foreColor" style="width: 100px;height: 21px; margin:0px;">
        <option value="">글자 색깔</option>
        <option value="#f00">빨강</option>
        <option value="#00f">파랑</option>
        <option value="#0f0">초록</option>
        <option value="#ffff00">노랑</option>
        <option value="#000">검정</option>
    </select>
</div>
	<div id="text" contenteditable="true">${post.content}</div>
<div align="right"><input class="btn1" type="button" id="imageButton" value="이미지 추가" onclick="image()"/></div>
<div align="right"><input class="btn1" id="imageButton" type="submit" value="수정하기"></div>
<input type="hidden" name="content" value="">
</div>
</form:form>
</body>
</html>