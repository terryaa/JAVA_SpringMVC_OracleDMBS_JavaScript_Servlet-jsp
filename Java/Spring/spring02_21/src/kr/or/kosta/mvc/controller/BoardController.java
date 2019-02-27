package kr.or.kosta.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.kosta.dto.BoardVO;
import kr.or.kosta.dto.MemberVO;
import kr.or.kosta.mvc.dao.BoardDao;

@Controller
public class BoardController {
	@Autowired
	private BoardDao dao;
	
	@RequestMapping(value="/board")
	public String seeBoard() {
		return "board";
	}
	@RequestMapping("/writeboard")
	public String writeboard(BoardVO bvo) {
		return "writeboard";
	}
	
	@PostMapping("/insertboard")
	public String insertBoard(BoardVO bvo) {
		System.out.println(bvo.getTitle());
		System.out.println(bvo.getContent());
		System.out.println(bvo.getId());
		bvo.setId("test");
		dao.insertBoard(bvo);
		return "success";
	}
	@PostMapping("/showboard")
	public String showboard(Model m, String title){
		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		System.out.println(map);
		List<BoardVO> list = dao.showborad(map);
		System.out.println(list);
		m.addAttribute("list", list);
		return "board";
	}
	
}
