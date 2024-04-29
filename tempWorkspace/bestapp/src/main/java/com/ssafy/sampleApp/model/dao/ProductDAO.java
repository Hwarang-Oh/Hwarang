package com.ssafy.sampleApp.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.sampleApp.model.dto.Product;

@Mapper
public interface ProductDAO {
	public List<Product> selectAll();
	
	public Product select(int id);
	
	public void insert(Product product);
	
	public void delete(int id);
	
	public void update(Product product);
	
	public List<Product> select(String date);
}
