package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ex6_Controller {

	@PostMapping("/ex5_data")
	public String getData(String gId,String age,String gname,String addr,String id, String pwd) {
		System.out.println("gid"+gId);
		System.out.println("age"+age);
		System.out.println("gname"+gname);
		System.out.println("addr"+addr);
		System.out.println("id"+id);
		System.out.println("pwd"+pwd);
		
		return "ex6";
	}
}
