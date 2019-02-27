package kr.or.kosta.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.dto.MemberVO;


@Repository
public class memberDao {
	@Autowired
	private SqlSessionTemplate ss;
	public void addMember(MemberVO vo) {
		ss.insert("mem.addMember",vo);
	}
	public int idChk(String id) {
		return ss.selectOne("mem.idChk",id);
	}
	public MemberVO loginCheck(MemberVO vo) {
		return ss.selectOne("mem.loginchk",vo);
	}
}
