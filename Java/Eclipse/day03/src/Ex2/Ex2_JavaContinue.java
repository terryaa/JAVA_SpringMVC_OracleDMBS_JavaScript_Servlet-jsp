package Ex2;

public class Ex2_JavaContinue {
	public static void main(String[] args) {
		/*for (int i = 0; i < 10; i++) {
			if(i ==2 || i == 5) {
				continue; // i�� 2 �Ǵ� 5�� ��� ���� �ݺ������� �Ѿ��.
				//2�ϰ� 5�� �н��� �ȴ�. 
			}
			System.out.println(i);
		}
	*/
		for (int i = 0; i < 5; i++) {
			ex: for(int j = 0; j < 5; j++) {
				if(j==3) {
					continue ex;
				}
				//j�� 3�� �� ���� ������ �������� �ʰ� ex�� �Ѿ��.
				System.out.println("i:" + i + " , j" + j);
			}
		}
	
	
	}
}
