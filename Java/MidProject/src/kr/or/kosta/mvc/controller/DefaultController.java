package kr.or.kosta.mvc.controller;


import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.kosta.mvc.dao.JoinLogDao;
import kr.or.kosta.mvc.dao.LoginLogDao;
import kr.or.kosta.mvc.dao.MovieDao;
import kr.or.kosta.mvc.dao.MovieSoldLogDao;
import kr.or.kosta.mvc.dao.ViewLogDao;
import kr.or.kosta.mvc.dao.WatchLogDao;
import kr.or.kosta.mvc.inter.LogDao;



/*
 * DispatcherServlet 요청에 응답하는 모델
 * RequestMapping => HandlerMapping
 * 
 * */
@Controller
public class DefaultController {

	@Autowired
	private WatchLogDao watchLogDao;
	@Autowired
	private ViewLogDao viewLogDao;
	@Autowired
	private MovieSoldLogDao movieSoldLogDao;
	@Autowired
	private LoginLogDao loginLogDao;
	@Autowired
	private JoinLogDao joinLogDao;
	@Autowired
	private MovieDao movieDao;
	private LogDao logDao;
	
	@RequestMapping("/")
	public String index(Model m) {
		DecimalFormat df=new DecimalFormat("#,###");
		int watchlogcount_all=watchLogDao.getLogCount_All();
		int watchlogcount_currentdate=watchLogDao.getLogCount_CurrentDate();
		
		int viewlogcount_all=viewLogDao.getLogCount_All();
		int viewlogcount_currentdate=viewLogDao.getLogCount_CurrentDate();
		
		int moviesoldLogcount_all=movieSoldLogDao.getLogCount_All();
		int moviesoldLogcount_currentdate=movieSoldLogDao.getLogCount_CurrentDate();
		
		int loginLogcount_all=loginLogDao.getLogCount_All();
		int loginLogcount_currentdate=loginLogDao.getLogCount_CurrentDate();
		
		int joinLogcount_all=joinLogDao.getLogCount_All();
		int joinLogcount_currentdate=joinLogDao.getLogCount_CurrentDate();
		
		int purchase_pastmonth=movieDao.getMoviePurchaseCount_pastMonth();
		int purchase_thismonth=movieDao.getMoviePurchaseCount_thisMonth();
		
		int copyrightcost_pastmonth=movieDao.getMovieCopyRightCost_pastMonth();
		int copyrightcost_thismonth=movieDao.getMovieCopyRightCost_thisMonth();
		
		int investment_pastmonth=movieDao.getMovieInvestment_pastMonth();
		int investment_thismonth=movieDao.getMovieInvestment_thisMonth();
		
		m.addAttribute("watchlogcount_all",df.format(watchlogcount_all));
		m.addAttribute("watchlogcount_currentdate",df.format(watchlogcount_currentdate));
		
		m.addAttribute("viewlogcount_all",df.format(viewlogcount_all));
		m.addAttribute("viewlogcount_currentdate",df.format(viewlogcount_currentdate));
		
		m.addAttribute("moviesoldlogcount_all",df.format(moviesoldLogcount_all));
		m.addAttribute("moviesoldlogcount_currentdate",df.format(moviesoldLogcount_currentdate));
		m.addAttribute("loginlogcount_all",df.format(loginLogcount_all));
		m.addAttribute("loginlogcount_currentdate",df.format(loginLogcount_currentdate));
		
		m.addAttribute("joinlogcount_all",df.format(joinLogcount_all));
		m.addAttribute("joinlogcount_currentdate",df.format(joinLogcount_currentdate));
		
		m.addAttribute("purchase_pastmonth",df.format(purchase_pastmonth));
		m.addAttribute("purchase_thismonth",df.format(purchase_thismonth));
		
		m.addAttribute("copyrightcost_pastmonth",df.format(copyrightcost_pastmonth));
		m.addAttribute("copyrightcost_thismonth",df.format(copyrightcost_thismonth));
		
		m.addAttribute("investment_pastmonth",df.format(investment_pastmonth));
		m.addAttribute("investment_thismonth",df.format(investment_thismonth));
		
		return "index";
	}

	
	@GetMapping("/{path}")
	public String ex1(@PathVariable String path) {
		return path;
	}

	

	
	
	
	
	
}