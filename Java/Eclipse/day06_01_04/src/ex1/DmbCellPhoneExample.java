package ex1;

public class DmbCellPhoneExample {
	public static void main(String[] args) {
	    DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰","검정",10);
	
		
		System.out.println("모델 : "+dmbCellPhone.getModel());
		System.out.println("색상 : "+dmbCellPhone.getColor());
		System.out.println("채널: "+dmbCellPhone.getChannel());
		
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("안녕하세요");
		
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
		
		System.out.println("------------------");
		SmartPhone smartPhone=new SmartPhone("스마트폰","로즈골드",true,true);
	
		System.out.println("모델: "+smartPhone.getModel());
		System.out.println("색상: "+smartPhone.getColor());

		
		smartPhone.isWifiOn();
		smartPhone.turnOffWifi();
		smartPhone.isWifiOn();
		
		smartPhone.isBlueToothOn();
		smartPhone.turnOffBlueTooth();
		smartPhone.isBlueToothOn();
	}
	

}
