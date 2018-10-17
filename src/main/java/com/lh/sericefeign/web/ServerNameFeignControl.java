package com.lh.sericefeign.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import static com.netflix.discovery.DiscoveryManager.getInstance;

@RestController
public class ServerNameFeignControl {

    @Value("${server.port}")
    String mySelfPort;

    @Autowired
    ServerNameFeignInterface serverNameFeignInterface;

    @PostMapping(value = "/myVersion")
    public String myVersion() {
        return "Feign:" + serverNameFeignInterface.myVersion();
    }

    @PostMapping(value = "/isGet")
    public boolean isGet(){
        return serverNameFeignInterface.isGet();
    }

    @PostMapping(value = "/hello2")
    public String hello2(@RequestParam(value = "index",defaultValue = "2") int index){
        return "Feign:" + serverNameFeignInterface.hello2(index);
    }
    @PostMapping(value = "/myPort")
    public String myPort(){
        return "Feign:" + this.mySelfPort + ",Server-name:" + serverNameFeignInterface.myPort();
    }

    @GetMapping(value = "/downLine")
    public void downLine(){
        getInstance().shutdownComponent();
    }
}
