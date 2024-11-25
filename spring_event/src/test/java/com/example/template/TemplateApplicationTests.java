package com.example.template;

import com.example.template.sync.EventPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplateApplicationTests {

	@Autowired
	private EventPublisher eventPublisher;
//	@Autowired
//	private EventCommonPublisher eventCommonPublisher;

	@Test
	void contextLoads() {
		eventPublisher.publishEvent("Hello！This is a event!");
	}

}
