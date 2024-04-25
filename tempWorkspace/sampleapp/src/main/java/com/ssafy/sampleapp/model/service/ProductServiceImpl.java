package com.ssafy.sampleapp.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sampleapp.model.dao.ProductDao;
import com.ssafy.sampleapp.model.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product get(String code) {
        return productDao.select(code);
    }

    @Override
    public boolean register(Product product) {
        if (productDao.select(product.getCode()) == null) {
            return productDao.insert(product) > 0;
        } else
            return productDao.update(product) > 0;
    }

    @Override
    public boolean modify(Product product) {
        return productDao.update(product) > 0;
    }

    @Override
    public boolean remove(String code) {
        return productDao.delete(code) > 0;
    }

    @Override
    public List<Product> getByDate(String date) {
        return productDao.selectByDate(date);
    }

    @Override
    public List<Product> getAll() {
        return productDao.selectAll();
    }

}
