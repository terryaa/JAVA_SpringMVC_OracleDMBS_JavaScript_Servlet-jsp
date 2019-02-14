package aop.ex1;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class TodayBeforeAdvice {
	@Autowired
	private MyPublic myPublic;
	
	public void beforeToday(JoinPoint jp) {
		System.out.println(myPublic.todayMethod());
	}
}
