package com.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String charset = getInitParameter("charset");
		request.setCharacterEncoding(charset);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'/>");
		out.println("<title>서블릿 초기값 설정으로 인코딩 설정</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body><h3>서블릿 초기값으로 인코딩 설정한 후 결과 출력</h3>");
		out.println("<h4>이름 : " + request.getParameter("name")+"</h4>");
		out.println("</body></html>");
		
		out.close();
	}

}
