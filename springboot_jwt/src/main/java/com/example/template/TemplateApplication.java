package com.example.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//参考 https://blog.csdn.net/CSDN2497242041/article/details/115605626
@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.template.filter")
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}

}
