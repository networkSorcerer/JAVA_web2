<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.member.MemberDTO" %>
<%
	MemberDTO dto = (MemberDTO) session.getAttribute("login");
%>
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
		<div class = "container">
			<% if(dto != null) { %>
			<div>
				<table>
					<tr>
						<th colspan="2">세션에 저장된 정보 얻기 </th>
					</tr>
					<tr>
						<td>아이디</td>
						<td><%=dto.getMemberId() %></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><%= dto.getMemberName() %></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><%=dto.getMemberEmail() %></td>
					</tr>
				</table>
			
			</div>
			<div>
				<a href='/servletExample/loginOut'>로그아웃</a>
			</div>		
			<%} else {%>
			<div>
				로그인 상태가 아닙니다 <br/> 로그인부터 다시 진행해 주세요
			</div>
		</div>
		<div>
			<a href = '/servletExample/jdbc/login.jsp'>로그인 화면으로 이동하기</a>
		</div>
		<% } %>
	</body>
</html>