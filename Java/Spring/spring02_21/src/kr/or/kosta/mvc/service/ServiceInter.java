package kr.or.kosta.mvc.service;

import kr.or.kosta.dto.MemberVO;
import kr.or.kosta.dto.customerVO;

public interface ServiceInter {
	//transaction�� ó���ϱ� ���� �߻�޼���
	public void addAll(MemberVO mvo,customerVO cvo) throws Exception;
	public int idchk(String id);
	public MemberVO loginCheck(MemberVO vo);
}