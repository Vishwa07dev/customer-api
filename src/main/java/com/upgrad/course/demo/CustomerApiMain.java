package com.upgrad.course.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Customer Api to handle customer related requests
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.upgrad.course.demo.*"})
public class CustomerApiMain {
    public static void main( String[] args ) {
        SpringApplication.run(CustomerApiMain.class, args);
    }
}
