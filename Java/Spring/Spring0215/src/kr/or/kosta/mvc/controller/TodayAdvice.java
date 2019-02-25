package kr.or.kosta.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Component
@Aspect
public class TodayAdvice {
   @Before("execution(* kr.or.kosta.mvc.controller.*.today*(..))")
   public void beforeAdvice(JoinPoint jp) {
      Object[] fd = jp.getArgs();
      if(fd[0] instanceof Model) {
         Model m = (Model) fd[0];
         m.addAttribute("today",
               new SimpleDateFormat("yyyy-MM-dd")
               .format(new Date()));
      }
   
   }
   @AfterReturning(pointcut="execution(* kr.or.kosta.mvc.controller.*.*noparam*(..))"
         ,returning="msg")
   public void after(JoinPoint jp, Object msg) {
      ModelAndView m=(ModelAndView)msg;
      m.setViewName("msg2");
   }

}