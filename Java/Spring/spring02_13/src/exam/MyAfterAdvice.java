package exam;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;



public class MyAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		if(args[0].equals("1234"))
			System.out.println("¹«±â°¡ È²±ÝÀ¸·Î ºû³³´Ï´Ù...±Ýºû..");
		else
			System.out.print("±×³É");
	}

}
