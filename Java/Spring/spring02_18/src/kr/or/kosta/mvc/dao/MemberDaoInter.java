package kr.or.kosta.mvc.dao;

import kr.or.kosta.dto.MyMemberVO;

public interface MemberDaoInter {
	public void addMem(MyMemberVO vo);
	public int idChk(String id);
	public MyMemberVO loginCheck(MyMemberVO vo);
}
