package ex1;

public class Ex3_Demotion {
	// 4byte ������ ������ JVM ����� �ڵ����� 4byte�� �°��ؼ� ������.
	//demotion , promotion
	// java EX3_Demotion => JVM�� ���� �� MAIN �޼��忡�� ȣ��(����)
	public static void main(String[] args) {
	
	byte n1 = 10;
	byte n2 = 20;
	System.out.println(n1);
	System.out.println(n2);

	byte n3 = (byte) (n1 + n2);
	// ����) short sh1, sh2�� ���� ���� 100, 200�� ����.
	// shortsh3�� ���� ������ �Ŀ� ����� �غ��ô�.
	System.out.println(n1 +"+" +n2 + "= " + n3);
	
	short sh1 = 100;
	short sh2 = 200;
	short sh3 = (short) (sh1 + sh2);
	
	System.out.println(sh3);
	
	
	
	
	char c1 = 'A';
	short c2 = 1;
	char c3 = (char) (c1 + c2);
	System.out.println(c3);
	//ĳ����.ĳ�����̶� ����ȯ�� ����Ѵ�. ĳ���Ͱ� 2����Ʈ ��Ʈ�� 2����Ʈ. �ٵ� ������ �Ͼ. �̰� 4����Ʈ�� �Ͼ. 
	// �� c3�� 4����Ʈ. �ٵ� 2����Ʈ + 2����Ʈ�� ������ �ȵ�. 
	//���⼭ 4����Ʈ������ ����Ư¡�� ��Ÿ��.
	}
}
