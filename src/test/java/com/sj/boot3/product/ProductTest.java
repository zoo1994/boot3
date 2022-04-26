package com.sj.boot3.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sj.boot3.util.Pager;
@SpringBootTest
class ProductTest {
	@Autowired
	private ProductMapper productMapper;
	
	//@Test
	public void getTotalTest()throws Exception{
		int result = productMapper.getTotal();
		assertEquals(4, result);
	}
	
	//@Test
	public void setAddTest()throws Exception{
	
		for(int i = 0 ; i<100 ; i++) {
			if(i%10==0) {
				Thread.sleep(1000);
			}
			ProductVO productVO = new ProductVO();
			productVO.setProductName("Name"+i);
			productVO.setProductCount(1L);
			productVO.setProductPrice(1000L);
			productVO.setProductDetail("Detail"+i);
			int result = productMapper.setAdd(productVO);
		}
	
		//assertEquals(1, result);
	}
	
	//@Test
	public void getListTest()throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<ProductVO>ar  = productMapper.getList(pager);
		assertEquals(2, ar.size());
	}

}
