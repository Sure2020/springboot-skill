package com.example.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

// 用另一个种更简单的方式实现mongo多数据源，参考自成都acpool项目
@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}

}
