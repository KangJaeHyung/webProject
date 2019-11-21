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
<title>종료하지 말고 잠시만 기다려주세요.</title>
<style type="text/css">
.loading{
position:absolute;
top:50%;
left:50%;
transform: translateX(-50%) translateY(-50%);
} 
</style>
</head>
<body>
잠시만 기다려주세요.
<script type="text/javascript">
	var imageName="${picture}";
	var context="${pageContext.request.contextPath}"
		function fileExists(url) {
			 var httpRequest = new XMLHttpRequest();
			 httpRequest.open('GET', url, false);
			 httpRequest.send();
		    if(httpRequest.readyState == 1 || httpRequest.readyState == 2 || httpRequest.readyState ==3){
		    	}else if(httpRequest.readyState == 4){
		    		if(httpRequest.status == 200){
		    			opener.document.getElementById("text").focus();
		    			opener.document.execCommand('insertImage',false,url);
		    			document.images.id='contentImg';
		    			self.close();
		    		}else{
		    			setTimeout(fileExists(context+'/img/'+imageName),500);
		    		} 
		   		}
		}
	fileExists(context+'/img/'+imageName);
</script>
</body>
</html>