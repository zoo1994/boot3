package com.sj.boot3.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sj.boot3.member.MemberVO;
import com.sj.boot3.util.Pager;

@Mapper
public interface ProductMapper {
	
	public int setUpdate(ProductVO productVO)throws Exception;
	public int fileDelete(ProductFilesVO productFilesVO)throws Exception;
	public int getTotal(Pager pager)throws Exception;
	public int setAdd(ProductVO productVO)throws Exception;
	public int addFile(ProductFilesVO productFilesVO)throws Exception;
	public ProductVO getDetail(ProductVO productVO)throws Exception;
	public List<ProductVO> getList(Pager pager)throws Exception;
	public List<ProductVO> getListManage(Pager pager)throws Exception;
	public List<ProductFilesVO> fileList(ProductVO productVO)throws Exception;
}
