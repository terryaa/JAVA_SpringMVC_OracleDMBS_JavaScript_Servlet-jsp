package ex1_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1_Main {
	public static void main(String[] args) {
		ApplicationContext ctx=new GenericXmlApplicationContext("ex1_1/auto.xml");
		PrintInter pi=ctx.getBean("auto",PrintInter.class);
		System.out.println(pi.printName());
	}
}
