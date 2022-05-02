package com.sj.boot3.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sj.boot3.member.MemberVO;
import com.sj.boot3.util.FileManager;
import com.sj.boot3.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FileManager fileManager;

	public int setUpdate(ProductVO productVO, MultipartFile[] files) throws Exception {
		if (files != null) {
			for (MultipartFile mf : files) {
				if (!mf.isEmpty()) {
					ProductFilesVO file = new ProductFilesVO();
					String fileName = fileManager.fileSave(mf, "resources/upload/product/");
					file.setFileName(fileName);
					file.setOriName(mf.getOriginalFilename());
					file.setProductNum(productVO.getProductNum());
					productMapper.addFile(file);
				}
			}
		}

		return productMapper.setUpdate(productVO);
	}

	public int fileDelete(ProductFilesVO productFilesVO) throws Exception {
		String fileName = productFilesVO.getFileName();
		int result = productMapper.fileDelete(productFilesVO);
		if (result > 0) {
			fileManager.remove("resources/upload/product/", fileName);
		}
		return result;
	}

	public ProductVO getDetail(ProductVO productVO) throws Exception {
		return productMapper.getDetail(productVO);
	}

	public int setAdd(ProductVO productVO, MultipartFile[] files) throws Exception {
		int result = productMapper.setAdd(productVO);
		if (files != null) {
			for (MultipartFile mf : files) {
				if (mf.isEmpty()) {
					continue;
				}
				String fileName = fileManager.fileSave(mf, "resources/upload/product/");
				ProductFilesVO pf = new ProductFilesVO();
				pf.setProductNum(productVO.getProductNum());
				pf.setFileName(fileName);
				pf.setOriName(mf.getOriginalFilename());
				int rusult2 = productMapper.addFile(pf);

			}
		}
		return result;
	}

	public List<ProductVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(productMapper.getTotal(pager));
		return productMapper.getList(pager);
	}

	public List<ProductVO> getListManage(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(productMapper.getTotal(pager));
		return productMapper.getListManage(pager);
	}

	public List<ProductFilesVO> fileList(ProductVO productVO) throws Exception {
		return productMapper.fileList(productVO);
	}
}
