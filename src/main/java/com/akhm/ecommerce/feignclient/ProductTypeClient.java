package com.akhm.ecommerce.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.akhm.ecommerce.service.dto.ProductTypeDTO;
@FeignClient(name="http://localhost:8088/")
public interface ProductTypeClient {
	@PostMapping("/insertproducttype")
	public Integer saveProductType(ProductTypeDTO productTypeDTO);
	@GetMapping("/producttypes")
	public List<ProductTypeDTO> loadProducttypes();
	

}
