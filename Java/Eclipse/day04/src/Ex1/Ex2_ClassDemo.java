package Ex1;
//Ŭ���� ����
//1. ���
// { } = ���
//2. ����ʵ�
//3. ����޼���
//Ŭ������ ��ü �������� ����(����), ��� ���θ޼���� ���Ե��� �ʴ´�.
public class Ex2_ClassDemo {
	///*****����ʵ�� ����� ���ÿ� �ʱ�ȭ�� ��!
	int pay;
	String team;
	// �޼��带 �ѹ� �����鼭 �ǹ̸� �ľ��غ��ô�.
	public void test() { //Ex2_ClassDemo Ŭ������ ��ü�� ���� �� ���Ŀ� ����ϴ� �޼���.
		System.out.println("pay : " + pay + ", Team : " + team);
		//�̴�� ����ϸ� pay = 0 �̰� team �� null����.
	}
	// �׽�Ʈ �� 18~21 ������ �ּ�ó���ϰ� Ex2_MainŬ������ ���� ����
/*	public static void main(String[] args) {
		Ex2_ClassDemo ref = new Ex2_ClassDemo();
		ref.test();
		
	}
*/

//�ǹ��ִ� �۾����� �޼��带 ���� �غ��ô�.
//pay�� � ���� ������ �� �ֵ��� �����ϴ� �޼��� �����
//��ȯ���� ������ �� ����ؾ� �� �� : �޼��� ȣ�� �Ŀ� Ư�� ���� ��ȯ ���� ������
//���� ���� ������ �޼��常 ������ �� ����
//���� �Ѵ� �۾��� ���ؼ� ��ȯ ���� ���� �ʿ䰡 ���ٰ� �����ؼ� void�� ��������

public void insertPay(int p) {
	System.out.println("LOG1 : �������� pay :" + p);
	System.out.println("LOG2 : ����ʵ� pay : " + pay);
	//���࿡ ���������� pay = 10000;�̸� ���������� �켱���� ħ. 
	//�������̳ĸ� ���� class Ex2_ClassDemo �ȿ��� pay�� 0�̴��� ���⼭�� pay�� 10000�̹Ƿ� ���Ⱑ �켱��.
	//�׷��� ����ʵ忡 �ִ°� ����ϰ� ������ ���������� p�� �ٲٴ��� �ؾ� ��.
	
	
	
	//�� int pay �̰� ������������ int pay ����ϴϱ� (int pay�ΰ���)
}
	//�غ��� 1. �̹����� team�� ���� �����ϴ� �޼��带 ����� ���ô�.

	public void insertPayTeam(int p, String t) {
		pay = p;
		team = t;
	}


	//�غ��� 2. �̹����� pay, team�� ���� ���ÿ� �����ϴ� �޼��带 ����� �G��.

public void paytem(String tt, int p) {
	tt = "ttteam";
	p = 23;
	System.out.println("�������� PAY :" + p);
	System.out.println("����ʵ� pay :" + p);
	System.out.println("�������� ��" + tt);
	System.out.println("����ʵ� ��" + team);
}






}




