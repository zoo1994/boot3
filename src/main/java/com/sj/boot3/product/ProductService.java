package com.sj.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sj.boot3.util.FileManager;
import com.sj.boot3.util.Pager;

@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FileManager fileManager;
	
	public int setAdd(ProductVO productVO,MultipartFile[] files)throws Exception{
		int result = productMapper.setAdd(productVO);
		if(files!=null) {
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSava(mf, "resources/upload/product/");
			ProductFilesVO pf = new ProductFilesVO();
			pf.setProductNum(productVO.getProductNum());
			pf.setFileName(fileName);
			pf.setOriName(mf.getOriginalFilename());
			int rusult2 = productMapper.addFile(pf);
		
		}}
		return result;
	}
	
	
	public List<ProductVO> getList(Pager pager)throws Exception{
		pager.makeRow();
		pager.makePage(productMapper.getTotal());
		return productMapper.getList(pager);
	}
	
	public List<ProductFilesVO> fileList(ProductVO productVO)throws Exception{
		return productMapper.fileList(productVO);
	}
}
