package kr.or.kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.mvc.dao.JoinLogDao;
import kr.or.kosta.mvc.dao.LoginLogDao;
import kr.or.kosta.mvc.dao.MovieSoldLogDao;
import kr.or.kosta.mvc.dao.ViewLogDao;
import kr.or.kosta.mvc.dao.WatchLogDao;
import kr.or.kosta.mvc.inter.LogDao;

@RestController
@Controller
public class LogController {

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
	private LogDao logDao;
	
	int month=Calendar.getInstance().get(Calendar.MONTH);
	
	@GetMapping("/getLogData1")
	public List<Integer> getLoginLogData(String cmd) {
		
		logDao=loginLogDao;
		List<Integer> result = null;
		result=getLogData(cmd);
		return result;
	}
	@GetMapping("/getLogData2")
	public List<Integer> getMovieSoldLogData(String cmd) {
		logDao=movieSoldLogDao;
		List<Integer> result = null;
		result=getLogData(cmd);
		return result;
	}
	@GetMapping("/getLogData3")
	public List<Integer> getViewLogData(String cmd) {
		logDao=viewLogDao;
		List<Integer> result = null;
		result=getLogData(cmd);
		return result;
	}
	@GetMapping("/getLogData4")
	public List<Integer> getLogData4(String cmd) {
		logDao=joinLogDao;
		List<Integer> result = null;
		result=getLogData(cmd);
		return result;
	}
	@GetMapping("/getLogData5")
	public List<Integer> getJoinLogData(String cmd) {
		logDao=joinLogDao;
		List<Integer> result = null;
		result=getLogData(cmd);
		return result;
	}



	
	
	
	private List<Integer> alignMonths (List<Integer> result) {
		int[] temp=new int[5];
		for(int i=0; i<5 ; i++) {
			if(month+i>4) {
				temp[month+i-5]= result.get(i);
			}
			else
				temp[month+i]=result.get(i);
		}
		result.clear();
		for(int i=0; i<5;i++) {
			result.add(temp[i]);
		}
		return result;
	}
	
	private List<Integer> getLogData(String cmd){
		List<Integer> result = null;
		if(cmd.equals("0")) {
			result=logDao.getLogCount_Days();
		}
		else if(cmd.equals("1")) {
			result=logDao.getLogCount_Months();
			result=alignMonths(result);
		}
		else if(cmd.equals("2")) {
			result=logDao.getLogCount_Years();
		}
		return result;
	}
	
	
	
}
