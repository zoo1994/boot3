package com.sj.boot3.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sj.boot3.util.Pager;


@Mapper
public interface BoardMapper {
	
	public Integer totalPage(Pager pager)throws Exception;
	
	public BoardVO getDetail(BoardVO boardVO)throws Exception;
	
	public List<BoardVO> getList(Pager pager)throws Exception;
	
	public int setAdd(BoardVO boardVO)throws Exception;
	
	public int setUpdate(BoardVO boardVO)throws Exception;
	
	public int setDelete(BoardVO boardVO)throws Exception;
	
}
