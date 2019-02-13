package ex1_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Ex1_AutoWiredService implements PrintInter{
	//빈이 너무많아지면 엑스엠엘 에 전부적는것이 가독성이떨어지기때문에
	//다른방법으로 DTO를 만들어서 쓴다.
	//자동으로 의존관계의 빈들을 묶어주는 어노테이션.
	//byName,byType 등등
	//byName은 프로퍼티와 이름이 동일하면 바로 자동으로 빈을 주입해준다.
	//byType은 같은 타입이 있으면 검색해서 자동으로 빈을 주입해준다.
	//이 둘은 if / if동작으로 둘다 작동한다.
	//같은 타입 2개이상일때 원하는것을 고르기위해서 Qualifier를 사용한다.
	//@Autowired
	//@Qualifier("hold")
	//null을 허용합니다.
	//@Autowired(required=false)
	@Autowired
	@Qualifier("hold")
	private String name;
	@Override
	public String printName() {
		return "당신의 이름은:"+name+"입니다.";
	}
//	public Ex1_AutoWiredService() {
//		
//	}
//	public Ex1_AutoWiredService(@Qualifier("hold") String name)
//	{	
//		this.name=name;
//	}
}
