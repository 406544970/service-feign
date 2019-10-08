package com.lh.sericefeign.feignInterface;

import com.lh.sericefeign.feignInterface.hystric.MyBatisUseControllerFeignInterfaceHystric;
import lh.model.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-08 12:03
 * @function
 * @editLog
 */
@Repository
@FeignClient(value = "AUTHORITY-MUCON/myBatisUseController", fallback = MyBatisUseControllerFeignInterfaceHystric.class)
public interface MyBatisUseControllerFeignInterface {
    @PostMapping("/selectUseCreateNickNameList")
    List<String> selectUseCreateNickNameList();

    @PostMapping("/selectUseDoNickNameList")
    List<String> selectUseDoNickNameList();

    @PostMapping("/selectUseFrontNickNameList")
    List<String> selectUseFrontNickNameList();

    @PostMapping("/selectUseId")
    String selectUseId(@RequestParam(value = "nickName") String nickName);

    @PostMapping("/useLogCS")
    ResultVO useLogCS(@RequestParam(value = "num") String num
            , @RequestParam(value = "passWord") String passWord);
}
