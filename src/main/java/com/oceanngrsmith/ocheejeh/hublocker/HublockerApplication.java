package com.oceanngrsmith.ocheejeh.hublocker;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEncryptableProperties
@SpringBootApplication
public class HublockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HublockerApplication.class, args);
    }

}
