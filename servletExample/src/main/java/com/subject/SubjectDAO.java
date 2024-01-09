package com.subject;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDAO {
	//학과번호는 수정할수 없다
	
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
	
	public boolean subjectInsert(SubjectVO svo) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into subject(no, s_num, s_name) ");
		sql.append("values(subject_seq.nextval, ?, ?)");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		try { 
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,  svo.getS_num());
			pstmt.setString(2,  svo.getS_name());
			
			int i = pstmt.executeUpdate();
			if(i == 1) {
				success = true;
			}
		}catch (SQLException se) {
			System.out.println("입력에 문제가 있어 잠시후에 다시 진행해 주세요");
		}catch (Exception e) {
			System.out.println("error = [" + e+ " ]");
		}finally {
			close(pstmt);
			close(con);
		}
		return success;
	}
	
	public boolean subjectUpdate(SubjectVO svo) {
		StringBuffer sql = new StringBuffer();
		sql.append("update subject set s_name = ? ");
		sql.append("where no = ?");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean  success = false;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, svo.getS_name());
			pstmt.setInt(2,  svo.getNo());
			
			int i = pstmt.executeUpdate();
			if(i==1) {
				success = true;
			}
			
		}catch (SQLException se) {
			System.out.println("수정에 문제가 있어 잠시후에 다시 진행해 주세요 ");
		}catch (Exception e) {
			System.out.println("error= [ " + e+ " ]");
		}finally {
			close(pstmt);
			close(con);
		}
		return success;
	}
	
	public boolean subjectDelete(SubjectVO svo) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from subject where no = ?");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try {
			con = getConnection();
			
			pstmt = con.prepareStatement(sql.toString ());
			pstmt.setInt(1,  svo.getNo());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) {
				success = true;
			}
		}catch (SQLException se) {
			System.out.println("삭제에 문제가 있어 잠시후에 다시 진행해 주세요 ");
		}catch (Exception e) {
			System.out.println("error = [" + e + " ]");
		}finally {
			close(pstmt);
			close(con);
		}
		
		return success;	
	}
	
	public int studentDataCheck(SubjectVO svo) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(sd_num) from student " );
		sql.append("where s_num = ? ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int data = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, svo.getS_num ());
			rs = pstmt.executeQuery();
			if( rs.next()) {
				data = rs.getInt(1);
			}
		}catch (SQLException se) {
			System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해 주세요");
		}catch (Exception e) {
			System.out.println("error = [" + e + "]");
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return data;
	}
}
