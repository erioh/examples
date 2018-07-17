package org.demenkov.apacheintegration.spring.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RandomValueBean {
    @Value("${random.text}")
    private String text;

    @PostConstruct
    public void init() {
        System.out.println("Start random");
        System.out.println(text);
        System.out.println("Finish random");
    }
}
