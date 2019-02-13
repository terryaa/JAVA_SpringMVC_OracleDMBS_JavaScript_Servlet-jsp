package ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1_ResourceMain {
	public static void main(String[] args) {
		ApplicationContext ctx=new GenericXmlApplicationContext("ex2/resource.xml");
		Ex1_ResourceService rs=ctx.getBean("res",Ex1_ResourceService.class);
		System.out.println(rs.printName());
	}

}
