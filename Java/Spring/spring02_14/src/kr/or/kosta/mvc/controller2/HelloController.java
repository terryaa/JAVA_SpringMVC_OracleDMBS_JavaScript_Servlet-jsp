package kr.or.kosta.mvc.controller2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * DispatcherServlet ��û�� �����ϴ� ��
 * RequestMapping => HandlerMapping
 */
@Controller
public class HelloController {
	//ModelView,View��ȯ
	@RequestMapping(value="/")
	public String myHello() {
		return "index"; //view�� �̸��� ��ȯ
	}
	
	
}
