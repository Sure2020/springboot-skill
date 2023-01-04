package com.example.spring_cloud_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Predicate;
//https://springboot.io/t/topic/3496
//https://www.cnblogs.com/rude3knife/p/springcloud_gateway.html
@SpringBootApplication
public class SpringCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
	}
	/**
	 * 读取body断言需要注册bodyPredicate
	 * @return
	 */
	/*@Bean
	public Predicate bodyPredicate(){
		return o -> true;
	}*/

}
