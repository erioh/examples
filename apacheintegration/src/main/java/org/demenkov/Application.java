package org.demenkov;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(Application.class, args);

    }
}
