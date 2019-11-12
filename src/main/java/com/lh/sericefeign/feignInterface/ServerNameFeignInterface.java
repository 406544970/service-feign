package com.lh.sericefeign.feignInterface;

import com.lh.sericefeign.feignInterface.hystric.ServerNameFeignInterfaceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Repository
@FeignClient(value = "mybatisUse-mucon/universal", fallback = ServerNameFeignInterfaceHystric.class)
public interface ServerNameFeignInterface {
    @PostMapping(value = "/myVersion")
    String myVersion();

//    @GetMapping(value = "/isGet")
//    boolean isGet();
//
//    @PostMapping(value = "/hello2")
//    String hello2(@RequestParam(value = "index",defaultValue = "2") int index);

    @PostMapping(value = "/myPort")
    String myPort();

    @PostMapping(value = "/testTimeOut")
    String testTimeOut(@RequestParam(value = "timeOut")long timeOut);
}
