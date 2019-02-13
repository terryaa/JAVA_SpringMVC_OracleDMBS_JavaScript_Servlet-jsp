package aop.ex0;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class MessageMain {
public static void main(String[] args) {
	//1.Target객체를 생성
	MessageImple target=new MessageImple();
	//2. Advice 객체를 생성
	MessageAdvice advice=new MessageAdvice();
	//3. 1,2를 위빙시키기위한 관리 객체를 생성 
	ProxyFactoryBean pBean=new ProxyFactoryBean();
	//3-1. ProxyFactoryBean에게 타겟,Advice들을 알려주도록 한다.
	pBean.setTarget(target);
	//3-2 PintCut과 Advice를 결합한 Advisor를 생성
	NameMatchMethodPointcut pointCut=new NameMatchMethodPointcut();
	//mess시작하는 모든 메서드를 pointcut으로 설정
	pointCut.setMappedName("mess*");
	pBean.addAdvisor(new DefaultPointcutAdvisor(pointCut,advice));
	
	//비즈니스 로직을 요청
	Messageinter prMessage=(Messageinter) pBean.getObject();
	
	
	System.out.println(prMessage.message());
}
}
