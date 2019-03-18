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

import kr.or.kosta.dto.MyMemberVO;
import kr.or.kosta.mvc.dao.MemberDaoInter;

@Controller
public class MyMemberController {
	//dao를 주입
	@Autowired
	private MemberDaoInter memberDaoInter;
	
	@GetMapping("/member")
	public String mymember() {
		return "member";
	}
	
	@GetMapping("/imgview")
	public String imgview() {
		return "imgview";
	}
	
	@PostMapping("/memberjoin")
	public String myMemberJoin(Model m, MyMemberVO vo) {
		System.out.println(vo.getId());
		System.out.println(vo.getPwd());
		System.out.println(vo.getName());
		System.out.println(vo.getPost());
		System.out.println(vo.getAddr1());
		System.out.println(vo.getAddr2());
		System.out.println(vo.getTel());
		memberDaoInter.addMem(vo);
		return "success";
	}
	
	@GetMapping("/idcheck")
	public String idcheck(Model m,String id) {
		int cnt= memberDaoInter.idChk(id);
		System.out.println(cnt);
		String msg = "이미 사용중인 아이디입니다.";
		if(cnt==0) {
			msg="사용가능";
		}
		m.addAttribute("cnt", cnt);
		return "idcheck";
	}
	
	@RequestMapping(value="/loginForm")
	public String loginForm() {
		return "loginform";
	}
	
	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(HttpSession session, HttpServletRequest request,MyMemberVO vo,
			@RequestHeader("User-Agent")String userAgent) {
		System.out.println("id"+vo.getId());
		System.out.println("pwd"+vo.getPwd());
		System.out.println("UserAgent"+userAgent);
		MyMemberVO map = memberDaoInter.loginCheck(vo);
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
	
	
}
