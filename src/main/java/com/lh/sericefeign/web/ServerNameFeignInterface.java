package com.lh.sericefeign.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "Server-name")
public interface ServerNameFeignInterface {
    @PostMapping(value = "/myVersion")
    String myVersion();

    @GetMapping(value = "isGet")
    boolean isGet();

    @PostMapping(value = "hello2")
    String hello2(@RequestParam(value = "index",defaultValue = "2") int index);

    @PostMapping(value = "myHello")
    String myHello();
}
