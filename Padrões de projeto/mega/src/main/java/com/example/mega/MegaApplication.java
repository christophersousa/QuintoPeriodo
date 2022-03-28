package com.example.mega;

import com.example.mega.controller.MegasenaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MegaApplication {

    public static void main(String[] args) {

        SpringApplication.run(MegaApplication.class, args);
        MegasenaController mega = new MegasenaController();
        mega.megasenaPage(8);
    }

}
