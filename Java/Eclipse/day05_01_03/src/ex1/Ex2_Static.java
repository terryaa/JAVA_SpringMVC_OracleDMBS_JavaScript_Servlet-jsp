package ex1;

public class Ex2_Static {
	//Static�� ����
	//�ϳ��������� ��� ��ü�� ����
//�������� ���� �� ��밡��
	//static�� ���� ���� ��� �ڿ��� JVM�� �����߿� static ������ ��ġ�Ѵ�. 
	public static int  num1;
	private int num2;
	public void startTest() {
		num1++;
		num2++;
	}
	public static int getNum1() {
		return num1;
	}
	public int getNum2() {
		return num2;
	}
}
