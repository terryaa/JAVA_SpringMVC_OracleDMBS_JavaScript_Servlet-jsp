package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.kosta.dto.ExampSawonDTO;
import kr.or.kosta.dto.MiniBoardDTO;

@Controller
public class ModelAttrDemo {
	
	@GetMapping("/modelForm")
	public String form() {
		return "form2";
	}
	
	@PostMapping("/formTest")
	//@ModelAttribute : �Ķ���ͷ� ���۵� VO���� View�� �����ϰ� ���� ��
	
	public String paramDto(@ModelAttribute(value="mbd") MiniBoardDTO mbd) {
		System.out.println("Test" + mbd.getTitle());
		return "msgDto";
	}
	
//	@PostMapping("/formTest")
//	//@ModelAttribute : �Ķ���ͷ� ���۵� VO���� View�� �����ϰ� ���� ��
//	
//	public String paramDto(@ModelAttribute(value="dto") ExampSawonDTO dto) {
//		System.out.println("Test" + dto.getDeptno());
//		return "msgDto";
//	}
//	
	//�𵨾�Ʈ����Ʈ�� ������ -> 
	//���� ����ؼ� ���� �ִ��� / �� & view�� ����ؼ� ���� ����.
	/*
	 * �׷��� �װ� �ʿ䰡 ���� ���� �ִ�.
	 * �׳� �ٷ� ���� �ް� ���� ���� �ִ�. 
	 * @ModelAttribute (value="dto") => �̰� �˾Ƽ� msgDto�� ����?
	 */
}
