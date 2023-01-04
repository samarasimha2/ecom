package com.akhm.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akhm.ecommerce.service.dto.ProductTypeDTO;

public interface ProductTypeService {
	
	public Integer insertProductType(ProductTypeDTO productTypeDTO);
	public List<ProductTypeDTO> getProductypes();
}
