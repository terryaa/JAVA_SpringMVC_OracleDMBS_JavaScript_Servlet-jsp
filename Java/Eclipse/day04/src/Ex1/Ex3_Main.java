package Ex1;

public class Ex3_Main {

	public static void main(String[] args) {
		Ex3_ClassDemo ref = new Ex3_ClassDemo();
		//ref.pay = 10000; 이거 안됨. private이므로
		ref.insertPay(10000, null);
		System.out.println("입력한 pay" + ref.viewPay());
		}
	}
	
	

