package aop.ex2;

public class BizServiceImple implements BizService {

	@Override
	public void bizMethod1() {
		// TODO Auto-generated method stub
		System.out.println("����!");

	}

	@Override
	public String second() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("===========").append("\n");
		sb.append("��浿").append("\n");
		sb.append("===========").append("\n");
		return sb.toString();
	}

}
