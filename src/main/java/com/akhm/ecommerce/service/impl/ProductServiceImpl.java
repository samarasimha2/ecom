package com.akhm.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.akhm.ecommerce.feignclient.ProductClient;
import com.akhm.ecommerce.service.ProductService;
import com.akhm.ecommerce.service.dto.ProductDTO;

public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductClient productClient;

	@Override
	public Integer insertProduct(ProductDTO productDTO) {
		
		return productClient.saveProduct(productDTO);
	}

	@Override
	public List<ProductDTO> getProducts() {
		
		return productClient.loadProducts();
	}

}
