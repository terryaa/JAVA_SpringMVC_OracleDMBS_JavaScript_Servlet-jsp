package ex2;

public class Ex1_Child extends Ex1_Parent{
	//2.Object의 메서드를 재정의한것.
	@Override
	public String toString() {
		return String.valueOf("상속받은 금액:"+getPay());
	}
	//반드시 재정의해야만 Ex1_Parent상속가
@Override
public void moveMountain() {
	// TODO Auto-generated method stub
	System.out.println("산을 성공적으로 옮긴 후"+toString()+"받았다");
}
}
