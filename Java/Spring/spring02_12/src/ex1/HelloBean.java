package ex1;

public class HelloBean {
	private String msg;
	public HelloBean() {
		System.out.println("HelloBean »ý¼º!");
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String printMessage(){
		return "Hi"+msg;
	}

}
