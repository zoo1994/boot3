package com.sj.boot3.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sj.boot3.util.FileManager;
import com.sj.boot3.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private FileManager fileManager;

	@Autowired
	private BoardFilesMapper boardFilesMapper;

	public boolean summerFileDelete(String fileName)throws Exception{
		fileName= fileName.substring(fileName.lastIndexOf("/")+1);
		return fileManager.remove(fileName, "/resources/upload/board/");
		
		
	}
	
	public String setSummerFileUpload(MultipartFile files) throws Exception {
		String fileName="";
		if(!files.isEmpty()) {
			fileName = fileManager.fileSave(files, "resources/upload/board/");
		}
		fileName="/resources/upload/board/"+fileName;
		return fileName;
	}

	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception {
		return boardFilesMapper.getFileDetail(boardFilesVO);
	}

	public List<BoardFilesVO> getFileList(BoardVO boardVO) throws Exception {
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

	public int setAdd(BoardVO boardVO, MultipartFile[] files) throws Exception {
		int result = boardMapper.setAdd(boardVO);
		for (MultipartFile mf : files) {
			if (files != null && result > 0) {
				if (mf.isEmpty()) {
					continue;
				}
				// 1. file을 hdd에 저장
				String fileName = fileManager.fileSave(mf, "resources/upload/board/");
				// 2. 저장된 정보를 db에 저장
				BoardFilesVO boardFilesVO = new BoardFilesVO();
				boardFilesVO.setNum(boardVO.getNum());
				boardFilesVO.setFileName(fileName);
				boardFilesVO.setOriName(mf.getOriginalFilename());
				int result1 = boardFilesMapper.setFileAdd(boardFilesVO);
				if (result1 < 1) {
					// boardtable insert한것도 rollback
					throw new SQLException();
				}
			}
		}

		return result;
	}

	public int setUpdate(BoardVO boardVO) throws Exception {
		return boardMapper.setUpdate(boardVO);
	}

	public int setDelete(BoardVO boardVO) throws Exception {
		List<BoardFilesVO> ar = boardFilesMapper.getFileList(boardVO);
		int result = boardMapper.setDelete(boardVO);
		if (result > 0) {
			for (BoardFilesVO vo : ar) {
				boolean check = fileManager.remove("resources/upload/board/", vo.getFileName());
			}
		}
		return result;
	}
}
