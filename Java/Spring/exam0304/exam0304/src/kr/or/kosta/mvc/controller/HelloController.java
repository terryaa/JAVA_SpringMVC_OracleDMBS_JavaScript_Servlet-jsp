package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * DispatcherServlet 요청에 응답하는 모델
 * RequestMapping => HandlerMapping
 */
@Controller
public class HelloController {
	//ModelAndView, view 반환
	@RequestMapping(value= {"/","/index"})
	public String myHello() {
		return "index";//view의 이름을 반환
	}
	
	@GetMapping("/traffic.load")
	public String mapping1(String idx, Model m) {
		m.addAttribute("idx", idx);
		return "traffic";
	}
	
	@GetMapping("/{path}")
	public String mapping(@PathVariable String path) {
		return path;
	}
	
	
	
}
