package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class HelloController {
		
		//ModelAndView, View��ȯ
		@RequestMapping(value="/")
		public String myHello() {
			return "index"; // view�� �̸��� ��ȯ
		}
		
		//ModelAndView, View��ȯ
		@RequestMapping(value="/KOSTA")
		public String myHello2() {
			return "form2"; // view�� �̸��� ��ȯ
		}

	}

