package com.sj.boot3.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardFilesMapper {
	
	public int setFileAdd(BoardFilesVO boardFilesVO) throws Exception;
	
	public int setFileDelete(BoardFilesVO boardFilesVO) throws Exception;
	
	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception;
	
	public List<BoardFilesVO> getFileList(BoardVO boardVO)throws Exception;
}
