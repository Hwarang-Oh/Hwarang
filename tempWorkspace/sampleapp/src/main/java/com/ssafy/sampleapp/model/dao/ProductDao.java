package com.ssafy.sampleapp.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.sampleapp.model.dto.Product;

@Repository
public interface ProductDao {

    // 상품 등록
    int insert(Product product) throws SQLException;

    // 상품 수정
    int update(Product product) throws SQLException;

    // 상품 삭제
    int delete(String code) throws SQLException;

    // 상품 선택
    Product select(String code) throws SQLException;

    // 상품 검색 (ALL)
    List<Product> selectAll() throws SQLException;

    // 상품 날짜별 검색
    List<Product> selectByDate(String date) throws SQLException;

}
