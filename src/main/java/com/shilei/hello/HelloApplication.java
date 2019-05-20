package com.shilei.hello;

import com.shilei.hello.instrument.CheatTransformer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.instrument.Instrumentation;

@SpringBootApplication
public class HelloApplication {

    public static void premain(String options, Instrumentation ins) {
        if (options != null) {
            System.out.println("Options: " + options);
        } else {
            System.out.println("No options");
        }

//        ins.addTransformer(new CheatTransformer());
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}
