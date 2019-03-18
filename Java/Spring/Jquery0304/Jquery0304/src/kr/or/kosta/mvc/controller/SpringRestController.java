package kr.or.kosta.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.dto.Json2VO;
import kr.or.kosta.dto.Json3VO;

@RestController
@RequestMapping("/members")
public class SpringRestController {
	@RequestMapping("/data.json")
	public List<Json2VO> getJson(){
		List<Json2VO> list = new ArrayList<>();
		for(int i = 0; i<=12;i++) {
			Json2VO v = new Json2VO();
			v.setKey("Math"+i);
			v.setValue(101+i);
			list.add(v);
		}
		return list;
	}
	@RequestMapping("/data.json1")
	public List<Json2VO> getJson1(){
		List<Json2VO> list = new ArrayList<>();
		for(int i = 0; i<=12;i++) {
			Json2VO v = new Json2VO();
			v.setKey("jane");
			v.setValue(30+(i*10));
			list.add(v);
		}
		return list;
	}
	
	@RequestMapping("/data.json2")
	public List<Json3VO> getJson2(){
		List<Json3VO> list = new ArrayList<>();
		String[] name= {"jane","lee"};
		for(String e : name) {
			if(e.equals("jane")) {
				List<Integer> ilist = new ArrayList<>();
				Json3VO v = new Json3VO();
				Json2VO eve = new Json2VO();
				eve.setKey(e);
				v.setName(eve.getKey());
			for(int i = 0; i<=3;i++) {
				eve.setValue(i*4);
				ilist.add(eve.getValue());
				v.setList(ilist);
			}
			list.add(v);
			}else {
				List<Integer> ilist = new ArrayList<>();
				Json3VO v = new Json3VO();
				Json2VO eve = new Json2VO();
				eve.setKey(e);
				v.setName(eve.getKey());
			for(int i = 0; i<=3;i++) {
				eve.setValue(i*3);
				ilist.add(eve.getValue());
				v.setList(ilist);
			}
			list.add(v);
			}
		}
		return list;
	}
}