package com.lh.sericefeign.feignInterface.hystric;

import com.lh.sericefeign.feignInterface.PageControllerFeignInterface;
import com.lh.sericefeign.model.InPutParam.PageVersionListInParam;
import lh.model.ResultVO;
import lh.units.ResultStruct;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-08 12:03
 * @function
 * @editLog
 */
@Service
public class PageControllerFeignInterfaceHystric implements PageControllerFeignInterface {
    private final String hystricMessage = "亲，服务器正忙，请稍后再戳。";

    @Override
    public ResultVO selectVersionList(PageVersionListInParam pageVersionInParamList, String useId) {
        return ResultStruct.error(hystricMessage, ResultVO.class,null);
    }

    @Override
    public int updatePageAndXml(String pageKey, String projectId, String pageType, int pageVersion, Date createTime, Date lastUpdateTime, String createOperator, String createOperatorId, String doOperator, String doOperatorId, String frontOperator, String frontOperatorId, int finishCount, boolean readOnly, String methodRemark) {
        return 0;
    }

    @Override
    public int deletePageAndXml(String pageKey, String pageType) {
        return 0;
    }

    @Override
    public int insertPage(String pageKey, String projectId, String pageType, int pageVersion, Date createTime, Date lastUpdateTime, String createOperator, String createOperatorId, String doOperator, String doOperatorId, String frontOperator, String frontOperatorId, int finishCount, boolean readOnly, String methodRemark) {
        return 0;
    }
}
