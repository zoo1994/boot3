package com.sj.boot3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Payment {
	
	@Around("execution(* com.sj.boot3.aop.Transfer.*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint)throws Throwable {
		System.out.println("탑승 전 카드 체크");
		Object obj =  joinPoint.proceed();
		//obj는 핵심로직 메서드가 리턴하는 data
		System.out.println("탑승 후 카드 체크");
		return obj;
	}
	
	@Before("execution(* com.sj.boot3.board.BoardService.get*(..))")
	public void info() {
		System.out.println("=====select=====");
	}
	
	@AfterReturning("execution(* com.sj.boot3.board.BoardService.get*(..))")
	public void afterReutrning() {
		System.out.println("=====afterReturning=====");
	}
	
	@AfterThrowing("execution(* com.sj.boot3.board.BoardService.get*(..))")
	public void afterThrowing() {
		System.out.println("=====afterThrowing=====");
	}
	@After("execution(* com.sj.boot3.board.BoardService.get*(..))")
	public void after() {
		System.out.println("=====after=====");
	}
	
//	@Around("execution(* com.sj.boot3.board.BoardService.get*(..))")
//	public void around() {
//		System.out.println("=====after=====");
//	}


}
