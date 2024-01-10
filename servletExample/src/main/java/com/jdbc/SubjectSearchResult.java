package com.jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.SubjectDAO;
import com.subject.SubjectVO;

@WebServlet("/searchResult")
public class SubjectSearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubjectVO vo = new SubjectVO();
		int no = Integer.parseInt(request.getParameter("no"));
		vo.setNo(no);
		
		SubjectDAO dao = new SubjectDAO();
		SubjectVO svo = dao.subjectSearch(vo);
		
		String path = "";
		
		if (svo != null) {
			request.setAttribute("svo", svo);
			path = "subject/subjectSearchSuccess.jsp";
		}else {
			request.setAttribute("message", "조회 결과가 없습니다");
			path = "subject/subjectFail.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
    
	

}
