package ex2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import ex1_1.PrintInter;

public class Ex1_ResourceService implements PrintInter{

	//javax는 자바확장 api에서 제공하는 자동 빈 묶기 에서 byType일 경우
	//같은 탕비일 경우 alias를 사용해서 접근
	//@Resource("myMsg")
	@Resource
	@Qualifier("h")
	private String msg;
	@Override
	public String printName() {
		return msg+"입니다.";
	}
	

}
