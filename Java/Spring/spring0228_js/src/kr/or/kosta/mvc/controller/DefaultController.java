package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	//컨트롤러에 명시하지않고 href를 할수있는방법?
	//PathVariable -> 입력된 Url 정보를 가져올수있음.
	@GetMapping("/{path}")
	public String ex1(@PathVariable String path) {
		return path;
	}

}
