package kr.or.kosta.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.mvc.inter.LogDao;

@Repository
public class MovieSoldLogDao implements LogDao {
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public int getLogCount_All() {
		// TODO Auto-generated method stub
		return ss.selectOne("moviesoldlog.moviesoldlogcount_all");
	}
	@Override
	public int getLogCount_CurrentDate() {
		// TODO Auto-generated method stub
		return ss.selectOne("moviesoldlog.moviesoldlogcount_currentdate");
	}
	@Override
	public List<Integer> getLogCount_Days() {
		// TODO Auto-generated method stub
		return ss.selectList("moviesoldlog.moviesoldlogcount_days");
	}
	@Override
	public List<Integer> getLogCount_Months() {
		// TODO Auto-generated method stub
		return ss.selectList("moviesoldlog.moviesoldlogcount_months");
	}
	@Override
	public List<Integer> getLogCount_Years() {
		// TODO Auto-generated method stub
		return ss.selectList("moviesoldlog.moviesoldlogcount_years");
	}
}
