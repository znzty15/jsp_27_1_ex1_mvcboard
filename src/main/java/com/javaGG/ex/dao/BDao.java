package com.javaGG.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {
	
	DataSource datasource;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			datasource = (DataSource)context.lookup("java:comp/evn/jbdc/Oracle11g");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void write(String bname, String btitle, String bcontent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into mvc_board(bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent"
				+ "values(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq_currval, 0, 0)";
		
		try {
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			int rn = pstmt.executeUpdate();//내용 저장이 성공하면 1 실패 0
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
