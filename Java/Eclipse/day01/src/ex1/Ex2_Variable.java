package ex1;

public class Ex2_Variable {
	public static void main(String[] args) {
		//�������� : �⺻�� Ÿ�� 8���� , ���� Ÿ�� (�� ��)
		// ���� ����Ʈ) ���� 38page
		// ������ : byte(1), short(2), int(4), long(8)
		// �Ǽ��� : float(4), double(8)
		// ���� : boolean(1) (��/����) true/false
		int a = 3; // ������ ���� 3�̶� ����� (=)�����Ѵ�
		int b; // ������ ����, ���� �Ҵ��� �ȵ�.
		b = 3; // ������ ���� b�� 3�� ����.
		// int a; // ������ { } ���� �ȿ��� �ѹ��� ������ �� �ִ�.
		// short Ÿ���� c ������ 50�� ������ �� �ִ�. (-32768 ~ 32767)
		short c = 50;
		// byte Ÿ���� d���� 100���� ������ �� �ִ�. (���� : -128 ~ 127����.)
		byte d = 100;
		//All���� ���ڿ��� ����ͷ� ����� �ϴ� �Լ�
		System.out.println(a);
		System.out.print("���� a�� �� : ");
		System.out.println(a);
		System.out.println("���� b�� �� :" + b);
		System.out.println("---------");
		// "" => ���ڿ��� �ǹ��ϰ� ���� �ڷ������� ����
		// ���ڿ� ���Ῥ���� => +
		System.out.println("���� c�� �� :" + c);
		System.out.println("���� d�� �� :" + d);
		
		long e = 2000000033L; // L ~ 1 ���ͷ� ���̻�. 
		System.out.println(e);
		// ��) long�� 8byte -> int 4byte
		long times = System.currentTimeMillis();
		int timess = (int) System.currentTimeMillis();
		// (int) <- ������ int�� ��ȯ��Ű�°���. 
		System.out.println("Times:" + times);
		System.out.println("timess:" + timess);
		// overflow�� ���Ͽ� -�� ��ȯ. ��Ȯ�� ���� �ȳ���. 
		
		
		
		
		//���� ����Ģ
		// 1. ��ҹ��� ����
		// 2. ���ڷ� ���� x
		// 3. Ư������ _, $ �ΰ����� ����
		// 4. ������ ���������� ��� �Ұ�
		// 5. ������ ������ �ҹ��ڷ� �����ؾ��Ѵ�. (�ʼ�)
		
		int x;
		int X; // ��ҹ��� ����
		int numberOptionApplication;
		// ���ڷ� ������ �ȵ����� ȥ���� ����
		
		
		
		int num1;
		int num2 = 10;
		num2 = 20; // �������� ����� ���� �����.
		//���� = ���ϴ� ��
		// ��� = ������ ��. final - Ű���带 ����ϸ� ���α׷��� ����� �� ���� ���� �Ұ���.
		
		
		final int SIZE = 8; // �����
		System.out.println(SIZE);
		//SIZE = 10;
		//3.14 => double �̰�, float(4) = F,f ���ͷ� ǥ��
		float g = 3.14f;
		double h = 3.14d;
		//boolean(1)
		boolean i = true;
		//�ڹٿ����� �� ���ڸ� �����ڵ�(2byte)�� �ν�
		//'����'=> "A"�� ���ڿ�(�����ڷ���)
		
		char j = 'A';
		
		System.out.println("boolean:" + i  + " ,\n char : " + j);
		// int k = 100;
		// long l = k;
		// �������ʿ����. ���θ���̶�� ��.  
		// �ݴ� ��Ȳ�� ����. �������ؾ���
	
	}

}
