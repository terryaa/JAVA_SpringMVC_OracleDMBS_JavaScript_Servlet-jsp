package ex2;

public class Ex3_Oper {
	public static void main(String[] args) {
		//����������
		//��ġ : �������� ���ѳ��� ����
		//��ġ : ������ �� ���� ��Ű�� ��
		int a = 10;
		int b = 10;
		int c = 0;
		
		System.out.println("a:" + (++a));
		System.out.println("b:" + (b++));
		System.out.println("b++:" +b);
		System.out.println("c:" +(++c));
		System.out.println("c:" +c);
		
		int e = 1;
		
		System.out.println(e++);
		System.out.println(++e);
		System.out.println(e);
		
		//�޸𸮻󿡼� e++�� 1�� ��� �� ++�� ��Ŵ
		//�׸��� ++�� �̸� �� �� ���� 3�� ����. �� �޸𸮴� 3���� �ν���
	}

}
