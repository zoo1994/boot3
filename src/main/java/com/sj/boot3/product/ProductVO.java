package com.sj.boot3.product;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProductVO {
	private Long productNum;
	@NotBlank
	private String productName;
	@Size(min=100)
	private Long productPrice;
	@Size(min=1,max=1000)
	private Long productCount;
	@NotBlank
	private String productDetail;
	@NotBlank
	private Long productSale;
	private String id;
	private List<ProductFilesVO> filesVO;
}
