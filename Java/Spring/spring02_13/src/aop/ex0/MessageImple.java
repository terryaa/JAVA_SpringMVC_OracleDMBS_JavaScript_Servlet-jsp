package aop.ex0;

public class MessageImple implements Messageinter {

	private String message;
	@Override
	public void print() {
		System.out.println("Print 메서드 호출");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print2() {
		System.out.println("print2가호출");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test() {
		System.out.println("test 메서드가 호출");
		// TODO Auto-generated method stub
		
	}

	@Override
	public String message() {
		// TODO Auto-generated method stub
		System.out.println("$$$$$$$$$");
		return "&&&&&&&&&&afterreturn"+message;
	}

}
