package com.sj.boot3.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sj.boot3.util.Pager;

@Mapper
public interface ProductMapper {
	
	public int getTotal()throws Exception;
	public int setAdd(ProductVO productVO)throws Exception;
	public int addFile(ProductFilesVO productFilesVO)throws Exception;
	public List<ProductVO> getList(Pager pager)throws Exception;
	public List<ProductFilesVO> fileList(ProductVO productVO)throws Exception;
}
