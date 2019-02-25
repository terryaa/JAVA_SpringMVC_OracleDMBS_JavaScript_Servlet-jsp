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
	//@ModelAttribute : 파라미터로 전송된 VO값을 View로 전달하고 싶을 때
	
	public String paramDto(@ModelAttribute(value="mbd") MiniBoardDTO mbd) {
		System.out.println("Test" + mbd.getTitle());
		return "msgDto";
	}
	
//	@PostMapping("/formTest")
//	//@ModelAttribute : 파라미터로 전송된 VO값을 View로 전달하고 싶을 때
//	
//	public String paramDto(@ModelAttribute(value="dto") ExampSawonDTO dto) {
//		System.out.println("Test" + dto.getDeptno());
//		return "msgDto";
//	}
//	
	//모델어트리뷰트가 없으면 -> 
	//모델을 사용해서 값을 넣던지 / 모델 & view를 사용해서 값을 넣음.
	/*
	 * 그런데 그게 필요가 없을 수가 있다.
	 * 그냥 바로 값을 받고 넣을 수가 있다. 
	 * @ModelAttribute (value="dto") => 이게 알아서 msgDto로 간다?
	 */
}
