package Ex3;

import java.util.Scanner;

public class Ex3_Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//UI
		System.out.println("��ȣ:");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("�̸�:");
		String name = sc.nextLine();
		
		System.out.println("���̵�:");

		String id = sc.nextLine();
		System.out.println("����:");

		int age = Integer.parseInt(sc.nextLine());
		
		System.out.println("�̸��� ���� ���� 1.���� 2.�ź� =>");
		int agree = Integer.parseInt(sc.nextLine());
		
		//pojo�� �Է¹��� ���� setter�� ����
		Ex3_PojoDemo ep = new Ex3_PojoDemo();
		ep.setNum(num);
		ep.setName(name);
		ep.setId(id);
		ep.setAge(age);
		if(agree == 1) {
			ep.setAgree(true);
		}
		else if(agree == 2) {
			ep.setAgree(false);
		}
		System.out.println("�˻�");
		System.out.println("ȸ���� ���̵� �� : " + ep.getId());
		
		
		//����Ͻ� ������ ���� Ŭ������ ���ؼ� (��� ���)
		//Ex1_PojoMemberŬ������ ��ü�� �����Ѵ�
		Ex1_PojoMember em = new Ex1_PojoMember();
		em.setMember(ep); // �Է��� ȸ���߿� ���θ� ����
		em.printMember(); // �Էµ� ȸ���� ���� ���
		
		
	}
}
