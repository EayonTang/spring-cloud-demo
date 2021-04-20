package com.example.cloud.gateway.config;

import com.example.cloud.gateway.fegin.SonFeginClient;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author TangYh
 * @Date 2021/4/20 11:42 上午
 * @Version 1.0
 * @Description TODO
 *
 * 此处注意不能使用feign进行调用，因为使用feign会初始化
 * 在自动装配的过程中会调用
 * RibbonLoadBalancingHttpClient
 * 初始化DynamicServerListLoadBalancer时候调用restOfInit()->updateListOfServers()->updateAllServerList()->super(BaseLoadBalancer).forceQuickPing()->new Pinger(pingStrategy).runPinger();这个时候还没有初始化好会造成死循环
 * 进行BaseLoadBalanced
 **/
@Component
public class HealthCheck implements IPing {

    private static final RestTemplate TEMPLATE = new RestTemplate();

    @LoadBalanced
    private final SonFeginClient sonFeginClient;

    public HealthCheck(SonFeginClient sonFeginClient) {
        this.sonFeginClient = sonFeginClient;
    }

    @Override
    public boolean isAlive(Server server) {
        String response = TEMPLATE.getForObject("http://"+server.getId()+"/ok",String.class);

//        System.out.println("feign"+sonFeginClient.getOK());
        System.out.println(response);
        return true;
    }
}
