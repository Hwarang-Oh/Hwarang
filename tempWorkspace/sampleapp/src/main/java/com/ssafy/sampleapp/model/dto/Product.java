package com.ssafy.sampleapp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String code;
    private String model;
    private int price;
    private String id;
    private String regist_date;
    private String detail;

    public Product() {
    }

    public Product(String code, String model, int price, String id, String regist_date, String detail) {
        this.code = code;
        this.model = model;
        this.price = price;
        this.id = id;
        this.regist_date = regist_date;
        this.detail = detail;
    }
}
