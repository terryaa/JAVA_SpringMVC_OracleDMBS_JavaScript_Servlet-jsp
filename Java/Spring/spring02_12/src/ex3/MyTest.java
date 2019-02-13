package ex3;

public class MyTest {
	private int num;
	private String msg;
	public MyTest(int num) {
		this.num=num;
	}
	public MyTest(String msg) {
		this.msg=msg;
	}
	public String printMyTest() {
		StringBuffer sb=new StringBuffer();
		sb.append("num:").append(num);
		sb.append("msg:").append(msg);
		return sb.toString();
	}

}
