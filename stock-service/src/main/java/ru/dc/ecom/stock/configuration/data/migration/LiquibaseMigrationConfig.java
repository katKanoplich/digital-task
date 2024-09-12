package ru.dc.ecom.stock.configuration.data.migration;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseMigrationConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.liquibase")
    public LiquibaseProperties exampleLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public SpringLiquibase exampleLiquibase(DataSource dataSource) {
        return springLiquibase(exampleLiquibaseProperties(), dataSource);
    }

    private static SpringLiquibase springLiquibase(LiquibaseProperties properties, DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());
        liquibase.setContexts(properties.getContexts());
        liquibase.setDefaultSchema(properties.getDefaultSchema());
        liquibase.setShouldRun(properties.isEnabled());
        return liquibase;
    }
}
