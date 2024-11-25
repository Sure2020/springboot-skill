package com.example.template;

import com.example.template.testtdengine.TDengineConnectDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
		TDengineConnectDemo tDengineConnectDemo = new TDengineConnectDemo();
		tDengineConnectDemo.test();
	}

}
