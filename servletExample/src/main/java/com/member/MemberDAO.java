package com.member;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
	public MemberDTO login (MemberDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO memberDTO = null;
		try{
			con = getConnection();
			StringBuffer query = new StringBuffer();
			query.append("select m_id, m_name, m_email from t_member ");
			query.append("where m_id = ? and m_passwd = ? ");
			
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPasswd());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setMemberId(rs.getString("m_id"));
				memberDTO.setMemberName(rs.getString("m_name"));
				memberDTO.setMemberEmail(rs.getString("m_email"));
			}		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
			close(con);
		}
		return memberDTO;
	}	
}
