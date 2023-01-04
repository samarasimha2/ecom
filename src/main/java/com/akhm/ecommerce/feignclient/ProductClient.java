package com.akhm.ecommerce.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.akhm.ecommerce.service.dto.ProductDTO;
import com.akhm.ecommerce.service.dto.ProductTypeDTO;
@FeignClient(name="http://localhost:8088/")
public interface ProductClient {
	@PostMapping("/insertproduct")
	public Integer saveProduct(ProductDTO productDTO);
	@GetMapping("/products")
	public List<ProductDTO> loadProducts();

}
