package aop.ex1;

public class AfterThrowAdvice {
	
	public void commThrow(Exception ew) {
		System.out.println("���� �޼���:"+ew.getMessage());
	}

}
