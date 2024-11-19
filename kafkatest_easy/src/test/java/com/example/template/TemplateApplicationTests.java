package com.example.template;

import com.example.template.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Clock;

//@SpringBootTest
//class TemplateApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateApplicationTests {

	@Autowired
	private KafkaProducer kafkaProducer;

	private Clock clock = Clock.systemDefaultZone();
	private long begin;
	private long end;

	@Before
	public void init(){


		begin = clock.millis();
	}

	@Test
	public void send(){
		kafkaProducer.sendADotaHero();
	}

	@After
	public void end(){
		end = clock.millis();
		log.info("Spend {} millis .", end-begin);
	}

}
