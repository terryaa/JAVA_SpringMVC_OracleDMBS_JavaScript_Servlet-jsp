package ex2;

public class Ex5_Oper {
	public static void main(String[] args) {
		
		int a = 12;		// 0 0 0 0 1 1 0 0
		int b = 2;		// 0 0 0 0 0 0 1 1
	  //int b = 2;      // => 0 0 0 0 0 0 1 1
		
		// a : ��Ʈ������ ���� , b : �󸶳� ����Ʈ �� �� ����
		// b��ŭ ����Ʈ �����϶�
		// �״ϱ� 1 1 0 0�ε� �̰� �о�� 0 0 1 1 �� ��. 3��. 1 1 0 0 �� �ڰ�� 12��.
		int c = a >> b;
		System.out.println("12>>2 :" + c);
		}
}
