package ru.dc.ecom.example;

import jakarta.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ExampleApplicationTests {
	@Resource
	protected ApplicationContext appContext;

	@Test
	public void loadApplicationContextSuccess() {
		assertNotNull(appContext, "Application context must not be null");
	}

	@Test
	public void loadApplicationBeanSuccess() {
		ProductApplication app = appContext.getBean(ProductApplication.class);
		assertNotNull(app, "Application Bean must not be null");
	}
}