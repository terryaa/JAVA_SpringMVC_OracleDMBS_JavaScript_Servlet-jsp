package exam;

public class CarTest {
	public static void main(String[] args) {
		Car c1=new Car();
		c1.setColor("white");
		c1.setGearType("auto");
		c1.setDoor(4);
		Car c2=new Car("Gray","auto",4);
		System.out.println("c1�� color:"+c1.getColor()+", gearType: "
				+c1.getGearType()+"door: "+c1.getDoor());
		System.out.println("c2�� color:"+c2.getColor()+", gearType: "
				+c2.getGearType()+"door: "+c2.getDoor());
	}
}

