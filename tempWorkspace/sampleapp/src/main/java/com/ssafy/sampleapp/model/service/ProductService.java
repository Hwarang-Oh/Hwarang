package com.ssafy.sampleapp.model.service;

import java.util.List;

import com.ssafy.sampleapp.model.dto.Product;

public interface ProductService {

    boolean register(Product product) throws Exception;

    boolean modify(Product product) throws Exception;

    boolean remove(String code) throws Exception;

    Product get(String code) throws Exception;

    List<Product> getByDate(String date) throws Exception;

    List<Product> getAll() throws Exception;
}
