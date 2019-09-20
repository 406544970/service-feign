package com.lh.sericefeign.feignInterface.hystric;

import com.lh.sericefeign.feignInterface.PerControllerFeignInterface;
import org.springframework.stereotype.Service;

/**
 * @author 梁昊
 * @date:2019/9/20
 */
@Service
public class PerControllerFeignInterfaceHystric implements PerControllerFeignInterface {
    @Override
    public String insertIntoPerson(String name, int sex, int age, int classNo) {
        return null;
    }
}
