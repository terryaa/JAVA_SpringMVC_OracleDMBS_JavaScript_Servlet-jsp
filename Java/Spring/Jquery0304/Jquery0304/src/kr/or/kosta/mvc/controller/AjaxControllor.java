package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AjaxControllor {
	
	@GetMapping("/exam2")
	public String ex1(String cmd, String name,String orderNum,Model m) {
		String status;
		if(cmd.equals("ex3_ajax")) {
			if(name.equals("김길동")&& orderNum.equals("A001")) {
				status="주문하신 물건이 지금 발송중입니다.";
			}else if(name.equals("김길동")&& orderNum.equals("A002")) {
				status="주문하신 물건은 주문생산 완료되었습니다.";
			}else {
				status="이미 발송완료된 상품입니다.";
			}
			m.addAttribute("status",status);
		}
		return cmd;
	}
}
