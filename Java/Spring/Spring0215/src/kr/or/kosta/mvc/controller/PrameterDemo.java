package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrameterDemo {
	
	
	@RequestMapping(value="/param1", params="code=A")
	public ModelAndView paramDemo1(String code) {
		ModelAndView m = new ModelAndView();
		m.setViewName("msg");
		m.addObject("msg",code);
		return m;
	}
	//Param1?code=A �� �Էµ� ���� �� �� �ִ�.
	//C�� ������ �ٸ� ������ �Ķ���͸� ó���մϴ�. -> ��������?
	
	
	@RequestMapping(value="/param1",params="code=B")
	public ModelAndView paramDemo2(String code) {
		ModelAndView m = new ModelAndView();
		m.setViewName("msg");
		m.addObject("msg",code);
		return m;
	}
	
	
	//kr.or.kosta.mvc.controller.*.nonparam*(..)
	@RequestMapping(value="/param1")
	public ModelAndView noparamDemo3(String code) {
		ModelAndView m = new ModelAndView();
		m.setViewName("msg");
		m.addObject("msg",code);
		return m;
	}
	
	
	
	
	//��û �Ķ���Ͱ� test�� �ƴ� �͸�
	
	@RequestMapping(value="/param2", params="mycode!=test")
	public ModelAndView paramDemo3(String mycode) {
		ModelAndView m = new ModelAndView();
		m.setViewName("msg");
		m.addObject("msg",mycode);
		return m;
	}
	
	
	
	
	//�ڵ����� ����ȯ
	@GetMapping("/intDemo") //http://localhost/spring0215/intDemo?num=100
	public String paramInt(Model m, int num) {
		int res = num + 100;
		m.addAttribute("msg",res);
		return "msg";
	}
	
	/*
	 * @RequestParam(value="id", required=false, defaultValue="ww")
	 * @RequestParam(value="id", required=false, defaultValue="test")
	 * @RequestParam(value="id") �Ķ���� ���� ������ �� �ִ� ���
	 * �⺻���� rquired=true�̱� ������ �Ķ���Ͱ� ���� ���
	 * MissingServletRequestParameterException�� �߻��Ѵ�.
	 * required=false�� ��� �Ķ���Ͱ��� ���� ���ܸ� �߻����� �ʴ´�.
	 * defaultValue="" �Ķ���� ���� ���� �� �⺻������ ����
	 */
	@RequestMapping(value="/param3")
	public ModelAndView paramDemo5(@RequestParam(
			value="id", required=true,
	defaultValue="defaultTest")String code) {
		ModelAndView m = new ModelAndView();
		m.setViewName("msg");
		m.addObject("msg",code);
		return m;
	}
	//pathvariable�� �ݵ�� ���
	//error2.jsp���� �����޽����� ����Ͻÿ�.
	@GetMapping("/exceptionDemo")
	public String exceptionDemo() {
		String[] list = {"test","test1","test2"};
		String res="";
		for(int i=0; i<list.length; i++) {
			res=list[i];
		}
		return "msg";
	}
	
	
	
	
	
	
}
