package kr.or.kosta.mvc.controller2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * DispatcherServlet 요청에 응답하는 모델
 * RequestMapping => HandlerMapping
 */
@Controller
public class HelloController {
	//ModelView,View반환
	@RequestMapping(value="/")
	public String myHello() {
		return "index"; //view의 이름을 반환
	}
	
	
}
