package Ex1;

public class Ex2_Main {
	public static void main(String[] args) {
		
		Ex2_ClassDemo ref = new Ex2_ClassDemo();
		ref.test();
		ref.insertPay(10000);
		System.out.println("pay값 : " + ref.pay);
		System.out.println("------------------");
		System.out.println("pay값 : " + ref.pay);
		ref.insertPayTeam(1000, "ATeam");
		System.out.println("Pay : " + ref.pay);
		System.out.println("Team: " + ref.team);
		//p값은 지역변수내에서만 참조하므로 떠오는거 불가능.
	}
}
