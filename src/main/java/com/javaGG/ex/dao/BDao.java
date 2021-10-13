package com.javaGG.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javaGG.ex.dto.BDto;

public class BDao {
	
	DataSource datasource;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			datasource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
public void write(String bname, String btitle, String bcontent) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		String query = "insert into mvc_board (bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) "
				+ "values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
		
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(query);
			
			psmt.setString(1, bname);
			psmt.setString(2, btitle);
			psmt.setString(3, bcontent);
			
			int rn = psmt.executeUpdate();//글 내용 저장이 성공하면 rn=1
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(psmt !=null) psmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<BDto> list() {
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		
//		BDto dto = new BDto();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String query = "select * from mvc_board order by bgroup desc, bstep asc";//id순으로 내림차순 정렬
		
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				BDto dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
	            dtos.add(dto);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtos;		
	}
	
	public BDto contentView(String sid) {	
		
		BDto dto = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String query = "select * from mvc_board where bid = ?";
		
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(sid));
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public void modify(String bid, String bname, String btitle, String bcontent) {
	      // TODO Auto-generated method stub
	      Connection conn = null; //conn
	      PreparedStatement psmt = null; // psmt로 간단하게 사용하기도 함
	      
	      try {
	         conn = datasource.getConnection();
	         String Query = "update mvc_board set bname = ?, btitle = ?, bcontent=? where bid = ?";
	         psmt = conn.prepareStatement(Query);
	         
	         psmt.setString(1, bname);
	         psmt.setString(2, btitle);
	         psmt.setString(3, bcontent);
	         psmt.setInt(4, Integer.parseInt(bid));
	         
	         int rn = psmt.executeUpdate();
	         
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         try {
	        	 if(psmt !=null) psmt.close();
	        	 if(conn != null) conn.close();
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	      
	}

	public void delete(String bid) {
		// TODO Auto-generated method stub
		Connection conn = null; //conn
		PreparedStatement psmt = null; // psmt로 간단하게 사용하기도 함
	      
	    try {
	       conn = datasource.getConnection();
	       String Query = "delete from mvc_board where bid = ?";
	       psmt = conn.prepareStatement(Query);
	       
	       psmt.setInt(1, Integer.parseInt(bid));
	       
	       int rn = psmt.executeUpdate();
	       
	    } catch (Exception e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	    } finally {
	    	try {
	    		if(psmt !=null) psmt.close();
	    		if(conn != null) conn.close();
	    	} catch (SQLException e) {
	    		// TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	}
	
}




