package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class CloudApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        org.apache.tomcat.jdbc.pool.DataSource tomcat = (org.apache.tomcat.jdbc.pool.DataSource) dataSource;
        System.err.println("Tomcat driver class name: " + tomcat.getDriverClassName() + ", url: " + tomcat.getUrl());
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }
}
