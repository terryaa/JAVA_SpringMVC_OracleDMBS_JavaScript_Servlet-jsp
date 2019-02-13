package exam;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aop.ex0_1.MyBeanInter;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=new GenericXmlApplicationContext("exam/chest.xml");
		System.out.println("꺼낼 아이템을 선택해보세요");
		System.out.println("칼 1번:");
		System.out.println("도끼2번:");
		System.out.println("창3번:");
		System.out.print("방패4번:");
		Scanner sc=new Scanner(System.in);
		int num=Integer.parseInt(sc.nextLine());
		System.out.print("무기를 황금으로 업그레이드 하려면 비밀번호(모르면그냥엔터):");
		String password=sc.nextLine();
		WeaponInter weapon=ctx.getBean("weapon"+num,WeaponInter.class);
		System.out.println(weapon.drawWeapon(password));
		
	}

}
