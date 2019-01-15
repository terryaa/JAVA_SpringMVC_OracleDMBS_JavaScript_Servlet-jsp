package Ex2;

public class Ex2_MethodDemo {

	
	private String color;
	
	public void paintColor(String color) {
		this.color = color;
		
	}
	public String viewColor() {
		return "당신이 선택한 색상은:" +color;
	}
	
}
