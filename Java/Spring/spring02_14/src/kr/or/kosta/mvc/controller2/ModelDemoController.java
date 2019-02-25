package kr.or.kosta.mvc.controller2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelDemoController {
	//View�� ���� ���� �ϱ� ���� Model �������̽���
	//���ڷ� ���޹ޱ�
	
	//����ѿ��ҿ� �ٸ����. �ΰ��� �� �ᵵ ������ modelandview��������
	@RequestMapping(value="/momo1")
	public String modeldemo1(Model m) {
		m.addAttribute("msg","Hello~Spring");
		return "modeldemo1";
	}
	@RequestMapping(value="/momo2")
	public ModelAndView modeldemo1() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("modeldemo1");
		mav.addObject("msg","Hello2~Spring");
		return mav;
	}
	
	@RequestMapping(value="/tomsg")
	public String todayMessage(Model m) {
		m.addAttribute("msg","hello!! Today Message!");
		return "today";
	}
	@RequestMapping(value="/today")
	public String todayPrint(Model m) {
		m.addAttribute("msg","hello!! Today Print!");
		return "today";
	}
}
