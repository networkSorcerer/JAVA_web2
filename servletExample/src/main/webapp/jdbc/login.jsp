<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<!-- 브라우저의 호환성 보기 모드를 막고, 해당 브라우저에서 지원하는 가장 최신 버전의 방식으로 HTML 보여주도록 설정.-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		
		<title>Insert title here</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
	</head>
	<body>
		<form id ="login">
			<fieldset>
				<div>
					<label for = "memberId">아이디</label>
					<input type = "text" name = "memberId" id="memberId" />
				</div>
				<div>
					<label for="memberPasswd">비밀번호</label>
					<input type="password" name="memberPasswd" id="memberPasswd"/>
				</div>
				<div>
					<button type="button" id="loginBtn">로그인</button>
				</div>
			</fieldset>
		</form>
		<script type="text/javascript" src="/servletExample/js/jquery-3.7.1.min.js"></script>
		<script src="/servletExample/js/common.js"></script>
		<script src ="/servletExample/js/login.js"></script>
	</body>
</html>