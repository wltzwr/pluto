package org.freemason.pluto.consumer;


import org.freemason.pluto.pluto.common.annotation.ReferenceScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@ReferenceScan(basePackages = "org.freemason.pluto.consumer")
public class Test {
    public static void main(String[] args) {
        new SpringApplication(Test.class).run(args);
    }
}
