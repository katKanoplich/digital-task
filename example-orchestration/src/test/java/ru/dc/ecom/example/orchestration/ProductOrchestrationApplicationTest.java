package ru.dc.ecom.example.orchestration;

import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductOrchestrationApplicationTest {

    @Resource
    protected ApplicationContext appContext;

    @Test
    public void loadApplicationContextSuccess() {
        assertNotNull(appContext, "Application context must not be null");
    }

    @Test
    public void loadApplicationBeanSuccess() {
        ProductOrchestrationApplication app = appContext.getBean(ProductOrchestrationApplication.class);
        assertNotNull(app, "Application Bean must not be null");
    }

}
