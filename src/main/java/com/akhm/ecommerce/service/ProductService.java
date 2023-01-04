package com.akhm.ecommerce.service;

import java.util.List;

import com.akhm.ecommerce.service.dto.ProductDTO;



public interface ProductService {
	public Integer insertProduct(ProductDTO productDTO);
	List<ProductDTO> getProducts();

}
