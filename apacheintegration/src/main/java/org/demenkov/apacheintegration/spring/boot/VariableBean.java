package org.demenkov.apacheintegration.spring.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class VariableBean {

    @Value("${text.value}")
    private String text;

    @PostConstruct
    public void init() {
        System.out.println(text);
    }
}
