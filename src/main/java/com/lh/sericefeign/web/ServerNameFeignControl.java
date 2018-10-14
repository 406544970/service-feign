package com.lh.sericefeign.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerNameFeignControl {
    @Autowired
    ServerNameFeignInterface serverNameFeignInterface;

    @PostMapping(value = "/myVersionFeign")
    public String myVersion() {
        return serverNameFeignInterface.myVersion();
    }

    @PostMapping(value = "/isGetFeign")
    public boolean isGet(){
        return serverNameFeignInterface.isGet();
    }

    @PostMapping(value = "/hello2Feign")
    public String hello2(@RequestParam(value = "index",defaultValue = "2") int index){
        return serverNameFeignInterface.hello2(index);
    }
    @PostMapping(value = "/myPortFeign")
    public String myPort(){
        return serverNameFeignInterface.myHello();
    }
}
