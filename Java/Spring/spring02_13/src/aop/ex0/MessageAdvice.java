package aop.ex0;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageAdvice implements MethodInterceptor {

	//������ɻ���1 ---- advice���뿵��
	//�ٽɷ��� ����   ---- �޼���ȣ��
	//������ɻ���2 ----advice���뿵��
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Ÿ�ٺ��� ���� ó���� ���� ! before��ó��");
		Object rev=invocation.proceed();
		System.out.println("Ÿ���� ���� �� �� ó�� �� ����!After ��ó��!!");
		
		//��ó������ó���� �� �Ͼ����, around advice�������Ѵ�. 
		return rev;
	}
	
}
