package com.akhm.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.akhm.ecommerce.feignclient.ProductTypeClient;
import com.akhm.ecommerce.service.ProductTypeService;
import com.akhm.ecommerce.service.dto.ProductTypeDTO;

public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired
	private ProductTypeClient productTypeClient;

	@Override
	public Integer insertProductType(ProductTypeDTO productTypeDTO) {
		
		return productTypeClient.saveProductType(productTypeDTO);
	}

	@Override
	public List<ProductTypeDTO> getProductypes() {
		
		return productTypeClient.loadProducttypes();
	}

}
