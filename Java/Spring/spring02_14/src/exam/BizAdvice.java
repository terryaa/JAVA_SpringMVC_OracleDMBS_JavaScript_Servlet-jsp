package exam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import aop.ex1.MyPublic;
//<aop:config>��, ProxyFactoryBean����
@Aspect
public class BizAdvice {
	@Autowired
	private LoginTest logintest;
	
//	@Before("execution(* exam.SecurityImple.*(..))")
//	public void beforeToday(JoinPoint jp) {
//		if(logintest.isRes()==true)
//			System.out.println("�����Ϸ�");
//		else
//			System.out.println("������ �����ϼ̽��ϴ�.");
//	}
//	
	@Around("execution(* exam.SecurityImple.*(..))")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		if(logintest.isRes()==true)
		{
			System.out.println("�����Ϸ�");
			joinPoint.proceed();
		}
		
		else {
			System.out.println("������ �����ϼ̽��ϴ�.");
		}
		return new Object();
	}
	
	
	
	
}
