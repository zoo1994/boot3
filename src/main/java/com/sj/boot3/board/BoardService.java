package com.sj.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sj.boot3.util.FileManager;
import com.sj.boot3.util.Pager;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private BoardFilesMapper boardFilesMapper;
	
	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO)throws Exception{
		return boardFilesMapper.getFileDetail(boardFilesVO);
	}
	
	public List<BoardFilesVO> getFileList(BoardVO boardVO)throws Exception{
		return boardFilesMapper.getFileList(boardVO);
	}
	
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardMapper.totalPage(pager));
		return boardMapper.getList(pager);
	}

	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		return boardMapper.getDetail(boardVO);		 
	}

	public int setAdd(BoardVO boardVO,MultipartFile[] files) throws Exception {
		int result = boardMapper.setAdd(boardVO);
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) {
				continue;
			}
			//1. file을 hdd에 저장
			String fileName= fileManager.fileSava(mf, "resources/upload/board/");
			//2. 저장된 정보를 db에 저장
			BoardFilesVO boardFilesVO = new BoardFilesVO();
			boardFilesVO.setNum(boardVO.getNum());
			boardFilesVO.setFileName(fileName);
			boardFilesVO.setOriName(mf.getOriginalFilename());
			boardFilesMapper.setFileAdd(boardFilesVO);	
		}
		
		return result;
	}

	public int setUpdate(BoardVO boardVO) throws Exception {
		return boardMapper.setUpdate(boardVO);
	}

	public int setDelete(BoardVO boardVO) throws Exception {
		List<BoardFilesVO> ar = boardFilesMapper.getFileList(boardVO);
		int result = boardMapper.setDelete(boardVO);
		if(result>0) {
			for(BoardFilesVO vo : ar) {
				boolean check = fileManager.remove("resources/upload/board/",vo.getFileName());
			}
		}
		return result;
	}
}
