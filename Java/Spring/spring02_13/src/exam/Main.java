package exam;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aop.ex0_1.MyBeanInter;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=new GenericXmlApplicationContext("exam/chest.xml");
		System.out.println("���� �������� �����غ�����");
		System.out.println("Į 1��:");
		System.out.println("����2��:");
		System.out.println("â3��:");
		System.out.print("����4��:");
		Scanner sc=new Scanner(System.in);
		int num=Integer.parseInt(sc.nextLine());
		System.out.print("���⸦ Ȳ������ ���׷��̵� �Ϸ��� ��й�ȣ(�𸣸�׳ɿ���):");
		String password=sc.nextLine();
		WeaponInter weapon=ctx.getBean("weapon"+num,WeaponInter.class);
		System.out.println(weapon.drawWeapon(password));
		
	}

}
