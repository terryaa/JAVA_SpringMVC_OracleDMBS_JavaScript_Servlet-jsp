package kr.or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AjaxControllor {
	
	@GetMapping("/exam2")
	public String ex1(String cmd, String name,String orderNum,Model m) {
		String status;
		if(cmd.equals("ex3_ajax")) {
			if(name.equals("��浿")&& orderNum.equals("A001")) {
				status="�ֹ��Ͻ� ������ ���� �߼����Դϴ�.";
			}else if(name.equals("��浿")&& orderNum.equals("A002")) {
				status="�ֹ��Ͻ� ������ �ֹ����� �Ϸ�Ǿ����ϴ�.";
			}else {
				status="�̹� �߼ۿϷ�� ��ǰ�Դϴ�.";
			}
			m.addAttribute("status",status);
		}
		return cmd;
	}
}
