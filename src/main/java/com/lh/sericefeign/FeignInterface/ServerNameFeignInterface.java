package com.lh.sericefeign.FeignInterface;

import com.lh.sericefeign.FeignInterface.Hystric.ServerNameFeignInterfaceHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Repository
@FeignClient(value = "dictionary-mucon",fallback = ServerNameFeignInterfaceHystric.class)
public interface ServerNameFeignInterface {
    @PostMapping(value = "/myVersion")
    String myVersion();

    @GetMapping(value = "/isGet")
    boolean isGet();

    @PostMapping(value = "/hello2")
    String hello2(@RequestParam(value = "index",defaultValue = "2") int index);

    @PostMapping(value = "/myPort")
    String myPort();
}
