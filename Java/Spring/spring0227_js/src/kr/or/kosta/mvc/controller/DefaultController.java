package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	//��Ʈ�ѷ��� ��������ʰ� href�� �Ҽ��ִ¹��?
	//PathVariable -> �Էµ� Url ������ �����ü�����.
	@GetMapping("/{path}")
	public String ex1(@PathVariable String path) {
		return path;
	}

}
