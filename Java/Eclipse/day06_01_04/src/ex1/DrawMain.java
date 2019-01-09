package ex1;

public class DrawMain {
	public static void main(String[] args) {
		Circle cir=new Circle();
//		Rect rec=new Rect();
		Triangle tr=new Triangle();
		System.out.println("원 : "+cir.drawSomething(cir.getPi(), cir.getRadius(), cir.getRadius()));
		System.out.println("삼각형: "+tr.drawSomething(tr.getHeight(), tr.getWidth(), 1)/2);
	}

}
