package com.sj.boot3.schedule;

import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestSchedule {
	
	//@Scheduled(fixedRate = 1000, initialDelayString = "1000")
	public void fixRateSchedule()throws Exception{
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		Thread.sleep(2000);
	}
	
	//@Scheduled(fixedDelay  = 1000, initialDelayString = "1000")
	public void fixDelaySchedule()throws Exception{
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
	}
	
	@Scheduled(cron="*/5 * * * * *")
	public void cronSchedule()throws Exception{
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
	}
}
