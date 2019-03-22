package kr.or.kosta.mvc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.mvc.dao.MovieDao;

@RestController
@Controller
public class MovieController {

	@Autowired
	private MovieDao movieDao;
	
	@GetMapping("/getMovieStatistic")
	public HashMap<String,Integer> getMovieStatistic() {
		HashMap<String,Integer> statistic=new HashMap<>();
		statistic.put("purchase_thismonth", movieDao.getMoviePurchaseCount_thisMonth());
		statistic.put("purchase_pastmonth", movieDao.getMoviePurchaseCount_pastMonth());
		statistic.put("copyrightcost_thismonth", movieDao.getMovieCopyRightCost_thisMonth());
		statistic.put("copyrightcost_pastmonth", movieDao.getMovieCopyRightCost_pastMonth());
		statistic.put("investment_thismonth", movieDao.getMovieInvestment_thisMonth());
		statistic.put("investment_pastmonth", movieDao.getMovieInvestment_pastMonth());
		return statistic;
	}
}
