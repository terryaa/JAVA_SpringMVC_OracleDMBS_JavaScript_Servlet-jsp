package Ex1;

public class Ex2_Main {
	public static void main(String[] args) {
		
		Ex2_ClassDemo ref = new Ex2_ClassDemo();
		ref.test();
		ref.insertPay(10000);
		System.out.println("pay�� : " + ref.pay);
		System.out.println("------------------");
		System.out.println("pay�� : " + ref.pay);
		ref.insertPayTeam(1000, "ATeam");
		System.out.println("Pay : " + ref.pay);
		System.out.println("Team: " + ref.team);
		//p���� ���������������� �����ϹǷ� �����°� �Ұ���.
	}
}
