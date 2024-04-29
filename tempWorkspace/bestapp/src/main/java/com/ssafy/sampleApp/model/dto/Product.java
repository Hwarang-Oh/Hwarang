package com.ssafy.sampleApp.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class Product {
	String code;
	String model;
	int price;
	String id;
	Date regist_date;
	String detail;
}
