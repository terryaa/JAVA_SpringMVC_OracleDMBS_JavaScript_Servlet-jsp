package Ex1;
/*
 * A���� �ְ� B���� �ִ�. 
 * A�� ���׸� insertpay��� method�� ���ؼ� ���� �����ϰ� ���ְ� �Ͱ�
 * B���� �� ���� ����� �ؾ��ϴϱ� �� ������ ���Բ� ���ְ� �ʹ�. 
 * ��� int pay ��� method�� �ʿ����. 
 * �� A���� Read, write �Ѵ� �ǰ� B���� Read�� �����ϰԲ�.
 */
public class Ex3_ClassDemo {
	//A,B���̵� PAY�� �ڿ��� ���� �������� ���ϵ��� �Ѵ�.
	private int pay;
	
	
	
    public void insertPay(int pay, String pwd) {
    	if(pwd.equals(1)) {
    		this.pay=pay;
    	}
    	else {
    		System.out.println("����");
    	}
		//this.����ʵ��� pay = �������� pay

		
	}
	//����ʵ��� pay���� ��ȯ���ִ� �Լ�
    public int viewPay() {
    	return pay;
    	
    }
	
}
