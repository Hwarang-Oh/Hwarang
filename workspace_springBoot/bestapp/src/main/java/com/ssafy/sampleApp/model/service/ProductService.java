package com.ssafy.sampleApp.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sampleApp.model.dao.ProductDAO;
import com.ssafy.sampleApp.model.dto.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductDAO productDAO;
	
	public List<Product> select(String date) {
		return productDAO.select(date);
	}
	
	public void insert(Product product) {
		productDAO.insert(product);
	}
}
