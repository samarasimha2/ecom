package com.akhm.ecommerce.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.akhm.ecommerce.service.dto.AdminDTO;

@FeignClient(name="http://localhost:8075/")
public interface AdminClient {
	@PostMapping("adminlogin")
	public AdminDTO getAdmin(AdminDTO adminDTO);

}
