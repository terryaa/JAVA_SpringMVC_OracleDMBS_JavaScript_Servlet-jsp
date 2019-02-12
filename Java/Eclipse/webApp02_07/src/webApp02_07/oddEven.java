package webApp02_07;

public class oddEven {

	public boolean oddeven(String choice) {
		int rannum=(int) (Math.random()*2);
		int num;
		if(choice.equals("even")) {
			num=1;
		}
		else
			num=2;
		if(rannum==num) {
			return true;
		}
		else
			return false;
	}
}
