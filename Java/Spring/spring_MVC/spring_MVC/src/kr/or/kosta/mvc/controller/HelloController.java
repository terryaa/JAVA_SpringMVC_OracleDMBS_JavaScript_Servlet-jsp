package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * DispatcherServlet ��û�� �����ϴ� ��
 * RequestMapping => HandlerMapping
 */
@Controller
public class HelloController {
	//ModelAndView, view ��ȯ
	@RequestMapping(value= {"/","/index"})
	public String myHello() {
		return "index";//view�� �̸��� ��ȯ
	}
}
