package com.example.mapstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapstructApplication {

	// run 之前需要执行一下 maven clean，原因未知
	public static void main(String[] args) {
		SpringApplication.run(MapstructApplication.class, args);
	}

}
