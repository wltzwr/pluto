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
public class Test implements ApplicationContextAware {
    public static void main(String[] args) {
        new SpringApplication(Test.class).run(args);
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        /*T1 t1 = applicationContext.getBean(T1.class);
        System.out.println(t1);
        T1 t2 = applicationContext.getBean(T1.class);
        System.out.println(t2);
        T1 t3 = applicationContext.getBean(T1.class);
        System.out.println(t3);*/

    }
}
