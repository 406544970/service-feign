package com.lh.sericefeign.feignInterface.hystric;

import com.lh.sericefeign.feignInterface.AuthorityFeignInterface;
import lh.model.ResultVO;
import lh.units.ResultStruct;
import org.springframework.stereotype.Service;

@Service
public class AuthorityFeignInterfaceHystric implements AuthorityFeignInterface {
    @Override
    public ResultVO useLogOfManagerInBS(String num, String passWord) {
        return ResultStruct.error("失败！",ResultVO.class);
    }

    @Override
    public ResultVO selectMySystemNameList(String id) {
        return ResultStruct.error("失败！",ResultVO.class);
    }
}
