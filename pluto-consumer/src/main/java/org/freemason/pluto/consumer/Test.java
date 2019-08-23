package org.freemason.pluto.consumer;


import org.freemason.pluto.common.annotation.ReferenceScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.freemason")
@SpringBootApplication
@ReferenceScan(basePackages = "org.freemason.pluto.consumer")
public class Test{
    public static void main(String[] args) {
        new SpringApplication(Test.class).run(args);
    }
}
