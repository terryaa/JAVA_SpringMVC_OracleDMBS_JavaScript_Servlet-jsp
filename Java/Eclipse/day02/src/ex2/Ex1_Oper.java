package ex2;

public class Ex1_Oper {
	public static void main(String[] args) {
		//�Ϲ� �ڷ����� ��� ���� ������
		int a = 0;
		
		a += 10; // a = a + 10;
		
		System.out.println("1) " + (a-=5));
		System.out.println("2) "+ (a*=10));
		System.out.println("3) " + (a/2));
		System.out.println("4) " + (a%=2));
		
		
		
		
		
		
		
		//string Ŭ������ �Һ����� Ư¡�� �ֱ� ������ += ������ �ϸ�
		//������ ���ڿ� ��ü�� ������ �÷����� ��� �����ϴ� ���ʿ��� �޸𸮰� �����.
		// �ڷ��������� �������� ���� (Ŭ������ ��ü)
		String msg = "ABC";
		msg += "DEF";
		msg += "ZZZ";
		
		/*
		 * ���⼭ �������� ����.
		 * ���࿡ msg = ABC�ε�
		 * msg += "DEF"�� �Է���
		 * �׷��� ���⼭ ABCDEF�� �ƴ϶�, ABC �� �߰��� DEF�� �߰���
		 * �׷��� ABC DEF ABCEDF 3���� �ε�Ǵ°���.
		 * �ٵ� �̰� �� ����ϴ°Ŵϱ� �޸� ���� ��. �������� �ƴϹǷ� ���Ű� �ȵ�.
		 * �̷��� ������� �ʰ� ���ۿ� �־ ����ؾ� ��.
		 */
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("ABC").append("DEF:").append("ZZZ");
		System.out.println(sb);
		//Buffer �� ������ ����ؼ� ���ڿ��� �����ϰ� �����ؼ� (append() ȣ���ؼ� ���ۿ� ����)
		//����� �� �ִ�.
	}
}
