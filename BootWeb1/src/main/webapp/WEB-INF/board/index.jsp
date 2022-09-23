<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this is main page</title>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/static/style.css">
</head>
<body>
	<div id="container">
		<h2>메인페이지입니다.</h2>
	</div>
	<a href="/getBoardList">게시판 바로가기 |</a>
	<a href="/hello">hello 바로가기</a>
	<div class="main_img_container">
		<img src="/static/bg2.jpg" class="main_img" id="pic">	
	</div>	
	
<script type="text/javascript">
let picture = ["/static/bg2.jpg", "/static/bg55.jpg", "/static/cat.jpg"];
let idx = 0;

slideShow();

function slideShow(){
	document.getElementById("pic").src = picture[idx];
	idx++;
	if(idx == picture.length)
		idx = 0;
	
	//setTimeout(slideShow, 3000);
}

</script>
</body>
</html>