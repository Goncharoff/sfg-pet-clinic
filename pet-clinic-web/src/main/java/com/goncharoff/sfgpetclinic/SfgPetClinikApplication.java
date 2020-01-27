package com.goncharoff.sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"services"})
public class SfgPetClinikApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfgPetClinikApplication.class, args);
    }

}
