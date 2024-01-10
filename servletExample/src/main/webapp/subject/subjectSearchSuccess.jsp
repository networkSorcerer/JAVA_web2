<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.subject.SubjectVO" %>
<%
	SubjectVO vo = (SubjectVO)request.getAttribute("svo");
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
		<div id="container">
			<h3>학과 정보</h3>
			<hr/>
			<div id="subjectList">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>학과번호</th>
							<th>학과명</th>
						</tr>
					</thead>
					<tbody>
						<tr class = "text-center">
							<td><%= vo.getNo() %></td>
							<td><%= vo.getS_num() %></td>
							<td><%= vo.getS_name() %></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div>
				<a href="/servletExample/search">메인 페이지로 이동</a>
			</div>
		</div>
	</body>
</html>