package com.ssafy.sampleapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ssafy.sampleapp.model.dao")
@SpringBootApplication
public class SampleappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleappApplication.class, args);
	}
}
