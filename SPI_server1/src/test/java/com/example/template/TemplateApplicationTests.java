package com.example.template;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ServiceLoader;

@SpringBootTest
class TemplateApplicationTests {

	@Test
	void contextLoads() {
		testWay();
	}
	public void testWay(){
		// 传入接口作为参数，返回解析到的实现类
		ServiceLoader<SpiTestDemo> serviceLoader = ServiceLoader.load(SpiTestDemo.class);
		// 不同的实现类，有不同的逻辑
		for(SpiTestDemo spiTestDemo : serviceLoader){
			spiTestDemo.way1();
			spiTestDemo.way2();
		}
	}

}
