package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bigdata")
public class PathVariableDemo {
	
	@GetMapping("/{team:team[A-D]+}")
	public String getTeam1(Model m, @PathVariable String team) {
		m.addAttribute("m",team);
		return "teams";
	}
	/*
	 * 룩앤필?
	 * 당신은 teamB입니다.
	 * bigdata/teamB < 이런식으로 보낼 수 있음.
	 * 클래스 자체도  REQUESTMAPPING이 들어옴. 대분류. 
	 * team:team[A-D]+
	 * TEAMA TEAMB TEAMC TEAMD 다 가능함.
	 */
	

}
