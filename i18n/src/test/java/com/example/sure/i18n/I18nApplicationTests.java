package com.example.sure.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

@SpringBootTest
class I18nApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MessageSource messageSource;

	@Test
	public void testGetMessage() {
		System.out.println(
				messageSource.getMessage(
						"hello", new Object[]{"wfs"},
						"defaultMessage", Locale.US));
	}

}
