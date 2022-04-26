package com.sj.boot3.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String start()throws Exception{
		return "index";
	}
	
	@GetMapping("/getTest")
	public String getTest(String msg)throws Exception {
		System.out.println("GetTest 요청 발생");
		System.out.println("msg = "+msg);
		return "common/getResult";
	}
	
	@PostMapping("/getTest")
	public String postTest(String msg)throws Exception {
		System.out.println("PostTest 요청 발생");
		System.out.println("msg = "+msg);
		return "common/getResult";
	}
	
	@PostMapping("/arrayTest")
	public String arrayTest(String msg,String[]checkBox)throws Exception {
		System.out.println("PostTest 요청 발생");
		System.out.println("msg = "+msg);
		for(String str : checkBox) {
			System.out.println(str);
		}
		return "common/getResult";
	}
	
	
}
