package kr.or.kosta.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.dto.MyMemberVO;

@Repository
public class MemberDao implements MemberDaoInter{
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addMem(MyMemberVO vo) {
		ss.insert("mymember.join",vo);
	}
	@Override
	public int idChk(String id) {
		return ss.selectOne("mymember.idChk",id);
	}
	@Override
	public MyMemberVO loginCheck(MyMemberVO vo) {
		return ss.selectOne("mymember.loginchk",vo);
	}
}
