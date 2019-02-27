package kr.or.kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.kosta.dto.MemberVO;
import kr.or.kosta.dto.customerVO;
import kr.or.kosta.mvc.service.ServiceImple;
import kr.or.kosta.mvc.service.ServiceInter;

@Controller
public class MyMemberController {
	//dao를 주입
	@Autowired
	private ServiceInter serviceInter;
	
	@GetMapping("/member")
	public String mymember() {
		return "member";
	}
	@PostMapping("/memberjoin")
	public String myMemberJoin(MemberVO mvo,customerVO cvo) {
		try {
			serviceInter.addAll(mvo, cvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@GetMapping("/idcheck")
	public String idcheck(Model m,String id) {
		int cnt= serviceInter.idchk(id);
		System.out.println(cnt);
//		String msg = "이미 사용중인 아이디입니다.";
//		if(cnt==0) {
//			msg="사용가능";
//		}
		m.addAttribute("cnt", cnt);
		return "check/idcheck";
	}
	
	@RequestMapping(value="/loginForm")
	public String loginForm() {
		return "loginform";
	}
	
	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(HttpSession session, HttpServletRequest request,MemberVO vo
			) {//,@RequestHeader("User-Agent")String userAgent
		System.out.println("id: "+vo.getId());
		System.out.println("pwd: "+vo.getPassword());
//		System.out.println("UserAgent"+userAgent);
		MemberVO map = serviceInter.loginCheck(vo);
		ModelAndView mav = new ModelAndView();
		if(map == null) {
			mav.setViewName("error");
		}else {
				session.setAttribute("uname", map.getName());
				session.setAttribute("uid", vo.getId());
				mav.setViewName("index");
		}
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView loginfoutProcess(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("uname");
		session.removeAttribute("uid");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@RequestMapping(value="/Mypage")
	public String Mypage() {
		return "Mypage";
	}
}
