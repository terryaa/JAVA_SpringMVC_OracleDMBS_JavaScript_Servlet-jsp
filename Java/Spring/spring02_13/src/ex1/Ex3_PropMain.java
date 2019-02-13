package ex1;

import java.util.Properties;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex3_PropMain {
	public static void main(String[] args) {
		ApplicationContext ctx=new GenericXmlApplicationContext("ex1/map2.xml");
		Ex3_Prop prop=ctx.getBean("propBean",Ex3_Prop.class);
		Properties props=prop.getProp();
		System.out.println("메세지입력:");
		Scanner sc=new Scanner(System.in);
		String msg=sc.nextLine();
		String result=(String)props.getProperty(msg,"알수없는단어네요");
		System.out.println("출력:"+result);
		}
}
