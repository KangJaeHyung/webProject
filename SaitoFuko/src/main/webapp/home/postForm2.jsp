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
moz-appearance: textfield-multiline;
    -webkit-appearance: textarea;
    border: 1px solid gray;
    font: medium -moz-fixed;
    font: -webkit-small-control;
    overflow: auto;
    padding: 2px;
    resize: both;
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

</style>


<script type="text/javascript">
function jung(str) {
	document.execCommand(str);
}

function font(frm){
	document.execCommand('fontSize', false, frm.value);
}
function fontColor(frm){
	document.execCommand('fontColor', false, frm.value);
}
function image(){
	var url="../post/image.html";
	window.open(url,"_blank","width=450,height=200");
}
</script>


</head>
<body>
<h2 align="center" class="title">게시글 쓰기</h2>
<form name="form" method="post" action="../post/postWrite.html"> 

<div>
<div style="padding:5px; padding-left:10%; padding-right: 50xp;">
<input class="postTitle" name="title" placeholder="제목을 적어 주세요."/>
&nbsp;&nbsp;
</div>

<div style="padding-left:10%; align-content: center; align-items: center;margin-top: 5px; margin-bottom:5px;">
<input type="button" id="justifyLeft" class="postBtn" onclick="jung('justifyleft')"/>
<input type="button" id="justifyCenter" class="postBtn" onclick="jung('justifyCenter')"/>
<input type="button" id="justifyRight" class="postBtn" onclick="jung('justifyRight')"/>
<input type="button" id="bold" value="두껍게" class="postBtn" onclick="jung('bold')"/>
<input type="button" id="italic" value="기울기" class="postBtn" onclick="jung('italic')"/>
<input type="button" id="underLine" value="밑줄"class="postBtn" onclick="jung('underLine')"/>
 <select id="fontSize" style="width: 100px;height: 21px; margin:0px;" onchange="font(this)">
        <option value="">글자 크기</option>
        <option value="1">4px</option>
        <option value="2">8px</option>
        <option value="3">10px</option>
        <option value="4">12px</option>
        <option value="5">16px</option>
        <option value="6">20px</option>
        <option value="7">30px</option>
    </select>
     <select id="fontColor" style="width: 100px;height: 21px; margin:0px;" onchange="fontColor(this)">
        <option value="">글자 색깔</option>
        <option value="#f00">빨강</option>
        <option value="#00f">파랑</option>
        <option value="#0f0">초록</option>
        <option value="#ffff00">노랑</option>
        <option value="#000">검정</option>
    </select>
</div>
<div align="center"><div id="text" contenteditable="true"></div></div>
<div align="right"><input type="button" id="imageButton" value="이미지 추가하기" onclick="image()"/></div>
<div align="right"><input type="submit" value="등록하기"></div>
<input type="hidden" name="content" value="">
</div>
</form>
</body>
</html>