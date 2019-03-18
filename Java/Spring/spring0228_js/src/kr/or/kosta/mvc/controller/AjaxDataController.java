package kr.or.kosta.mvc.controller;

import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/ex2_load_test")
	public String loadMethod(String cmd,Model model) {
		StringBuffer html=new StringBuffer();
		String[] ar= {"Bigdate1","Bigdate2","Bigdate3"};
		if(cmd.equals("1")) {
			html.append("<table>");
			for(String e:ar) {
				html.append("<tr><td>");
				html.append(e);
				html.append("</td></tr>");
			}
			html.append("</table>");
			model.addAttribute("html",html);
		}
		if(cmd.equals("2")) {
			System.out.println(cmd);
			
			return "ex6";
		}
		return "ex2_load_test";
	}
	
	
	
}
