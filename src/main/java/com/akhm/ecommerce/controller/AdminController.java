package com.akhm.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.akhm.ecommerce.service.AdminService;
import com.akhm.ecommerce.service.ProductService;
import com.akhm.ecommerce.service.ProductTypeService;
import com.akhm.ecommerce.service.dto.AdminDTO;
import com.akhm.ecommerce.service.dto.ProductDTO;
import com.akhm.ecommerce.service.dto.ProductTypeDTO;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private ProductTypeService productTypeService;
	@Autowired
	private ProductService productService;

	
	@GetMapping("/adminlogin")
	public String showLogin()
	{
		return "adminlogin";
	}

	@PostMapping("adminlogin")
	public String submitLogin(HttpServletRequest request, @RequestBody AdminDTO adminDTO) {
		try {
			if (adminDTO != null) {
				
				AdminDTO admin = adminService.loadAdmin(adminDTO);
				if (admin != null) {
					
					HttpSession session = request.getSession(true);
					session.setAttribute("AUTH_ADMIN", adminDTO);
					return "redirect:adminhome";
				} else {
					request.setAttribute("ErrorMessege", "Invalid userName or passsword");
				}
			}

		} catch (Exception e) {
			request.setAttribute("ErrorMessege", "some thing wrong plz try again later");

		}
		return "adminlogin";
	}

	@GetMapping("/adminhome")
	public String adminHome(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AdminDTO admin = (AdminDTO) session.getAttribute("AUTH_ADMIN");
			if (admin != null) {
				return "adminHome";
			} else {
				return "redirect:adminlogin?errorMessege=session expired";
			} 
		} else {
			return "redirect:adminlogin?errorMessage=please login";
		}
	}

	@GetMapping("/addproducttype")
	public String showAddProductType(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AdminDTO admin = (AdminDTO) session.getAttribute("AUTH_ADMIN");
			if (admin != null) 
			{
				
				return "addproducttype";
			} 
			else 
			{
				return "redirect:adminlogin?errorMessege=session expired";
			} 
		} 
		else 
		{
			return "redirect:adminlogin?errorMessage=please login";
		}
		
	}

	@GetMapping("/producttype")
	public String productypes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AdminDTO admin = (AdminDTO) session.getAttribute("AUTH_ADMIN");
			if (admin != null)
			{
				List<ProductTypeDTO> productTypes=productTypeService.getProductypes();
				request.setAttribute("productTypes", productTypes);
				return "producttypes";
			}
			else
			{
				return "redirect:adminlogin?errorMessege=session expired";
			}
		} 
		else
		{
			return "redirect:adminlogin?errorMessage=please login";
		}
	}
	@PostMapping("/addproducttype")
	public String addProductType(HttpServletRequest request,ProductTypeDTO productTypeDTO) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AdminDTO admin = (AdminDTO) session.getAttribute("AUTH_ADMIN");
			if (admin != null) 
			{
				Integer productTypeId=productTypeService.insertProductType(productTypeDTO);
			
				if(productTypeId!=null&&productTypeId>0)
				{
					return "redirect:adminproducttypes";
				}
				else
				{
					return "addproducttype";
				}
				
			} 
			else 
			{
				return "redirect:adminlogin?errorMessege=session expired";
			} 
		} 
		else 
		{
			return "redirect:adminlogin?errorMessage=please login";
		}
		
	}
	@GetMapping("/addproduct")
	public String showAddProduct(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AdminDTO admin = (AdminDTO) session.getAttribute("AUTH_ADMIN");
			if (admin != null) 
			{
				
				return "addproduct";
			} 
			else 
			{
				return "redirect:adminlogin?errorMessege=session expired";
			} 
		} 
		else 
		{
			return "redirect:adminlogin?errorMessage=please login";
		}
		
	}

	@GetMapping("/product")
	public String products(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AdminDTO admin = (AdminDTO) session.getAttribute("AUTH_ADMIN");
			if (admin != null)
			{
				List<ProductDTO> products=productService.getProducts();
				request.setAttribute("products", products);
				return "products";
			}
			else
			{
				return "redirect:adminlogin?errorMessege=session expired";
			}
		} 
		else
		{
			return "redirect:adminlogin?errorMessage=please login";
		}
	}
	@PostMapping("/addproduct")
	public String addProduct(HttpServletRequest request,ProductDTO productDTO) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AdminDTO admin = (AdminDTO) session.getAttribute("AUTH_ADMIN");
			if (admin != null) 
			{
				Integer productId=productService.insertProduct(productDTO);
			
				if(productId!=null&&productId>0)
				{
					return "redirect:adminproducts";
				}
				else
				{
					return "addproduct";
				}
				
			} 
			else 
			{
				return "redirect:adminlogin?errorMessege=session expired";
			} 
		} 
		else 
		{
			return "redirect:adminlogin?errorMessage=please login";
		}
		

	
	}

}
