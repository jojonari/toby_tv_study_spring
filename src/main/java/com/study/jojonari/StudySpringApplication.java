package com.study.jojonari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class StudySpringApplication {

	public static void main(String[] args){
        ConfigurableApplicationContext c = SpringApplication.run(StudySpringApplication.class, args);

    }

    @RestController
    public static class MyController{
        @RequestMapping("/hello")
        public CompletableFuture<String> hello(){
            return CompletableFuture
                    .supplyAsync(()->"Hello world")
                    .thenApplyAsync(s->s.toUpperCase());
        }
    }

}
