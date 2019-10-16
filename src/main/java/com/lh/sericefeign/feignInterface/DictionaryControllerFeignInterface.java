package com.lh.sericefeign.feignInterface;

import com.lh.sericefeign.feignInterface.hystric.DictionaryControllerFeignInterfaceHystric;
import com.lh.sericefeign.model.DictionaryModel;
import lh.model.ResultVO;
import lh.model.ResultVOPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-08 12:03
 * @function
 * @editLog
 */
@Repository
@FeignClient(value = "AUTHORITY-MUCON/dictionaryController", fallback = DictionaryControllerFeignInterfaceHystric.class)
public interface DictionaryControllerFeignInterface {
    @PostMapping("/downIniDictionary")
    ResultVO downIniDictionary();

    @PostMapping("/selectDictionaryListString")
    List<String> selectDictionaryListString(@RequestParam(value = "signName") String signName);

    @PostMapping("/selectDictionaryList")
    List<DictionaryModel> selectDictionaryList(@RequestParam(value = "signName") String signName);

    @PostMapping("/selectDictionaryListPage")
    ResultVOPage selectDictionaryListPage(@RequestParam(value = "signName") String signName
            , @RequestParam(value = "page", defaultValue = "1") int page
            , @RequestParam(value = "limit", defaultValue = "10") int limit);

    @PostMapping("/insertDictionary")
    ResultVO insertDictionary(@RequestParam(value = "contentName") String contentName
            , @RequestParam(value = "signName") String signName
            , @RequestParam(value = "sortNo") int sortNo
            , @RequestParam(value = "remark", required = false) String remark);

    @PostMapping("/updateDictionaryByAll")
    ResultVO updateDictionaryByAll(@RequestParam(value = "id", required = false) String id
            , @RequestParam(value = "idWhere") String idWhere
            , @RequestParam(value = "signNameWhere") String signNameWhere
            , @RequestParam(value = "defaultSelect", required = false) boolean defaultSelect
            , @RequestParam(value = "sortNo", required = false) int sortNo
            , @RequestParam(value = "stopSign", required = false) boolean stopSign
            , @RequestParam(value = "remark", required = false) String remark);

    @PostMapping("/updateDictionaryOfStopSign")
    ResultVO updateDictionaryOfStopSign(@RequestParam(value = "idWhere") String idWhere
            , @RequestParam(value = "signNameWhere") String signNameWhere
            , @RequestParam(value = "stopSign") boolean stopSign);

    @PostMapping("/deleteDictionaryBySignAndId")
    int deleteDictionaryBySignAndId(@RequestParam(value = "id", required = false) String id
            , @RequestParam(value = "signName", required = false) String signName);

    @PostMapping("/selectSignById")
    ResultVO selectSignById(@RequestParam(value = "id") String id);

}
