package com.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(
		urlPatterns = {
				"/init1",
				"/init2"
		},
		initParams = {
				@WebInitParam(name = "name" , value ="홍길동"),
				@WebInitParam(name = "email" , value ="adminuser@naver.com"),
				@WebInitParam(name = "tel" , value ="02-5678-9012")
		})
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String name = getInitParameter("name");
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'/>");
		out.println("<title>ServletConfig 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr><th>이름</th><td>" + name +"</td></tr>");
		out.println("<tr><th>이메일</th><td>" + email +"</td></tr>");
		out.println("<tr><th>휴대전화</th><td>" + tel+"</td></tr>");
		out.println("</table></body></html>");
		out.close();
	}

}
