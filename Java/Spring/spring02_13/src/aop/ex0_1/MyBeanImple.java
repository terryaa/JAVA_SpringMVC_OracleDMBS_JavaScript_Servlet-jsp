package aop.ex0_1;

public class MyBeanImple implements MyBeanInter{

	@Override
	public String myGetMessage(String name,String id) {
		StringBuffer sb=new StringBuffer();
		sb.append("Message:").append("test");
		sb.append("�ٽɷ��� ����!");
		return sb.toString();
		
	}
	
}
