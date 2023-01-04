package com.akhm.ecommerce.service;

import org.springframework.stereotype.Service;

import com.akhm.ecommerce.service.dto.AdminDTO;
@Service
public interface AdminService {
	public AdminDTO loadAdmin(AdminDTO adminDTO);

}
