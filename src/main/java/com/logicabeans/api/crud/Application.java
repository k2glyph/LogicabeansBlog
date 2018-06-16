package com.logicabeans.api.crud;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.logicabeans.api","com.logicabeans.api.crud"})
public class Application {
    private static final Logger LOG = LogManager.getLogger(Application.class.getName());
    public static void main(String[] args) {
        LOG.info("Request server to start with arguments:{}", Arrays.toString(args));
        SpringApplication.run(Application.class, args);
    }
}
