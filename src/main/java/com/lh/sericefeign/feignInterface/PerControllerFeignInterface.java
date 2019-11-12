package com.lh.sericefeign.feignInterface;

import com.lh.sericefeign.feignInterface.hystric.PerControllerFeignInterfaceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 梁昊
 * @date:2019/9/20
 */
@Repository
@FeignClient(value = "mybatisUse-mucon/perController", fallback = PerControllerFeignInterfaceHystric.class)
public interface PerControllerFeignInterface {
    @PostMapping("/insertIntoPerson")
    String insertIntoPerson(@RequestParam(value = "name", required = false) String name
            , @RequestParam(value = "sex", required = false, defaultValue = "10") int sex
            , @RequestParam(value = "age", defaultValue = "100") int age
            , @RequestParam(value = "classNo", defaultValue = "1") int classNo);
}