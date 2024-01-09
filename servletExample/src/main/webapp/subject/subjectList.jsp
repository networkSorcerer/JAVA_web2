<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.subject.SubjectVO" %>
<%
	@SuppressWarnings ("unchecked")
	ArrayList<SubjectVO> list = (ArrayList<SubjectVO>)request.getAttribute("list");
	int counter = list.size();
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
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
		 <%-- <script>
			$(function(){
				$("#subjectInsert").on("click", ()=> {
					location.href="<%=request.getContextPath()%>/subject/subjectForm.jsp";
				});
			});
		</script> --%>
		
	</head>
	<body>
		<div id="container" >
			<h3 >테이블 subject 학과 정보 조회</h3>
			<hr/>
			<div id = "subjectsList">
				<!-- <div >
					<input  class="text-end" type="button" value="학과정보등록" id="subjectInsert"/>
				</div> -->
				
				
				<table   table class="table table-striped">
					<thead class="text-center">
						<tr>
							<th>번호</th>
							<th>학과번호</th>
							<th>학과명</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
					<% if (counter > 0) {
						for ( SubjectVO sub : list) {
					%>	
					 	<tr class = "text-center" data-no="<%= sub.getNo() %>">
					 		<td><%= sub.getNo() %></td>
					 		<td><%= sub.getS_num() %></td>
					 		<td><%= sub.getS_name() %></td>
					 		<td><button type="button" class="updateBtn btn btn-outline-success" >수정</button></td>
					 		<td><button type="button" class="deleteBtn btn btn-outline-success" >삭제</button></td>
					 	</tr>
					 <%
						}
					}else {
					 %>
						<tr>
							<td colspan="5" class="text-center">
								조회된 학과 정보가 존재하지 않습니다
							<td>
						</tr>
					<% }  %>
					</tbody>
				</table>
				<div class ="text-sright">
					조회된 학과 수는 <span id ="counter"><%=counter%></span>입니다
				</div>
			</div>
			<jsp:include page ="subjectForm.jsp"/>
		</div>
		<script type="text/javascript" src="/servletExample/js/jquery-3.7.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src = "/servletExample/js/subjectList.js"></script>
	</body>
</html>