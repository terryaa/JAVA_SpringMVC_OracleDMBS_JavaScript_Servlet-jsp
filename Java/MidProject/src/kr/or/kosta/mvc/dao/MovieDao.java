package kr.or.kosta.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {
	@Autowired
	private SqlSessionTemplate ss;

	
	public int getMoviePurchaseCount_pastMonth() {
		return ss.selectOne("movie.moviepurchase_pastmonth");
	}

	public int getMoviePurchaseCount_thisMonth() {
		return ss.selectOne("movie.moviepurchase_thismonth");
		
	}
	public int getMovieCopyRightCost_pastMonth() {
		return ss.selectOne("movie.moviecopyrightcost_pastmonth");
	}
	public int getMovieCopyRightCost_thisMonth() {
		return ss.selectOne("movie.moviecopyrightcost_thismonth");
	}
	public int getMovieInvestment_pastMonth() {
		return ss.selectOne("movie.movieinvestment_pastmonth");
	}
	public int getMovieInvestment_thisMonth() {
		return ss.selectOne("movie.movieinvestment_thismonth");
	}
}
