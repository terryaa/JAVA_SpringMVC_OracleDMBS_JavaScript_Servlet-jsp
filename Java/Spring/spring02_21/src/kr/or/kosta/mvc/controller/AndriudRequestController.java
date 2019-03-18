package kr.or.kosta.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.kosta.dto.JsonVO;
import kr.or.kosta.dto.customerVO;

@Controller
public class AndriudRequestController {
	
	@GetMapping("/value1")
	public String ex1_hello(String msg,Model m) {
		String contents = msg+": walk up!";
		System.out.println("Message:"+msg);
//		m.addAttribute("contents",contents);
//		retrun "app1";
		return contents;
	}
	
	@GetMapping("/value2")
	@ResponseBody
	public Map<String, String> ex1_hello(){
		Map<String, String> map = new HashMap<>();
		map.put("1","kosta188");
		map.put("2","kosta198");
		map.put("3","kosta208");
		return map;
	}
	
	@GetMapping("/value3")
	@ResponseBody
	public List<Map<String, String>> ex1_hello1(){
		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		map1.put("1", "bigdate1");
		map1.put("2", "bigdate2");
		map1.put("3", "bigdate3");
		map2.put("1", "bigdate1");
		map2.put("2", "11");
		map2.put("3", "±è±æµ¿");
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		list.add(map1);
		list.add(map2);
		return list;
	}
	
	
	@GetMapping("/valjson")
	@ResponseBody
	public JsonVO ex1_hello2(){
		JsonVO jvo = new JsonVO();
		List<customerVO> list = new ArrayList<customerVO>();
		for(int i =0; i<3; i++ ) {
		customerVO cvo = new customerVO();
		cvo.setName("±è±æµ¿"+i);
		cvo.setNum(i+1);
		cvo.setAddress("°¡»ê"+i);
		cvo.setSsn("801211-112122"+i);
		list.add(cvo);
		}
		jvo.setSuccess(true);
		jvo.setList(list);
		jvo.setTotal_cnt(list.size());
		return jvo;
	}
}