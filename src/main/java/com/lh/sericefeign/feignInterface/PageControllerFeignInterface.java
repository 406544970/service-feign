package com.lh.sericefeign.feignInterface;

import com.lh.sericefeign.feignInterface.hystric.PageControllerFeignInterfaceHystric;
import com.lh.sericefeign.model.InPutParam.PageVersionListInParam;
import io.swagger.annotations.ApiParam;
import lh.model.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-08 12:03
 * @function
 * @editLog
 */
@Repository
@FeignClient(value = "dictionary-mucon/pageController", fallback = PageControllerFeignInterfaceHystric.class)
public interface PageControllerFeignInterface {
    /**
     * 得到需要更新的版本信息，方法ID：SE2019100218372321158B1B17A5A33
     *
     * @return 页面ID
     */
    @PostMapping("/selectVersionList")
    ResultVO selectVersionList(
            @RequestBody @ApiParam(name = "pageVersionInParamList", value = "传入PageVersionAllInParam格式")
                    PageVersionListInParam pageVersionInParamList
            , @RequestParam(value = "useId") String useId);

    /**
     * 更新页面到远程，方法ID：UP20191003134902131B1A669671742
     *
     * @param pageKey          主键, Where字段
     * @param projectId        项目名称
     * @param pageType         页面类型
     * @param pageVersion      页面版本
     * @param createTime       创建时间
     * @param lastUpdateTime   最后修改时间
     * @param createOperator   创建者
     * @param createOperatorId 创建者ID
     * @param doOperator       后台开发员
     * @param doOperatorId     后台开发ID
     * @param frontOperator    前端开发员
     * @param frontOperatorId  前端开发ID
     * @param finishCount      完成比较
     * @param readOnly         是否只读
     * @param methodRemark     方法说明
     * @return 影响条数
     */
    @PostMapping("/updatePageAndXml")
    int updatePageAndXml(@RequestParam(value = "pageKey", required = false) String pageKey
            , @RequestParam(value = "projectId", required = false) String projectId
            , @RequestParam(value = "pageType", required = false) String pageType
            , @RequestParam(value = "pageVersion", required = false) int pageVersion
            , @RequestParam(value = "createTime", required = false) Date createTime
            , @RequestParam(value = "lastUpdateTime", required = false) Date lastUpdateTime
            , @RequestParam(value = "createOperator", required = false) String createOperator
            , @RequestParam(value = "createOperatorId", required = false) String createOperatorId
            , @RequestParam(value = "doOperator", required = false) String doOperator
            , @RequestParam(value = "doOperatorId", required = false) String doOperatorId
            , @RequestParam(value = "frontOperator", required = false) String frontOperator
            , @RequestParam(value = "frontOperatorId", required = false) String frontOperatorId
            , @RequestParam(value = "finishCount", required = false) int finishCount
            , @RequestParam(value = "readOnly", required = false) boolean readOnly
            , @RequestParam(value = "methodRemark", required = false) String methodRemark);

    /**
     * 删除远程页面，方法ID：DE20191003140516796BAC1703BA606
     *
     * @param pageKey 主键
     * @return 影响条数
     */
    @PostMapping("/deletePageAndXml")
    int deletePageAndXml(@RequestParam(value = "pageKey") String pageKey
            , @RequestParam(value = "pageType") String pageType);

    /**
     * 增加页面到远程，方法ID：IN2019100313365444981638880CDD8
     *
     * @param pageKey          主键
     * @param projectId        项目名称
     * @param pageType         页面类型
     * @param pageVersion      页面版本
     * @param createTime       创建时间
     * @param lastUpdateTime   最后修改时间
     * @param createOperator   创建者
     * @param createOperatorId 创建者ID
     * @param doOperator       后台开发员
     * @param doOperatorId     后台开发ID
     * @param frontOperator    前端开发员
     * @param frontOperatorId  前端开发ID
     * @param finishCount      完成比较
     * @param readOnly         是否只读
     * @param methodRemark     方法说明
     * @return 影响条数
     */
    @PostMapping("/insertPage")
    int insertPage(@RequestParam(value = "pageKey") String pageKey
            , @RequestParam(value = "projectId") String projectId
            , @RequestParam(value = "pageType") String pageType
            , @RequestParam(value = "pageVersion") int pageVersion
            , @RequestParam(value = "createTime") Date createTime
            , @RequestParam(value = "lastUpdateTime") Date lastUpdateTime
            , @RequestParam(value = "createOperator") String createOperator
            , @RequestParam(value = "createOperatorId") String createOperatorId
            , @RequestParam(value = "doOperator") String doOperator
            , @RequestParam(value = "doOperatorId") String doOperatorId
            , @RequestParam(value = "frontOperator") String frontOperator
            , @RequestParam(value = "frontOperatorId") String frontOperatorId
            , @RequestParam(value = "finishCount") int finishCount
            , @RequestParam(value = "readOnly") boolean readOnly
            , @RequestParam(value = "methodRemark", required = false) String methodRemark);
}
