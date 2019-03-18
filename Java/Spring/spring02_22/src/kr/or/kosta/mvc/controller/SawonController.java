package kr.or.kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.kosta.dto.DeptVO;
import kr.or.kosta.dto.SawonVO;
import kr.or.kosta.mvc.dao.SawonDao;

@Controller
public class SawonController {
	@Autowired
	private SawonDao sdao;
	
	@GetMapping("/deptlist")
	public String deptList(Model m) {
		List<DeptVO> list = sdao.getDeptList();
		m.addAttribute("dlist",list);
		return "deptlist";
	}
	//--------------------------------------------
	@GetMapping("/sphoneForm")
	public String sawonphoneForm() {
		return "sphForm";
	}
	//--------------------------------------------
	@PostMapping("/sPhone")
	public String sawonPhone(int sabun,Model m) {
		SawonVO svo= sdao.getSawonPhone(sabun);
		m.addAttribute("sawon",svo);
		return "sawonPhone";
	}
	@GetMapping("/sPhonelist")
	public String sawonPhone2(Model m) {
		List<SawonVO> list = sdao.getSawonPhoneList();
		m.addAttribute("splist",list);
		return "sawonPhoneList";
	}
	//--------------------------------------------
	@GetMapping("/deptchForm")
	public String deptChooseFrom() {
		return "deptchooseForm";
	}	
	@PostMapping("/deptalllist")
	public ModelAndView deptAllList(int deptno) {
		ModelAndView mav = new ModelAndView("deptalllist");
		DeptVO list = sdao.getDeptAllList(deptno);
		mav.addObject("dlist",list);
		return mav;
	}
	//--------------------------------------------
	@GetMapping("/deptphonechForm")
	public String deptphoneChooseFrom() {
		return "deptphoneChooseFrom";
	}	
	@PostMapping("/deptphonealllist")
	public ModelAndView deptphoneAllList(int deptno) {
		ModelAndView mav = new ModelAndView("deptphonealllist");
		DeptVO list = sdao.getDeptphoneAllList(deptno);
		mav.addObject("dlist1",list);
		return mav;
	}
	//--------------------------------------------
}
