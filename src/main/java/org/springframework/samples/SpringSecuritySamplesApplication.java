package org.springframework.samples;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.springframework.samples.mapper")
public class SpringSecuritySamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecuritySamplesApplication.class, args);
    }

}
