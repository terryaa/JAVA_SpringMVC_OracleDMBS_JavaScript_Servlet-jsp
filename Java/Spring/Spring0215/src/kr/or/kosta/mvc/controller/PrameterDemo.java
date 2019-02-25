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
	//Param1?code=A 로 입력될 때만 들어갈 수 있다.
	//C를 넣으면 다른 구역의 파라미터를 처리합니다. -> 연습문제?
	
	
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
	
	
	
	
	//요청 파라미터가 test가 아닌 것만
	
	@RequestMapping(value="/param2", params="mycode!=test")
	public ModelAndView paramDemo3(String mycode) {
		ModelAndView m = new ModelAndView();
		m.setViewName("msg");
		m.addObject("msg",mycode);
		return m;
	}
	
	
	
	
	//자동으로 형변환
	@GetMapping("/intDemo") //http://localhost/spring0215/intDemo?num=100
	public String paramInt(Model m, int num) {
		int res = num + 100;
		m.addAttribute("msg",res);
		return "msg";
	}
	
	/*
	 * @RequestParam(value="id", required=false, defaultValue="ww")
	 * @RequestParam(value="id", required=false, defaultValue="test")
	 * @RequestParam(value="id") 파라미터 값을 지정할 수 있는 기능
	 * 기본값은 rquired=true이기 때문에 파라미터가 없을 경우
	 * MissingServletRequestParameterException을 발생한다.
	 * required=false인 경우 파라미터값에 대한 예외를 발생하지 않는다.
	 * defaultValue="" 파라미터 값이 없을 때 기본값으로 설정
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
	//pathvariable은 반드시 기억
	//error2.jsp에서 에러메시지를 출력하시오.
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
