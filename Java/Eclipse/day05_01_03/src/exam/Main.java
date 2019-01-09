package exam;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("회원수 입력:");
		int rep=Integer.parseInt(sc.nextLine());
		PojoClient[] array=new PojoClient[rep];
		for(int i=0;i<rep;i++)
		{
			System.out.print("번호");
			int num=Integer.parseInt(sc.nextLine());
			System.out.print("이름:");
			String name=sc.nextLine();
			System.out.print("아이디:");
			String id=sc.nextLine();
			System.out.print("나이:");
			int age=Integer.parseInt(sc.nextLine());
			System.out.print("이메일 수신 동의:");
			int agree=Integer.parseInt(sc.nextLine());
			//POJO에 입력받은 값을 setter로 저장. 
			
			PojoMember ep=new PojoMember();
			ep.setNum(num);
			ep.setName(name);
			ep.setId(id);
			ep.setAge(age);
			if(agree==1) {
				ep.setAgree(true);
			}
			else if(agree==2) {
				ep.setAgree(false);
			}
			array[i]=new PojoClient(ep);
		}
		
		for(PojoClient client:array){
			client.printMember();
		}
	}
	

}
