<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
var result="${result}"
	if(result=='noLoginhome'){
		alert("로그인 먼저 해주세요.");
		history.back();
	}
	if(result=='noM'){
		alert("게시글 권한이 없습니다.");
		history.back();
	}
	if(result=='noLogin'){
		alert("로그인 먼저 해주세요.");
		self.close();
	}
	if(result=='entryS'){
		alert("가입이 완료되었습니다.");
		location.replace("../home/main.jsp");
	}
	if(result=='addS'){
		alert("등록이 완료되었습니다.");
		location.replace("../manage/BoardManage.html");
	}
	if(result=='noManager'){
		alert("당신은 관리자가 아닙니다.");
		location.replace("../home/main.jsp");
	}
	if(result=='updateS'){
		alert("게시판 정보가 바뀌었습니다.");
		location.replace("../manage/BoardManage.html");
	}
	if(result=='deleteS'){
		alert("게시판이 삭제되었습니다.");
		location.replace("../manage/BoardManage.html");
	}
	if(result=='postUploadS'){
		alert("게시글이 등록되었습니다.");
		location.replace("../home/main.jsp");
	}
	if(result=='readOnlyManager'){
		alert("매니저만 읽을수 있는 글입니다.");
		location.replace("../post/postList.html");
	}
	if(result=='nologinPost'){
		alert("회원만 읽을수 있는 글입니다.");
		location.replace("../post/postList.html");
	}
	
	if(result=='deletePost'){
		alert("삭제가 완료 되었습니다.");
		location.replace("../post/postList.html");
	}
	
	if(result=='updatePost'){
		alert("수정이 완료되었습니다.");
		location.replace("../post/postList.html");
	}
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>