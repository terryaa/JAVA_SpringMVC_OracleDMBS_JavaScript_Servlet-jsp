package aop.ex0;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class MessageMain {
public static void main(String[] args) {
	//1.Target��ü�� ����
	MessageImple target=new MessageImple();
	//2. Advice ��ü�� ����
	MessageAdvice advice=new MessageAdvice();
	//3. 1,2�� ������Ű������ ���� ��ü�� ���� 
	ProxyFactoryBean pBean=new ProxyFactoryBean();
	//3-1. ProxyFactoryBean���� Ÿ��,Advice���� �˷��ֵ��� �Ѵ�.
	pBean.setTarget(target);
	//3-2 PintCut�� Advice�� ������ Advisor�� ����
	NameMatchMethodPointcut pointCut=new NameMatchMethodPointcut();
	//mess�����ϴ� ��� �޼��带 pointcut���� ����
	pointCut.setMappedName("mess*");
	pBean.addAdvisor(new DefaultPointcutAdvisor(pointCut,advice));
	
	//����Ͻ� ������ ��û
	Messageinter prMessage=(Messageinter) pBean.getObject();
	
	
	System.out.println(prMessage.message());
}
}
