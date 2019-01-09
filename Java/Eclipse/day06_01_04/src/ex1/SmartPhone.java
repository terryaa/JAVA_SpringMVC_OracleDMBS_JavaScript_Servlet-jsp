package ex1;

public class SmartPhone extends CellPhone {
	private boolean wifi;
	private boolean bluetooth;
	
	public SmartPhone(String model,String color,boolean wifi, boolean bluetooth) {
		this.setModel(model);
		this.setColor(color);
		this.wifi=wifi;
		this.bluetooth=bluetooth;
		
	}
	
	void turnOnWifi() {
		wifi=true;
		System.out.println("와이파이를 켰습니다.");
	}
	void turnOffWifi() {
		wifi=false;
		System.out.println("와이파이를 껏습니다.");
	}
	
	void turnOnBlueTooth() {
		bluetooth=true;
		System.out.println("블루투스를 켰습니다");
	}

	void turnOffBlueTooth() {
		bluetooth=false;
		System.out.println("블루투수를 껏습니다.");
	}
	
	void isWifiOn() {
		if(wifi==true)
			System.out.println("와이파이가 켜져있습니다");
		else
			System.out.println("와이파이가 꺼져있습니다");
	}
	void isBlueToothOn() {
		if(bluetooth==true)
			System.out.println("블루투스가 켜져있습니다");
		else
			System.out.println("블루투스가 꺼져있습니다");
		
	}
}
