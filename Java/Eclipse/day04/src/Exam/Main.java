package Exam;

import java.util.Scanner;

import Ex3.Ex3_PojoDemo;

public class Main {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("������ �Է��ϼ���.");
	System.out.println("�̸�");
	String name = sc.nextLine();
	System.out.println("�й�");
	int id = Integer.parseInt(sc.nextLine());
	System.out.println("�г�");
	int grade = Integer.parseInt(sc.nextLine());
	System.out.println("�����");
	int language = Integer.parseInt(sc.nextLine());
	System.out.println("�����");
	int english = Integer.parseInt(sc.nextLine());
	System.out.println("���м���");
	int mathematics = Integer.parseInt(sc.nextLine());
	
	int average = (english+language+mathematics)/3;
	
	
	StudentDemo studemo = new StudentDemo();
	studemo.setName(name);
	studemo.setId(id);
	studemo.setGrade(grade);
	studemo.setLanguage(language);
	studemo.setEnglish(english);
	studemo.setMathematics(mathematics);
	studemo.setAverage(average);
	
	System.out.println("������ �ԷµǾ����ϴ�. ����� ��� ������" + studemo.getAverage() + "�̸�" );
	System.out.println("�����");
	if(studemo.getAverage()>=90) {
		System.out.println("A����Դϴ�. ����Դϴ�. ���ϵ帳�ϴ�.");
	}
	else if(studemo.getAverage() >= 80 && studemo.getAverage() <90) {
		System.out.println("B����Դϴ�. ����Դϴ�. ���ϵ帳�ϴ�.");
	}
	else if(studemo.getAverage() >= 70 && studemo.getAverage() <80) {
		System.out.println("C����Դϴ�. Ż���Դϴ�.");
	}
	else if(studemo.getAverage() >=60 && studemo.getAverage() <70) {
		System.out.println("D����Դϴ�. Ż���Դϴ�.");
	}
	else {
		System.out.println("�б������Ͷ�");
	}
	
	System.out.println("�����Ͱ� �� �ԷµǾ����� Ȯ��");
	System.out.println(studemo.getName());
	System.out.println(studemo.getGrade());
	 	
	
	
	System.out.println("---------");
	System.out.println("�ٸ� Ŭ�������� ���������� Ȯ��");
	
	Calculate caca = new Calculate();
	caca.CalculateGrade(studemo);
	
	
	
	}
	
	
	
	}
