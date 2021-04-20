package com.example.cloud.gateway.controller;

import com.example.cloud.gateway.fegin.SonFeginClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author TangYh
 * @Date 2021/4/20 5:14 下午
 * @Version 1.0
 * @Description TODO
 **/
@RestController
public class TestController {

    private final SonFeginClient sonFeginClient;

    public TestController(SonFeginClient sonFeginClient) {
        this.sonFeginClient = sonFeginClient;
    }

    @RequestMapping("/test")
    private String test(){
        return sonFeginClient.getOK();
    }
}
