package Ex2;
// Ŭ���� ���� - ����� ���� ����, ����ϴ� ���� ��ü
public class Ex3_Remocon {
	//�Ӽ�
	boolean power;
	int chNum;
	//setPower�� ȣ�� �� �� ���� ������ boolean ���� �޾Ƽ�
	//��� �ʵ� power�� �����ϰ� �� ���� �Ǻ��� �� ������ ����� ���.
	
	public void setPower(boolean p) {
		//��������� ����
		power = p;
		if(p==true) { //���α׷����� ����!
			System.out.println("������ �������ϴ�.");
			
		}
		else {
			System.out.println("������ �������ϴ�.");
		}
		
	}
	
	//��� �ʵ� chNum�� ���ý�Ŵ
	public void setChNum(int ch) {
		chNum = ch;
	}
	public String viewControl() {
		return "���� ä���� :" + chNum + "�Դϴ�.";
	}
}
