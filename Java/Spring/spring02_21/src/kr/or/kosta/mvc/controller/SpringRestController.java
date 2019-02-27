package kr.or.kosta.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.dto.JsonVO;
import kr.or.kosta.dto.MemberVO;
import kr.or.kosta.dto.customerVO;

@RestController
@RequestMapping("/members")
public class SpringRestController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello Rest Ful";
	}
	
	@RequestMapping("/respVO")
	public MemberVO respVO() {
		MemberVO mvo = new MemberVO();
		mvo.setId("xamn");
		mvo.setName("梯望翕");
		mvo.setNum(8);
		mvo.setAddress("憮選");
		mvo.setPassword("test00");
		return mvo;
	}
	
	//@RequstMapping("/respListErrrorNot")
	@RequestMapping("/resplist")
	//public ResponseEntity<List<MemberVO>> respListNot(){
	public List<MemberVO> respList(){
		List<MemberVO> list = new ArrayList<>();
		for(int i=0; i<=12; i++) {
			MemberVO mvo = new MemberVO();
			mvo.setId("xamn"+i);
			mvo.setName("梯望翕"+i);
			mvo.setNum(i);
			mvo.setAddress("憮選"+i);
			mvo.setPassword("test00"+i);
			list.add(mvo);
		}
		return list;
		//return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	    //return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/valjson1")
	public JsonVO ex1_hello2(){
		JsonVO jvo = new JsonVO();
		List<customerVO> list = new ArrayList<customerVO>();
		for(int i =0; i<3; i++ ) {
		customerVO cvo = new customerVO();
		cvo.setName("梯望翕"+i);
		cvo.setNum(i+1);
		cvo.setAddress("陛骯"+i);
		cvo.setSsn("801211-112122"+i);
		list.add(cvo);
		}
		jvo.setSuccess(true);
		jvo.setList(list);
		jvo.setTotal_cnt(list.size());
		return jvo;
	}
	
	@RequestMapping("/respList2")
	public ResponseEntity<List<MemberVO>> respList(String code){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			if(code.equals("1")) {
				for(int i =0; i<=12;i++) {
					MemberVO mvo = new MemberVO();
					mvo.setId("xamn"+i);
					mvo.setName("梯望翕"+i);
					mvo.setNum(i);
					mvo.setAddress("憮選"+i);
					mvo.setPassword("test0"+i);
					list.add(mvo);
				}	
			}else {
				for(int i =0; i<=12;i++) {
					MemberVO mvo = new MemberVO();
					mvo.setId("zamn"+i);
					mvo.setName("梯望擎"+i);
					mvo.setNum(i);
					mvo.setAddress("憮選"+i);
					mvo.setPassword("xxoo"+i);
					list.add(mvo);
					}	
				}
			return new ResponseEntity<>(list,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);	
		}
	}
}
