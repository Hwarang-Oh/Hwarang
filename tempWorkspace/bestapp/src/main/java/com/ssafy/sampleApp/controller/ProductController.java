package com.ssafy.sampleApp.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.sampleApp.model.dto.Product;
import com.ssafy.sampleApp.model.service.ProductService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping("/list")
	public String select(
			@RequestParam(name = "searchDate", required = false) String dateString, 
			Model model
	) {
		System.out.println(productService.select(dateString));
		model.addAttribute("products", productService.select(dateString));
		return "list";
	}
	
	@PostMapping
	public String regist(
			Product product
	) {
		System.out.println(product);
		productService.insert(product);
		return "list";
	}
}
