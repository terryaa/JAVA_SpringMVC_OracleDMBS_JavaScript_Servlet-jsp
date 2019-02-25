package kr.or.kosta.mvc.controller2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
@Component
@Aspect
public class TodayAdvice {
	@Before("execution(* kr.or.kosta.mvc.controller2.*.today*(..))")
	public void todayMessage(JoinPoint pjp) throws Throwable {
		Object[] test=pjp.getArgs();
		if(test[0] instanceof Model) {
			Model m=(Model) test[0];
			m.addAttribute("today",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			
		}
		
		
		//pjp.proceed();
	}
}
