package aop.ex0;

public class MessageImple implements Messageinter {

	private String message;
	@Override
	public void print() {
		System.out.println("Print �޼��� ȣ��");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print2() {
		System.out.println("print2��ȣ��");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test() {
		System.out.println("test �޼��尡 ȣ��");
		// TODO Auto-generated method stub
		
	}

	@Override
	public String message() {
		// TODO Auto-generated method stub
		System.out.println("$$$$$$$$$");
		return "&&&&&&&&&&afterreturn"+message;
	}

}
