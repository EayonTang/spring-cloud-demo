package com.example.cloud.gateway.fegin;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cloud-son")
@Service
public interface SonFeginClient {

    /**
     * 获取hey接口数据
     * @return see
     */
    @RequestMapping("/hey")
    String getHey();

    /**
     * 后去ok接口数据
     * @return see
     */
    @RequestMapping("/ok")
    String getOK();

}
