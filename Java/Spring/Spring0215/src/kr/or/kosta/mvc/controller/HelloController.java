package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class HelloController {
		
		//ModelAndView, View반환
		@RequestMapping(value="/")
		public String myHello() {
			return "index"; // view의 이름을 반환
		}
		
		//ModelAndView, View반환
		@RequestMapping(value="/KOSTA")
		public String myHello2() {
			return "form2"; // view의 이름을 반환
		}

	}

