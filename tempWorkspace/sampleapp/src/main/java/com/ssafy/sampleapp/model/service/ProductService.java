package com.ssafy.sampleapp.model.service;

import java.util.List;

import com.ssafy.sampleapp.model.dto.Product;

public interface ProductService {

    boolean register(Product product);

    boolean modify(Product product);

    boolean remove(String code);

    Product get(String code);

    List<Product> getByDate(String date);

    List<Product> getAll();
}
