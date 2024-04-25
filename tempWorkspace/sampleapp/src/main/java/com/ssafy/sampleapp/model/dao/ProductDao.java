package com.ssafy.sampleapp.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.sampleapp.model.dto.Product;

@Repository
public interface ProductDao {

    int insert(Product product);

    int update(Product product);

    int delete(String code);

    Product select(String code);

    List<Product> selectByDate(String date);

    List<Product> selectAll();
}
