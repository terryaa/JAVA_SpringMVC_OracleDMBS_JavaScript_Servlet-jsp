package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	//��Ʈ�ѷ��� ��������ʰ� href�� �Ҽ��ִ¹��?
	//PathVariable -> �Էµ� Url ������ �����ü�����.
	@RequestMapping(value= "/ex2")
	public String ex2() {
		return "ex2";
	}
	@GetMapping("/{path}")
	public String ex1(@PathVariable String path) {
		return path;
	}

}
