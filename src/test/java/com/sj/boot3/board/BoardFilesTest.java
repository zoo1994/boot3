package com.sj.boot3.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class BoardFilesTest {
	
	@Autowired
	private BoardFilesMapper boardFilesMapper;
	
	//@Test
	void detailTest() throws Exception {
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileNum(2L);
		boardFilesVO = boardFilesMapper.getFileDetail(boardFilesVO);
		System.out.println(boardFilesVO.toString());
		assertNotNull(boardFilesVO);
	}
	
	//@Test
	public void getLiatTest()throws Exception{
		//List<BoardFilesVO> ar = boardFilesMapper.getFileList();
		//assertNotEquals(0,ar);
	}
	//@Test
	public void setAddTest()throws Exception{
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileName("addtest");
		boardFilesVO.setOriName("addtest");
		boardFilesVO.setNum(3L);
		int result = boardFilesMapper.setFileAdd(boardFilesVO);
		assertEquals(1, result);
	}

	//@Test
	public void setDeleteTest()throws Exception{
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileNum(2L);
		int result = boardFilesMapper.setFileDelete(boardFilesVO);
		assertEquals(1, result);
	}


}
