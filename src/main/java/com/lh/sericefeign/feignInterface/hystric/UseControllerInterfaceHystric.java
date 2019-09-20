package com.lh.sericefeign.feignInterface.hystric;

import com.lh.sericefeign.feignInterface.UseControllerInterface;
import lh.model.ResultVO;
import lh.units.ResultStruct;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 梁昊
 * @date:2019/9/20
 */
@Service
public class UseControllerInterfaceHystric implements UseControllerInterface {
    private final String hystricMessage = "亲，服务器正忙，请稍后再戳。";

    @Override
    public ResultVO useLogByNameAndPassWord(@RequestParam(value = "mobile") String mobile
            , @RequestParam(value = "passWord") String passWord) {
        return ResultStruct.error(hystricMessage, ResultVO.class);
    }

    @Override
    public ResultVO useLogByNameAndPassWordCS(String mobile, String passWord) {
        return ResultStruct.error(hystricMessage, ResultVO.class);
    }
}
