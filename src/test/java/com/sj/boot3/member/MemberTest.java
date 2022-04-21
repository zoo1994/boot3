package com.sj.boot3.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MemberTest {

	@Autowired
	private MemberMapper memberMapper;
	
	//@Test
	void joinTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testId");
		memberVO.setPw("testPw");
		memberVO.setName("testName");
		memberVO.setPhone("testPhone");
		memberVO.setEmail("testEmail");
		int result = memberMapper.join(memberVO);
		assertEquals(1, result);
	}
	
	//@Test
	void loginTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testId");
		memberVO.setPw("testPw");
		memberVO = memberMapper.login(memberVO);
		assertNotNull(memberVO);
	}
	
	//@Test
	void myPageTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testId");
		memberVO = memberMapper.myPage(memberVO);
		assertNotNull(memberVO);
	}
	
	//@Test
	void updateTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testId");
		memberVO.setPhone("updatePhone");
		memberVO.setEmail("updateEmail");
		int result = memberMapper.update(memberVO);
		assertEquals(1, result);
	}
	//@Test
	void deleteTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testId");
		int result = memberMapper.delete(memberVO);
		assertEquals(1, result);
	}
	

}
