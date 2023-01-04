package com.akhm.ecommerce.service.dto;

import java.sql.Date;

import lombok.Data;
@Data
public class ProductDTO {
	private Integer productId;
	private Integer productTypeId;
	private String productName;
	private String productDescription;
	private Double productPrice;
	private Date productManufactureDate;
	private Date productExpiryDate;
	private String productStatus;

}
