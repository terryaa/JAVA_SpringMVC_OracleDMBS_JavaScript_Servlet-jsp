package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.MyConn;
import vo.MemberVO;

public class MemberDao {
	private static MemberDao dao;
	public static synchronized MemberDao getDao() {
		if(dao == null) dao = new MemberDao();
		return dao;
	}
	public void addMember(MemberVO vo){
		    Connection con = null;
	        PreparedStatement pstmt = null;
	        try {
	            con = MyConn.getDs();
	            String sql = "insert into member values(member_seq.nextVal,?,?,?,?,?,sysdate)";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, vo.getId());
	            pstmt.setString(2, vo.getPwd());
	            pstmt.setString(3, vo.getName());
	            pstmt.setString(4, vo.getEmail());
	            pstmt.setString(5, vo.getTel());
	            int res = pstmt.executeUpdate();
	            System.out.println("Res :"+res);
	        }catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally{
				try {
					 if(con != null) con.close();
					 if(pstmt !=null) pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        }	
		/*
		 * insert into member values(member_seq.nextVal,
  		#{id},#{pwd},#{name},#{email},#{tel},sysdate
  		)
		 * */
	}
	
	
	
	
	public int searchId(String id){
		int res = 0;
		return res;
	}
	public List<MemberVO> getList(){
		List<MemberVO> res = new ArrayList<MemberVO>();
		return res;
	}

}
