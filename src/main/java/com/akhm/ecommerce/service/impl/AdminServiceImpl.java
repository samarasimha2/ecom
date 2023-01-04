package com.akhm.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.ecommerce.feignclient.AdminClient;
import com.akhm.ecommerce.service.AdminService;
import com.akhm.ecommerce.service.dto.AdminDTO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminClient adminClient;

	@Override
	public AdminDTO loadAdmin(AdminDTO adminDTO) {
		
		return adminClient.getAdmin(adminDTO);
	}

}
