package com.sj.boot3.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sj.boot3.util.Pager;
@SpringBootTest
class BoardTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//@Test
	void detailTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3L);
		boardVO = boardMapper.getDetail(boardVO);
		System.out.println(boardVO.toString());
		assertNotNull(boardVO);
	}
	
	@Test
	public void getLiatTest()throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardVO> ar = boardMapper.getList(pager);
		assertEquals(10,ar.size());
	}
	//@Test
	public void setAddTest()throws Exception{
		for(int i =0;i<100;i++) {
			if(i%10==0) {
				Thread.sleep(1000);
			}
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("title"+i);
		boardVO.setContents("contents"+i);
		boardVO.setWriter("writer"+i);
		int result = boardMapper.setAdd(boardVO);
		}
		System.out.println("finish");
		//assertEquals(1, result);
	}
	//@Test
	public void setUpdateTest()throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("upest");
		boardVO.setContents("uptest");
		boardVO.setNum(3L);
		int result = boardMapper.setUpdate(boardVO);
		assertEquals(1, result);
	}
	//@Test
	public void setDeleteTest()throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4L);
		int result = boardMapper.setDelete(boardVO);
		assertEquals(1, result);
	}


}
