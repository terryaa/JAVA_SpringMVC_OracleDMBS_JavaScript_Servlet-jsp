package ex1;

public class CellPhone {
	private String model;
	private String color;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	void powerOn() {System.out.println("전원을켭니다");}
	void powerOff() {System.out.println("전원을 끕니다");}
	void bell() {System.out.println("벨이 울립니다");}
	void sendVoice(String message) {System.out.println("자기: "+message);}
	void receiveVoice(String message) {System.out.println("상대방: "+message);}
	void hangUp() {System.out.println("전화를 끊습니다");}
	
	
}
