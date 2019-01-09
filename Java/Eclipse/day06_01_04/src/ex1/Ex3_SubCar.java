package ex1;

public class Ex3_SubCar extends Ex3_SuperCar {

	@Override
	public void carColor() {
		System.out.println("자식의 스포츠카: 황금색");
	}
	
	public void testsub() {
		System.out.println("자식 클래스의 매소드호출!");
	}

	public static void main(String[] args) {
		//부모를 참조 자료형으로 자식클래스를 객채로 생성
		//부모의 자원만 참조가 가능하고
		//자식객체인Ex3_SubCar()자원은 참조가 불가능하다.
		Ex3_SuperCar ref=new Ex3_SubCar();
		System.out.println(ref instanceof Ex3_SubCar);
		ref.carColor();//자식의 메서드가 실
		ref.testSuper();
		//ref.testsub(); //참조자료형이 부모클래스이기띠문에 참조불가.
	}
}
