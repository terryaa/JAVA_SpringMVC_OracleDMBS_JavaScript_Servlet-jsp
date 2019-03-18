package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
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
}
