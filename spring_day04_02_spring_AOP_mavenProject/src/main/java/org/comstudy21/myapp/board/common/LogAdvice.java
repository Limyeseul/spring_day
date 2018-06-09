package org.comstudy21.myapp.board.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect   // Aspect = Pointcut + Advice
public class LogAdvice {
	@Pointcut("execution(* org.comstudy21.myapp.board..*Impl.*(..))")
	public void allPointcut(){}
	
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[공통] 비즈니스 로직 수행 전~");
	}
}
