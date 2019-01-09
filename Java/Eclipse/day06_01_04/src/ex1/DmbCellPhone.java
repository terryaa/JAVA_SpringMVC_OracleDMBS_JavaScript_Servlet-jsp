package ex1;

public class DmbCellPhone extends CellPhone {
	
	private int channel;
	
	public int getChannel() {
		return channel;
	}


	public void setChannel(int channel) {
		this.channel = channel;
	}


	DmbCellPhone(String model,String color,int channel){
		this.setModel(model);
		this.setColor(color);
		this.channel=channel;	
	}
	
	
	void turnOnDmb() {
		System.out.println("채널 "+channel+"번 DMB 방송 수신을 시작합니");
	}
	void changeChannelDmb(int channel) {
		this.channel=channel;
		System.out.println("채널"+channel+"번으로 바꿉니다.");
	}
	
	void turnOffDmb() {
		System.out.println("DMB방송 수신을 멈춥니다.");
	}

}
