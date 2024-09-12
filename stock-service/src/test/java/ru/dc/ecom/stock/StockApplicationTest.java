package ru.dc.ecom.stock;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StockApplicationTest {
    @Resource
    protected ApplicationContext appContext;

    @Test
    public void loadApplicationContextSuccess() {
        assertNotNull(appContext, "Application context must not be null");
    }

    @Test
    public void loadApplicationBeanSuccess() {
        StockApplication app = appContext.getBean(StockApplication.class);
        assertNotNull(app, "Application Bean must not be null");
    }
}
