package com.example.template;

import com.example.template.util.ContantFromProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.template.util.Contant.ABC;
import static com.example.template.util.Contant.XYZ;

@SpringBootApplication
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
		System.out.println(ContantFromProperties.getAbc());
		System.out.println(ContantFromProperties.getXyz());
		System.out.println(ABC);
		System.out.println(XYZ);
	}

}
