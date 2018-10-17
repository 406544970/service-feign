package com.lh.sericefeign.web;

import org.springframework.stereotype.Service;

@Service
public class ServerNameFeignInterfaceHystric implements ServerNameFeignInterface{
    @Override
    public String myPort() {
        return "sorry port is error.";
    }

    @Override
    public String myVersion() {
        return "sorry version is error.";
    }

    @Override
    public boolean isGet() {
        return false;
    }

    @Override
    public String hello2(int index) {
        return null;
    }

}


