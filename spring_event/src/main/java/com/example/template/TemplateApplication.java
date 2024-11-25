package com.example.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * https://www.shell101.com/framework/springboot/sprongboot%E4%BA%8B%E4%BB%B6%E7%9B%91%E5%90%AC%E5%AE%9E%E8%B7%B5.html
 */
@EnableAsync
@SpringBootApplication
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}

}
