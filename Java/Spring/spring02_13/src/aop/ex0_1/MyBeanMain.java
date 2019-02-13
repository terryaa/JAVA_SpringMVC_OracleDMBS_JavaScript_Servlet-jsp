package aop.ex0_1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyBeanMain {
public static void main(String[] args) {
	ApplicationContext ctx=new GenericXmlApplicationContext("aop/ex0_1/mybean.xml");
	MyBeanInter mybean=ctx.getBean("pfBean",MyBeanInter.class);
	System.out.println(mybean.myGetMessage("±è±æµ¿","hello"));
	
	
	
	
}
}
