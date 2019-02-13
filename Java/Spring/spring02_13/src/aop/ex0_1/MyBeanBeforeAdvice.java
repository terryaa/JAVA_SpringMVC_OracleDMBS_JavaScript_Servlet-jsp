package aop.ex0_1;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeanBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("------------Before Log----------");
		System.out.println("메서드의 이름:"+method.getName());
		System.out.println("리턴타입:"+method.getReturnType());
		System.out.println("Target의 주소"+target.getClass().getName());
		
		//Object[] args는  매개변수들
		String idv=(String)args[0];
		System.out.println("id:"+idv);
		System.out.println("classname:"+args[1]);
		System.out.println("end=======");
	}
	

}
