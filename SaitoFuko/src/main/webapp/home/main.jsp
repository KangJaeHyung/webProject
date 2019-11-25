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
<title>Welcome Saito Fuko</title>
<link href="https://fonts.googleapis.com/css?family=Yeon+Sung&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../cssImage/main.css">
<head>
<script type="text/javascript">
           var mobileKeyWords = new Array('iPhone', 'iPod', 'BlackBerry', 'Android', 'Windows CE', 'Windows CE;', 'LG', 'MOT', 'SAMSUNG', 'SonyEricsson', 'Mobile', 'Symbian', 'Opera Mobi', 'Opera Mini', 'IEmobile');
           for (var word in mobileKeyWords){
               if (navigator.userAgent.match(mobileKeyWords[word]) != null){
                         window.location.href = "../home/mobile.jsp";
                   break;
                }
           }

</script>
<style>

* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
  background-image: url("../cssImage/body.png");
  background-repeat: no-repeat;
  background-size: 100% auto;
  background-image: center;
}


.head {
  margin-left:10%;
  margin-right:auto;
  background-image:url("../cssImage/title.png");
  padding: 15px;
  width:1080px;
  text-align: center;
  font-size: 35px;
  margin-top: 5px;
  margin-bottom: 5px;
  cursor: pointer;
  
}

.footer {
	margin-left:10%;
	margin-right:auto;
  padding: 15px;
  width:1080px;
  text-align: center;
  font-size: 35px;
  margin-top: 5px;
  margin-bottom: 5px;
}


.grid-container {
margin-left:10%;
margin-right:auto;
width:1080px;
  display: grid;
  grid-gap : 5px;
  grid-template-columns: 1fr 4fr;

} 


.left,
.middle{
 height: auto;
  padding: 10px;
}


.left {
 
  padding-top:20px;
  padding-bottom: 20px; 
  }


/* Style the footer */
.footer {
  grid-area: footer;
  background-color: #f1f1f1;
  padding: 10px;
  text-align: center;
}




.btnOpt {
  border-radius: 40px / 40px;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
}

.btnOpt {
  color: black;
  border: 2px solid #555555;
}

.btnOpt:hover {
  background-color: #555555;
  color: white;
}

#utilDiv{
padding:5px;
 padding-left:10%; 
 padding-right: 50xp;
}


</style>
</head>
<body >

<div align="right" style="width: 1080px; margin-left:10%;
	margin-right:auto;">
	<a href="../shop/shopPage.html">상점</a>&nbsp;|&nbsp;
	<a href="#" onclick="window.open('../home/myEmo.html','cart','width=600,height=400').focus()">내 이모티콘</a>&nbsp;|&nbsp;
	<a href="#" onclick="window.open('../home/cartEmo.html','cart','width=600,height=400').focus()">찜</a>
</div>
<div class="head" onclick="location.href='../home/main.jsp'">
    <h2 align="center"><font color="#DDDDDD">Saito Fuko</font></h2>
 </div>
<div class="grid-container">
	<div class="left" style="background-color:#aaa;">
		<div style="border: inset; margin-bottom: 5px;"> 
			<c:if test="${sessionScope.loginUser==null}">
 	 			<jsp:include page="../home/loginForm.html"></jsp:include>
 	 		</c:if>
 	 		<c:if test="${sessionScope.loginUser!=null}">
 	 			<jsp:include page="../home/logoutForm.jsp"></jsp:include>
 	 		</c:if>
 			 </div>
 			 <div style="border: inset; margin-bottom: 5px;">
 			 <c:if test="${sessionScope.loginUser!=null}"> 
 			 <c:if test="${sessionScope.loginUser.user_stat eq 'M'}">
 			 <div align="center">	
 					<a href="../manage/BoardManage.html"><input type="button" class="btnOpt" value="게시판 관리" /></a>
 			 </div>
 			 </c:if>
 			</c:if>
 			 <div style="margin-left:10px;margin-top:10px; margin-right:10px; line-height:1.4em;">
				<jsp:include page="../manage/boardList.html"></jsp:include>
 			 </div>
 			 <div>
 			 <img alt="" src="../cssImage/logo.png" width="100%" height="100%">
 			 </div>
 		 </div>
	</div>
	<c:if test="${BODY!=null}">
	<div class="middle" style="background-color:#bbb;">
		
			<jsp:include page="${BODY}"></jsp:include>
		</div>   
	</c:if>
	<c:if test="${BODY==null}">
		<div class="middle">
			<img alt="" src="../cssImage/main.png" width="100%" height="auto" align="middle">
		</div>   
	</c:if>
</div>
 <div class="footer" >
	<font size="2">
	Copyright ⓒ 2019-2019 Lobotomy Corp. All rights reserved<br/>
		관리자 : 강 재 형 <br/>
		E-Mail: rkdwo321@naver.com
	</font>
  </div>


</body>
</html>