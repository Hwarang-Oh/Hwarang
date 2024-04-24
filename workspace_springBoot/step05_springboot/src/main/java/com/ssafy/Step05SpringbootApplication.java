package com.ssafy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ssafy.model.dao")
@SpringBootApplication
public class Step05SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step05SpringbootApplication.class, args);
	}
}
