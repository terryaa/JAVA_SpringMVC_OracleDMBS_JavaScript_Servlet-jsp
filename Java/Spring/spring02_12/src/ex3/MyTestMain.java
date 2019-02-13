package ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MyTestMain {
	public static void main(String[] args) {
		ApplicationContext ctx=
				new GenericXmlApplicationContext
				("ex3/mytest.xml");
		MyTest mytest=ctx.getBean("mytest",
				MyTest.class);
		System.out.println(mytest.printMyTest());
	}
}
