<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<!DOCTYPE html>
<html>
<head>
<title>Welcome Saito Fuko</title>
<link rel="stylesheet" type="text/css" href="../cssImage/mainMobile.css">
<style>


.head {
 /*  background-image:url("../cssImage/title.png");
  background-repeat: no-repeat; */
  background-color:#ffc0ed;
  height:10%;
  padding: 15px;
  width:100%;
  text-align: center;
  font-size: 20px;
  
}

.grid-container {
  width:100%;
} 


#left,
.middle{
 height: 100%;
  padding: 10px;
}

.middle{
min-height:1400px;
}

#left {
  width: 500;
   position: fixed;
   top: 0;
  left: -500px;
 height: 100vh;
 z-index: 999;
  transition: all 0.3s;
  overflow-y: scroll;
  box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.2);
  padding-top:20px;
  padding-bottom: 20px; 
  }

#left.active{
 	left: 0px;
}  
  
  
.footer {
  padding: 15px;
  width:100%;
  text-align: center;
  font-size: 35px;
  margin-top: 5px;
  margin-bottom: 5px;
}


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

.btnOpt {
  border-radius: 40px / 40px;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 35px;
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


.overlay {
    position: fixed;
    width: 100vw;
    height: 100vh;
    background: rgba(0, 0, 0, 0.7);
    z-index: 998;
    display: none;
}

#mobileLeft li{
	line-height: 100px;
	font-size: 50px;
}

#pageNumber{
	font-size: 70px;
}
#pageNumber td{ 
	width: 100px;
}
.btnLogin {
  background-color: green;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 50px;
  margin: 4px 2px;
  cursor: pointer;
  width: 100%;
}
#postTitle{
	font-size: 40px;
}
#postFont{
	font-size:25px;
}

.moblieT td{
	height: 100px;

}
.moblieT th{
	font-size: 30px;
}
.moblieT #no{
	font-size: 18px;
}
.middle div{
font-size:1.2em;
}
.middle #justifyRight{
	background-size: 50px;
	width: 50px;
	height: 50px;
}

.middle #justifyCenter{
background-size: 50px;
	width: 50px;
	height: 50px;
}

.middle #justifyLeft{
background-size: 50px;
	width: 50px;
	height: 50px;
}
.middle .postBtn{
	height: 50px;
	font-size: 35px;
}
.middle #fontSize{
	height: 50px;
	font-size:25px;
	width: auto;
}
.middle #foreColor{
	height: 50px;
	font-size:25px;
	width: auto;
}
.middle #text{
width: 95%;
height: 600px;

}

.middle .postTitle{
 	width: 70%;
 	height 50px;
 	border: inset 2px;
 	font-size: 35px;
}
.middle #imageButton{
	margin-right: 2.5%;

}
.middle .btnEmo{
  font-size: 35px;
}
#utilDiv{
padding:5px;
 padding-left:2.5%; 
}
.middle .shopContent{
 grid-template-rows: 360px 360px 360px;
}
</style>

 <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
 <script type="text/javascript">
	$(document).ready(function () {
                $('.overlay').on('click', function () {
                    $('#left').removeClass('active');
                    $('.overlay').fadeOut();
                });

                $('#sidebarCollapse').click(function () {
                    $('#left').addClass('active');
                    $('.overlay').fadeIn();
            
                });
     });
	</script>


</head>
<body marginwidth="0px" marginheight="0px">
<div class="overlay"></div>
<nav id="left" style="background-color:#aaa;">
		<div style="border: inset; margin-bottom: 5px;"> 
			<c:if test="${sessionScope.loginUser==null}">
 	 			<a href="../login/mobileLogin.html" class="btnLogin">로그인</a>
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
 			 <div id="mobileLeft" style="margin-left:10px;margin-top:10px; margin-right:10px; line-height:1.4em;">
				<jsp:include page="../manage/boardList.html"></jsp:include>
 			 </div>
 			 <div>
 			 <img alt="" src="../cssImage/logo.png" width="100%" height="100%">
 			 </div>
 		 </div>
	</nav>

<div class="head">
	<img id="sidebarCollapse"  alt="" src="../cssImage/100.png" height="80px;" width="auto;" align="middle" style="float:left; margin-top:15px;">
	<div style="float: right; margin-top: 15px;">
	<a href="../shop/shopPage.html"><font size="8">Store</font></a>&nbsp;|&nbsp;
	<a href="#" onclick="window.open('../home/myEmo.html','cart','width=600,height=400').focus()"><font size="8">MyEmo</font></a>&nbsp;|&nbsp;
	<a href="#" onclick="window.open('../home/cartEmo.html','cart','width=600,height=400').focus()"><font size="8">찜</font></a>
	</div>
    <h1 style="padding: 0px" align="center" onclick="location.href='../home/main.jsp'"><font color="#DDDDDD" size="15">Saito Fuko</font></h1>
</div>


<div class="grid-container">
	
<c:if test="${BODY!=null}">
	<div class="middle" style="background-color:#bbb;">
		
			<jsp:include page="${BODY}"></jsp:include>
		</div>   
	</c:if>
	<c:if test="${BODY==null}">
		<div class="middle">
			<img alt="" src="../cssImage/main2.png" width="100%" height="auto" align="middle">
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