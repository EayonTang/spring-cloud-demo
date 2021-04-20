package com.example.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
public class CloudSonApplication {

    @Value("${spring.profiles.active}")
    private String name;

    public static void main(String[] args) {
        SpringApplication.run(CloudSonApplication.class, args);
    }

    @RestController
    class SonController {

        /**
         * 打招呼
         */
        @RequestMapping("/hey")
        public String sayYourName() {
            return "Hey I`m " + name;
        }

        /**
         * 询问状态
         */
        @RequestMapping("/ok")
        public String sayLivingState() {
            return "I`m " + name + ", Thanks! I`m fine.";
        }

    }
}
