package com.lh.sericefeign.feignInterface.hystric;

import com.lh.sericefeign.feignInterface.DictionaryControllerFeignInterface;
import com.lh.sericefeign.model.DictionaryModel;
import lh.model.ResultVO;
import lh.model.ResultVOPage;
import lh.units.ResultStruct;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-08 12:03
 * @function
 * @editLog
 */
@Service
public class DictionaryControllerFeignInterfaceHystric implements DictionaryControllerFeignInterface {
    private final String hystricMessage = "亲，服务器正忙，请稍后再戳。";

    @Override
    public List<String> selectDictionaryListString(String signName) {
        return null;
    }

    @Override
    public List<DictionaryModel> selectDictionaryList(String signName) {
        return null;
    }

    @Override
    public ResultVOPage selectDictionaryListPage(String signName, int page, int limit) {
        return ResultStruct.error(hystricMessage, ResultVOPage.class,null);
    }

    @Override
    public ResultVO insertDictionary(String contentName, String signName, int sortNo, String remark) {
        return ResultStruct.error(hystricMessage, ResultVO.class,null);
    }

    @Override
    public ResultVO updateDictionaryByAll(String id, String idWhere, String signNameWhere, boolean defaultSelect, int sortNo, boolean stopSign, String remark) {
        return ResultStruct.error(hystricMessage, ResultVO.class,int.class);
    }

    @Override
    public ResultVO updateDictionaryOfStopSign(String idWhere, String signNameWhere, boolean stopSign) {
        return ResultStruct.error(hystricMessage, ResultVO.class,int.class);
    }

    @Override
    public int deleteDictionaryBySignAndId(String id, String signName) {
        return 0;
    }

    @Override
    public ResultVO selectSignById(String id) {
        return ResultStruct.error(hystricMessage, ResultVO.class,null);
    }
}
