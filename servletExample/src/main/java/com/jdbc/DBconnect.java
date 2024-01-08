package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/connect")
public class DBconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'/>");
		out.println("<title>데이터베이스 연동</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("</head><body>");
		out.println("<h3>데이터베이스 드라이버와 Oracle 서버 연결 점검 프로그램 </h3><hr/>");
		Connection con = null;
		
		try {
			String driverName = "oracle.jdbc.driver.OracleDriver";
			String dbURL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			
			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL, "JAVAUSER","JAVA1234");
			
			out.println("Oracle 서버에 성공적으로 접속했습니다");
			out.println("</body></html>");
			con.close();
		}
		catch (Exception e) {
			out.println("Oracle 서버에 접속에 문제가 있습니다. <hr/>");
			out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				out.println(e2.getMessage());
			}
		}
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	

}
