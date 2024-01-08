package com.context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetServletContext
 */
@WebServlet("/setContext")
public class SetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * response.setContentType("text/html;charset=utf-8"); PrintWriter out =
	 * response.getWriter();
	 * 
	 * ServletContext context = getServletContext();
	 * 
	 * List<String> member = new ArrayList<String>(); member.add("홍길동");
	 * member.add("한늘봄"); member.add("김영희"); context.setAttribute("member",member);
	 * 
	 * out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'/>");
	 * out.println("<title>ServletContext 예제</title>");
	 * out.println("<link rel='icon' href='data:,'>");
	 * out.println("<body><div>ServletContext 속성 설정 </div>");
	 * out.println("</head><body>"); }
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext context = getServletContext();
		
		List<String> member = new ArrayList<String>(); 
		member.add("홍길동");
		member.add("한늘봄");
		member.add("김영희"); 
		
		context.setAttribute("member",member);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index.jsp");
		dispatcher.forward(request, response);
		
	}
}
