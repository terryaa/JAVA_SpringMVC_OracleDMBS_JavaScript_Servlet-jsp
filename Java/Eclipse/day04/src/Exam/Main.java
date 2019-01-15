package Exam;

import java.util.Scanner;

import Ex3.Ex3_PojoDemo;

public class Main {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("정보를 입력하세요.");
	System.out.println("이름");
	String name = sc.nextLine();
	System.out.println("학번");
	int id = Integer.parseInt(sc.nextLine());
	System.out.println("학년");
	int grade = Integer.parseInt(sc.nextLine());
	System.out.println("국어성적");
	int language = Integer.parseInt(sc.nextLine());
	System.out.println("영어성적");
	int english = Integer.parseInt(sc.nextLine());
	System.out.println("수학성적");
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
	
	System.out.println("정보가 입력되었습니다. 당신의 평균 점수는" + studemo.getAverage() + "이며" );
	System.out.println("당신은");
	if(studemo.getAverage()>=90) {
		System.out.println("A등급입니다. 통과입니다. 축하드립니다.");
	}
	else if(studemo.getAverage() >= 80 && studemo.getAverage() <90) {
		System.out.println("B등급입니다. 통과입니다. 축하드립니다.");
	}
	else if(studemo.getAverage() >= 70 && studemo.getAverage() <80) {
		System.out.println("C등급입니다. 탈락입니다.");
	}
	else if(studemo.getAverage() >=60 && studemo.getAverage() <70) {
		System.out.println("D등급입니다. 탈락입니다.");
	}
	else {
		System.out.println("학교좀나와라");
	}
	
	System.out.println("데이터가 잘 입력되었는지 확인");
	System.out.println(studemo.getName());
	System.out.println(studemo.getGrade());
	 	
	
	
	System.out.println("---------");
	System.out.println("다른 클래스에서 떠와지는지 확인");
	
	Calculate caca = new Calculate();
	caca.CalculateGrade(studemo);
	
	
	
	}
	
	
	
	}
