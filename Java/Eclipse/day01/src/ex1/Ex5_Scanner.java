package ex1;

import java.util.Scanner;
//�ڵ����� �ԷµȰ���. �ܺ��� Ŭ������ �ҷ��� �� ���
public class Ex5_Scanner {
	public static void main(String[] args) {
		//Ű����� �Է°��� �ޱ� ���� Ŭ����
		// �����ؼ� �ѹ� ����ϱ�. �����ϱ⸸.
		// ���� �ڷ��� ������ = new ������ Ŭ������();
		Scanner sc = new Scanner(System.in);
		//system.out = ����� �ǹ�
		//system.in = �Է��� �ǹ�.
		// ������������ ������ ��ü�� �ּҰ��� ���� (100����)
		System.out.print("�Է� :");
		// sc���� ������ ����ؼ� nextline()�� ȣ���ؼ� �Էµ� ���� ���ڿ��� ��ȯ�Ѵ�
		String msg = sc.nextLine(); // ����ڷκ��� ��û�� ���ö����� ��޸�. ���ٴ����� �Է� �� ���Ͱ� ���� �� ����.
		System.out.println("res : " + msg);
	
	}
}
