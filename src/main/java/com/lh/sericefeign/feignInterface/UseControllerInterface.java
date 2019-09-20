package com.lh.sericefeign.feignInterface;

import com.lh.sericefeign.feignInterface.hystric.UseControllerInterfaceHystric;
import lh.model.ResultVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 梁昊
 * @date:2019/9/20
 */
@Repository
@FeignClient(value = "authority-mucon/useController", fallback = UseControllerInterfaceHystric.class)
public interface UseControllerInterface {
    @PostMapping("/useLogByNameAndPassWord")
    ResultVO useLogByNameAndPassWord(@RequestParam(value = "mobile") String mobile
            , @RequestParam(value = "passWord") String passWord);

    @PostMapping("/useLogByNameAndPassWordCS")
    ResultVO useLogByNameAndPassWordCS(@RequestParam(value = "mobile") String mobile
            , @RequestParam(value = "passWord") String passWord);
}
