package com.lh.sericefeign.feignInterface.hystric;

import com.lh.sericefeign.feignInterface.MyBatisUseControllerFeignInterface;
import lh.model.ResultVO;
import lh.units.ResultStruct;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 姊佹槉
 * @date:2019/10/8
 */
@Service
public class MyBatisUseControllerFeignInterfaceHystric implements MyBatisUseControllerFeignInterface {
    private final String hystricMessage = "亲，服务器正忙，请稍后再戳。";
    @Override
    public List<String> selectUseCreateNickNameList() {
        return null;
    }

    @Override
    public List<String> selectUseDoNickNameList() {
        return null;
    }

    @Override
    public List<String> selectUseFrontNickNameList() {
        return null;
    }

    @Override
    public String selectUseId(String nickName) {
        return null;
    }

    @Override
    public ResultVO useLogCS(String num, String passWord) {
        return ResultStruct.error(hystricMessage, ResultVO.class,null);
    }
}
