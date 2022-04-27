package com.sj.boot3.aop;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void bus() {
		System.out.println("버스타기");
	}
	
	public void subway() {
		System.out.println("지하철타기");
	}
}
