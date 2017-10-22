package demo;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("cloud")
public class CloudDataSourceConfiguration {

    @Bean
    public Cloud cloud() {
        return new CloudFactory().getCloud();
    }

    /**
     * With the use of the @ConfigurationProperties you can bind additional configuration to the DataSource
     * to tweak connection pool properties and things like that if you need to in production.
     */
    @Bean
    @ConfigurationProperties(DataSourceProperties.PREFIX)
    public DataSource dataSource() {
        return cloud().getSingletonServiceConnector(DataSource.class, null);
    }
}
