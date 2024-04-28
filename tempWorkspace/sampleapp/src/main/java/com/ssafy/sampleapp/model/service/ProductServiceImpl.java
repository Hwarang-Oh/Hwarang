package com.ssafy.sampleapp.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sampleapp.model.dao.ProductDao;
import com.ssafy.sampleapp.model.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) throws Exception {
        this.productDao = productDao;
    }

    @Override
    public Product get(String code) throws Exception {
        return productDao.select(code);
    }

    @Override
    public boolean register(Product product) throws Exception {
        if (productDao.select(product.getCode()) == null) {
            return productDao.insert(product) > 0;
        } else
            return productDao.update(product) > 0;
    }

    @Override
    public boolean modify(Product product) throws Exception {
        return productDao.update(product) > 0;
    }

    @Override
    public boolean remove(String code) throws Exception {
        return productDao.delete(code) > 0;
    }

    @Override
    public List<Product> getByDate(String date) throws Exception {
        return productDao.selectByDate(date);
    }

    @Override
    public List<Product> getAll() throws Exception {
        return productDao.selectAll();
    }

}
