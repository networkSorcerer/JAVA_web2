package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.MemberDAO;
import com.member.MemberDTO;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		String memberId = request.getParameter("memberId");
		String memberPasswd = request.getParameter("memberPasswd");
		
		HttpSession session = request.getSession();
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberId(memberId);
		dto.setMemberPasswd(memberPasswd);
		
		
		MemberDAO dao = new MemberDAO();
		MemberDTO memberDTO = dao.login(dto);
		
		StringBuffer message = new StringBuffer();
		
		if(memberDTO != null) {
			session.setAttribute("login", memberDTO);
			
			message.append("<div><a href ='/servletExample/loginInfo)>로그인 정보 확인 하기 </a></div>");
		} else {
			message.append("<div>아이디 또는 비밀번호가 일치하지 않습니다 </div>");
			message.append("<div><a href = '*' onclick='history.back()'>이전 화면으로</div>");
		}
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' />");
		out.println("<title>Cookie 예제</title>");
		out.println("<link rel = 'icon' href = 'data:,'></head>");
		out.println("<body>");
		
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		if(mDTO != null) {
			out.print(mDTO.getMemberName() + "님 반갑습니다");
		}
		
		out.print(message.toString());
		out.println("</body></html>");
		out.close();
		
	}

}
