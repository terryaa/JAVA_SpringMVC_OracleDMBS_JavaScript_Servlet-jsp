package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import conn.MyConn;
import factory.FactoryService;
import vo.MemberVO;

public class MemberDao2 {
	private static MemberDao2 dao;
	
	private MemberDao2() {
		System.out.println("MemberDao2�� ����!");
	}
	
	public static synchronized MemberDao2 getDao() {
		if(dao == null) dao = new MemberDao2();
		return dao;
	}
	public void addMember(MemberVO vo){
		//insert,update,delete,selectlist,selectone �޼ҵ� ����ϸ�ȴ�.
		SqlSession ss=FactoryService.getFactory().openSession();
		int res=ss.insert("mem.memin",vo);
		ss.commit();
		ss.close();


	}
	
	
	/*selectOne: ��������*/
	
	public int searchId(String id){
		SqlSession ss=FactoryService.getFactory().openSession();
		int res = ss.selectOne("mem.searchid",id);
		return res;
	}
	//selectList : �˻��� ������ ����
	public List<MemberVO> getList(){
		SqlSession ss=FactoryService.getFactory().openSession();
		List<MemberVO> res = ss.selectList("mem.memList");
		ss.close();
		
		return res;
	}

}
