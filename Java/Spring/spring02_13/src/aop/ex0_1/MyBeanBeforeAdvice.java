package aop.ex0_1;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeanBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("------------Before Log----------");
		System.out.println("�޼����� �̸�:"+method.getName());
		System.out.println("����Ÿ��:"+method.getReturnType());
		System.out.println("Target�� �ּ�"+target.getClass().getName());
		
		//Object[] args��  �Ű�������
		String idv=(String)args[0];
		System.out.println("id:"+idv);
		System.out.println("classname:"+args[1]);
		System.out.println("end=======");
	}
	

}
