package com.example.template;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateApplication {
	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
//		PostgreSQLDemo postgreSQLDemo = new PostgreSQLDemo();
//		postgreSQLDemo.testconnection();
//		PgpoolMemqcacheTest pgpoolMemqcacheTest = new PgpoolMemqcacheTest();
//		pgpoolMemqcacheTest.test();
	}

}
