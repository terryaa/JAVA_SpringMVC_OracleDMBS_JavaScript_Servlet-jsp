package kr.or.kosta.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.dto.BoardVO;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public void insertBoard(BoardVO bvo) {
		ss.insert("boarder.boain",bvo);
	}
	
	public List<BoardVO> showborad(Map<String, String> map){
		List<BoardVO> list = ss.selectList("boarder.iftest1",map);
		return list;
	}
}
