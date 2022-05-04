package com.sj.boot3.exception;

import java.net.BindException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	//예외처리메서드
	@ExceptionHandler(BindException.class)
	public ModelAndView ex1(Exception e)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("에외발생");
		System.out.println(e.getMessage());
		e.printStackTrace();
		mv.addObject("message","불편 ㅈㅅ");
		mv.addObject("path","../");
		mv.setViewName("common/getResult");
		return mv;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView ex2()throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("에외발생");
		mv.setViewName("error/error");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ex3()throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("에외발생");
		mv.setViewName("error/error");
		return mv;
	}
	
	@ExceptionHandler(Throwable.class)
	public ModelAndView ex4()throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("에외발생");
		mv.setViewName("error/error");
		return mv;
	}
	
	//400
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView ex5()throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("에외발생");
		mv.setViewName("error/error");
		return mv;
	}
}
