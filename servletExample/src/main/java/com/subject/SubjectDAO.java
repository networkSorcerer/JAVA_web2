package com.subject;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDAO {
	//getSubjectTotal () 메서드 : 학과 테이블에서 모든 레코드를 반환 메서드.
	//getSubjectTotal (SubjectVO vo ) 메서드 : 검색시 (검색 대상 , 검색어 ) 을 vo로 전달받음
	//@return ArrayList<SubjectVO> 자료형 리턴 
	public ArrayList<SubjectVO> getSubjectTotal(SubjectVO vo ) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO svo = null;
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO> ();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select no, s_num, s_name from subject ");
		sql.append("order by no");
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				svo = new SubjectVO();
				svo.setNo(rs.getInt("no"));
				svo.setS_num(rs.getString("s_num"));
				svo.setS_name(rs.getString("s_name"));
				
				list.add(svo);
			}
		} catch (SQLException se) {
			System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해 주세요 ");
			se.printStackTrace();
		}catch (Exception e) {
			System.out.println("error = [" + e + "]");
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return list;
	}
	
	public String getSubjectNum() {
		StringBuffer sql = new StringBuffer();
		sql.append("select nvl(lpad(max(to_number(LTRIM(s_num,'0')))+1,2,'0'),'01')");
		sql.append("as subjectNum from subject");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String subjectNumber = "";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				subjectNumber = rs.getString("subjectNum");
			}
		}catch (SQLException se) {
			System.out.println("쿼리 getSubjectNum error = [" +se + "]");
			se.printStackTrace();
		}catch (Exception e) {
			System.out.println("error = [" + e + "]");
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return subjectNumber;
	}

}
