package aop.ex0_1;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;


public class MyAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("�ż�������-----afterlog-----");
		System.out.println("Method :"+method.getReturnType());
		System.out.println("Return:"+returnValue.toString());
		System.out.println("classname"+args[0]);
	}

}
