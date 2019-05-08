package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//   ajax/ajaxData1?subject=java
@Controller
@RequestMapping("/ajax")
public class AjaxDataController {
	@GetMapping("/ajaxData1")
	public String ajaxMethod(String subject,Model model) {
		System.out.println(subject);
		model.addAttribute("msg",subject);
		return "ex8_ajaxData";
	}
	@GetMapping("/ajaxData2")
	public String ajaxMethodHolJJack(String number,Model model) {
		String result;
		if(number.equals("¦"))
			result=holjjack(0);
		else
			result=holjjack(1);
		model.addAttribute("msg",result);
		return "ex8_ajaxData";
		
	}
	private String holjjack(int num) {
		if(num ==(int) (Math.random()*2))
			return "win";
		else
			return "lose";
		 
	}
	
	
}
