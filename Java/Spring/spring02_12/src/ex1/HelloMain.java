package ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	//ApplicationContect->BeanFactory�� ��ӹ��� �����̳�
	//����ȭ �ڿ�,���� ���� ����Ѵٴ���.....
	//GenericXmlApplicationContext : jdk5���� �������ִ� ���׸��� ���� ���ִ�
	//�����̳� ���� ��ü
	//Spring3.0��������!
	public static void main(String[] args) {
		//1.�����̳� ��� �� ���� �̶� xml�� �����س� ��� ����� �����ȴ�. 
		//����� ��ü�� �Ѱ��� �����Ǹ�, static������ ����� singleton��ü�̴�.
		
		ApplicationContext ctx=
				new GenericXmlApplicationContext("ex1/hello.xml");
		//2.�����̳ʿ� ��ϵ� �ʿ��� ��ü�� ����
		//�����ϴ°��̾ƴϴ�.
		//getBean�޼ҵ����, id�� class�� ���ڷ��ָ� �ش� ���ڷ� �� Ŭ������ �˾Ƽ������Ѵ�.
		//casting�� �ʿ����?
		HelloBean hBean=ctx.getBean("hello", HelloBean.class);
		String msg=hBean.printMessage();
		System.out.println(msg);
		HelloBean hBean2=ctx.getBean("hello", HelloBean.class);
		System.out.println("��:"+(hBean==hBean2)); 
		
	}
}
