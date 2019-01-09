package exam;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("ȸ���� �Է�:");
		int rep=Integer.parseInt(sc.nextLine());
		PojoClient[] array=new PojoClient[rep];
		for(int i=0;i<rep;i++)
		{
			System.out.print("��ȣ");
			int num=Integer.parseInt(sc.nextLine());
			System.out.print("�̸�:");
			String name=sc.nextLine();
			System.out.print("���̵�:");
			String id=sc.nextLine();
			System.out.print("����:");
			int age=Integer.parseInt(sc.nextLine());
			System.out.print("�̸��� ���� ����:");
			int agree=Integer.parseInt(sc.nextLine());
			//POJO�� �Է¹��� ���� setter�� ����. 
			
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
