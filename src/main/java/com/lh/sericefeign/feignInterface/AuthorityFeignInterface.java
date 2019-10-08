package com.lh.sericefeign.feignInterface;

import com.lh.sericefeign.feignInterface.hystric.AuthorityFeignInterfaceHystric;
import lh.model.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@FeignClient(value = "authority-mucon/authority", fallback = AuthorityFeignInterfaceHystric.class)
public interface AuthorityFeignInterface {
    @PostMapping(value = "/useLogOfManagerInBS")
    ResultVO useLogOfManagerInBS(@RequestParam(value = "num") String num
            , @RequestParam(value = "passWord") String passWord);

    @PostMapping("/selectMySystemNameList")
    ResultVO selectMySystemNameList(@RequestParam(value = "id") String id);

}
