package com.lh.sericefeign.controller;

import com.lh.VO.ResultVO;
import com.lh.sericefeign.FeignInterface.AuthorityFeignInterface;
import com.lh.sericefeign.FeignInterface.ServerNameFeignInterface;
import com.lh.utils.ResultUtils;
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

    @Autowired
    AuthorityFeignInterface authorityFeignInterface;

    @PostMapping(value = "/useLogOfManagerInBS")
    public ResultVO useLogOfManagerInBS(@RequestParam(value = "num") String num
            , @RequestParam(value = "passWord") String passWord) {
        return authorityFeignInterface.useLogOfManagerInBS(num, passWord);
    }

    @PostMapping("/selectMySystemNameList")
    public ResultVO selectMySystemNameList(@RequestParam(value = "id") String id){
        return authorityFeignInterface.selectMySystemNameList(id);
    }

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
