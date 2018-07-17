package org.demenkov.apacheintegration.spring.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DatasourceConfig {
    @Value("${my.property}")
    private String name;

    @PostConstruct
    public void init() {
        System.out.println(name);
    }
}
