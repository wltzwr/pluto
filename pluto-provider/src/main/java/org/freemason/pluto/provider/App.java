package org.freemason.pluto.provider;

import javassist.bytecode.analysis.Executor;
import org.freemason.pluto.common.utils.ClassUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {

    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }
}
