package ex2;

public class Ex1_Main {

	public static void main(String[] args) {
		Ex1_Parent ref=new Ex1_Child();
		ref.moveMountain();
		
		new Ex1_Parent() {
			@Override
			public void moveMountain() {
				System.out.println("새로운재정의!");
			}
		}.moveMountain();
	}
}
