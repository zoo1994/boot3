package com.sj.boot3.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferService {
	
	@Autowired
	private Transfer transfer;
	
	//private Payment payment;
	
	public void go() {
		
		//payment.cardCheck();
		transfer.bus();
		//payment.cardCheck();
		
		//payment.cardCheck();
		transfer.subway();
		//payment.cardCheck();
		
		//payment.cardCheck();
		transfer.bus();
		//payment.cardCheck();
	}
}
