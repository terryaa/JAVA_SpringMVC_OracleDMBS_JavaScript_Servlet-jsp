package kr.or.kosta.mvc.dao;

import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.or.kosta.dto.SawonVO;

@Repository
public class dynamicExampleDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public List<SawonVO> getSawonList(Map<String, String> map){
		List<SawonVO> list = ss.selectList("exam1.iftest1", map);
		return list;
	}
	
	public List<SawonVO> getSawonWhereList(Map<String, String> map){
		List<SawonVO> list = ss.selectList("exam2.iftest1", map);
		return list;
	}
	
	public List<SawonVO> getSawonChooseList(Map<String, String> map){
		List<SawonVO> list = ss.selectList("exam3.choosetest1", map);
		return list;
	}
	
	public List<SawonVO> getForList(Map<String, List<String>> map){
		List<SawonVO> list = ss.selectList("exam3.fortest1", map);
		return list;
	}
	
	//마이바티스를 사용하지 않음
//	private static dynamicExampleDao dao;
//	public static synchronized dynamicExampleDao getDao() {
//		if(dao == null) {
//			dao = new dynamicExampleDao();
//		}
//		return dao;
//	}	
//	public List<SawonVO> getSawonList(Map<String,String> map){
//		SqlSession ss = MyGetFactory.getFactory().openSession();
//		List<SawonVO> list = ss.selectList("exam1.iftest1",map);
//		ss.close();
//		return list;
//	}
}
