package kr.or.kosta.mvc.controller2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParameterDemo {
	@RequestMapping(value="/form")
	public String formParam() {
		return "formMsg";
	}
	@RequestMapping(value="/todayMessage")
	public String todayParam(Model m,String msg) {
		m.addAttribute("msg",msg);
		return "msg";
	}
	@RequestMapping(value="/todayMessage2")
	public String todayParam2(Model m,MyMemberVO2 v) {
		m.addAttribute("vo",v);
		return "msg2";
	}
}
