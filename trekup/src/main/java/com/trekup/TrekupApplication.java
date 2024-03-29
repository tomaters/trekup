package com.trekup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.trekup.mapper")
public class TrekupApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TrekupApplication.class, args);
	}
}
