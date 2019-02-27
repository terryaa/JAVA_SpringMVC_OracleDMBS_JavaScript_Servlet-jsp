package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	
	@RequestMapping(value= {"/index","/"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value= "/idselect")
	public String idselect() {
		return "idselect";
	}
	
	@RequestMapping(value= "/idselectexam")
	public String idselectexam() {
		return "idselectexam";
	}
	@RequestMapping(value= "/jQuerydemo1")
	public String jQuerydemo1() {
		return "jQuerydemo1";
	}
	
	//컨트롤러에 명시하지않고 href를 할수있는방법?
	@RequestMapping(value= "/ex2")
	public String ex2() {
		return "ex2";
	}
	@GetMapping("ex/{path}")
	public String ex1(@PathVariable String path) {
		return path;
	}

}
