package kr.or.kosta.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.kosta.dto.MemberVO;
import kr.or.kosta.dto.customerVO;
import kr.or.kosta.mvc.dao.CustomerDao;
import kr.or.kosta.mvc.dao.memberDao;

/*propagation=Propagation.REQUIRED
 * ������ Ʈ������� �����Ѵٸ� �� Ʈ������� �����ϰ�, ���ٸ� ���ο� Ʈ������� �����Ѵٴ� �ǹ�
 * (propagation=Propagation.REQUIRED,rollbackFor=Exception.class,readOnly=true)
 * noRollbackFor=Exception.class �ش� ���ܰ� �߻����� ���� rollback�� ���� �ʰڴ�.
 * rollbackFor=Exception.class �ش翹�ܰ� �߻����� ���� rollback�� ������.
 * */
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,readOnly=true)
@Service
public class ServiceImple implements ServiceInter{
	@Autowired
	private memberDao memberDao;
	@Autowired
	private CustomerDao customerDao;
	@Override
	public void addAll(MemberVO mvo, customerVO cvo) throws Exception {
		memberDao.addMember(mvo);//������ ��� commit
		customerDao.addCustomer(cvo);		
	}
	@Override
	public int idchk(String id) {
		return memberDao.idChk(id);
	}
	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return memberDao.loginCheck(vo);
	}
	
	
	

}
