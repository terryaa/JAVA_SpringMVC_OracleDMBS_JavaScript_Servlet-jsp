package kr.or.kosta.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.dto.DeptVO;
import kr.or.kosta.dto.SawonVO;

@Repository
public class SawonDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public List<DeptVO> getDeptList(){
		return ss.selectList("sawon.showDept");
	}

	public SawonVO getSawonPhone(int sabun) {
		return ss.selectOne("sawon.sawondetail",sabun);
	}
	
	public List<SawonVO> getSawonPhoneList(){
		return ss.selectList("sawon.sawonlist2");
	}
	
	public DeptVO getDeptAllList(int num) {
		return ss.selectOne("sawon.deptList",num);
	}
	
	public DeptVO getDeptphoneAllList(int deptno) {
		return ss.selectOne("sawon.deptphonelist",deptno);
	}
}
