package kr.or.kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.kosta.dto.SawonVO;
import kr.or.kosta.mvc.dao.dynamicExampleDao;
@Controller
public class DynamicQueryController {
	@Autowired
	private dynamicExampleDao dao;
	
	@PostMapping("/dyex1")
	public String dynamicQuery1(Model m, String saname){
		Map<String, String> map = new HashMap<>();
		map.put("saname", saname);
		List<SawonVO> list = dao.getSawonList(map);
		m.addAttribute("list", list);
		return "dynamicExample1";
	}
	@GetMapping(value= {"/dynamic1","/dyex1"})
	public String dynamicQuery1() {
		return "dynamicExample1";
	}
	
	
	@PostMapping("/dyex2")
	public String dynamicQuery2(String saname,String sajob,Model m) {
		Map<String, String> map = new HashMap<>();
		//sajob이란 파라미터를 받아서 Map입력
		map.put("saname", saname);
		map.put("sajob", sajob);
		List<SawonVO> list = dao.getSawonWhereList(map);
		m.addAttribute("list",list);
		return "dynamicExample2";
	}
	@GetMapping(value= {"/dynamic2","/dyex2"})
	public String dynamicQuery2() {
		return "dynamicExample2";
	}
	
	
	//http://localhost/spring0219/dyex3
	@PostMapping("/dyex3")
	public String dynamicQuery3(String searchType,String searchName,Model m) {
		Map<String, String> map = new HashMap<>();
		map.put("searchType",searchType);
		map.put("searchName",searchName);
		dataHandler(map,m);
		return "dynamicExample3";
	}
	@GetMapping(value= {"/dynamic3","/dyex3"})
	public String dynamicQuery3(Model m) {
		Map<String, String> map = new HashMap<>();
		dataHandler(map,m);
		return "dynamicExample3";
	}
	private void dataHandler(Map<String, String> map, Model m){
		List<SawonVO> list = dao.getSawonChooseList(map);
		m.addAttribute("list",list);
		}
	
	@PostMapping("/dyfor")
	public String dynamicQuery4(String[] dlist, Model m) {
		Map<String, List<String>> map = new HashMap<>();
		List<String> dept_list=null;
		try {
			dept_list = Arrays.asList(dlist);
		}catch(Exception e) {
			dept_list =	 new ArrayList<>();
		}
		map.put("dept_list", dept_list);
		List<SawonVO> list = dao.getForList(map);
		m.addAttribute("list", list);
		return "dynamicSawonForeachList";
	}
	@GetMapping(value= {"/dynamicfor","/dyfor"})
	public String dynamicQuery4() {
		return "dynamicSawonForeachList";
	}
	
	@GetMapping("/d3test")
	public String d3Test() {
		return "d3test";
	}
}

//private void dataHandler(Map<String, String> map, Model m){
//List<SawonVO> list = dao.getSawonList(map);
//m.addAttribute("list",list);
//}