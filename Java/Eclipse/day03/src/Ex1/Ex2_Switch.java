package Ex1;

public class Ex2_Switch {
	public static void main(String[] args) {
		// jdk 7���� String ���ڿ� �� ����
		String s = "B";
		boolean b = true;
		char ch = 'A';
		float f = 3.14F;
		byte bb = 10;
		double bn = 10.1;
		long ll = 10L;
		switch(s) { //case "����"; ����; break;
		case "A" :
			System.out.println("���ڿ�A");
			break;
		case "B" :
			System.out.println("���ڿ� B");
			break;
		default :
			System.out.println("���� ���ڿ�!");
			
		}
		//����ġ�� ���� : �������� ���ϴ�.
		//����ġ���� ���� �ȵǴ� ������ �׽�Ʈ �غ��� �ٶ��ϴ�.
		/*switch(b) {
		 * boolean ��� �ȵ�,
		}*/
		switch(ch) {
		case	'A' :
			System.out.println("���� A");
			break;
		case 'B' :
			System.out.println("���� B");
			break;
		}
		
		int num = 1;
		switch(num) {
		case 0 :
			System.out.println("0");
			break;
		case 1 : 
			System.out.println("1");
			break;
		}
		//switch(f) {
		//}
		//����ġ���� int string �̳� enum variable�� �����ϴ�.
		
		
		
	}
}
