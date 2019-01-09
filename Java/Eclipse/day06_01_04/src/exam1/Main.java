package exam1;

public class Main {
	
	public static void main(String[] args) {
		Draw[] array = new Draw[4];
		array[0]=new Circle();
		array[1]=new Rectangle();
		array[2]=new Triangle();
		array[3]=new Other();
		char a='A';
		for(Draw ref:array) {
			System.out.print(a+"팀이 ");
			ref.draw();
			a++;
		}
	}

}
