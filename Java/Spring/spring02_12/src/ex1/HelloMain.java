package ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	//ApplicationContect->BeanFactory를 상속받은 컨테이너
	//국제화 자원,반을 생성 담당한다던지.....
	//GenericXmlApplicationContext : jdk5부터 지원해주는 제네릭을 제공 해주는
	//컨테이너 구현 객체
	//Spring3.0부터지원!
	public static void main(String[] args) {
		//1.컨테이너 등록 및 생성 이때 xml에 정의해논 모든 빈들이 생성된다. 
		//빈들의 객체는 한개만 생성되며, static공간에 생기는 singleton객체이다.
		
		ApplicationContext ctx=
				new GenericXmlApplicationContext("ex1/hello.xml");
		//2.컨테이너에 등록된 필요한 객체를 참조
		//생성하는것이아니다.
		//getBean메소드들중, id와 class를 인자로주면 해당 인자로 준 클래스를 알아서리턴한다.
		//casting이 필요없네?
		HelloBean hBean=ctx.getBean("hello", HelloBean.class);
		String msg=hBean.printMessage();
		System.out.println(msg);
		HelloBean hBean2=ctx.getBean("hello", HelloBean.class);
		System.out.println("비교:"+(hBean==hBean2)); 
		
	}
}
