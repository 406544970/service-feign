package com.lh.sericefeign.controller;

import com.lh.sericefeign.feignInterface.DictionaryControllerFeignInterface;
import com.lh.sericefeign.feignInterface.MyBatisUseControllerFeignInterface;
import com.lh.sericefeign.feignInterface.PageControllerFeignInterface;
import com.lh.sericefeign.feignInterface.UploadFileControllerFeignInterface;
import com.lh.sericefeign.model.DictionaryModel;
import com.lh.sericefeign.model.InPutParam.PageVersionListInParam;
import io.swagger.annotations.*;
import lh.model.ResultVO;
import lh.model.ResultVOPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-21 23:31
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/useAuthorityPageFeign")
@Api(value = "综合层", description = "用户、权限、页面控制层")
public class UseAuthorityPageFeignController {
    @Autowired
    DictionaryControllerFeignInterface dictionaryControllerFeignInterface;
    @Autowired
    MyBatisUseControllerFeignInterface myBatisUseControllerFeignInterface;
    @Autowired
    PageControllerFeignInterface pageControllerFeignInterface;
    @Autowired
    UploadFileControllerFeignInterface uploadFileControllerFeignInterface;


    /**
     * 返回字典列表，方法ID：SE20190921232129273
     *
     * @param signName 表inf_dictionary,字段名signName:标识
     * @return List
     */
    @ApiOperation(value = "返回字典列表", notes = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "signName", value = "标识", dataType = "String", required = true)
    })
    @PostMapping("/selectDictionaryListString")
    public List<String> selectDictionaryListString(@RequestParam(value = "signName") String signName) {
        List<DictionaryModel> dictionaryModels = dictionaryControllerFeignInterface.selectDictionaryList(signName);
        List<String> list = new ArrayList<>();
        if (dictionaryModels != null) {
            for (DictionaryModel dictionaryModel :
                    dictionaryModels) {
                list.add(dictionaryModel.getValue());
            }
        }
        dictionaryModels.clear();
        return list;
    }

    /**
     * 返回字典列表，方法ID：SE20190921232129273
     *
     * @param signName 表inf_dictionary,字段名signName:标识
     * @return List
     */
    @ApiOperation(value = "返回字典列表", notes = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "signName", value = "标识", dataType = "String", required = true)
    })
    @PostMapping("/selectDictionaryList")
    public List<DictionaryModel> selectDictionaryList(@RequestParam(value = "signName") String signName) {
        return dictionaryControllerFeignInterface.selectDictionaryList(signName);
    }

    /**
     * 返回字典列表，方法ID：SE20190921234229276
     *
     * @param signName 表inf_dictionary,字段名signName:标识
     * @param page     当前页数
     * @param limit    每页条数
     * @return List
     */
    @ApiOperation(value = "返回字典列表", notes = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "signName", value = "标识", dataType = "String", required = true),
            @ApiImplicitParam(name = "page", value = "当前页数", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "int")
    })
    @PostMapping("/selectDictionaryListPage")
    public ResultVOPage selectDictionaryListPage(@RequestParam(value = "signName") String signName
            , @RequestParam(value = "page", defaultValue = "1") int page
            , @RequestParam(value = "limit", defaultValue = "10") int limit) {
        return dictionaryControllerFeignInterface.selectDictionaryListPage(signName, page, limit);
    }

    /**
     * 增加字典，方法ID：SE20190922000753468
     *
     * @param contentName 内容
     * @param sortNo      出现顺序
     * @param remark      备注
     * @return 影响条数
     */
    @ApiOperation(value = "增加字典", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentName", value = "内容", dataType = "String", required = true)
            , @ApiImplicitParam(name = "signName", value = "标识", dataType = "String", required = true)
            , @ApiImplicitParam(name = "sortNo", value = "出现顺序", dataType = "int", required = true)
            , @ApiImplicitParam(name = "remark", value = "备注", dataType = "String")
    })
    @PostMapping("/insertDictionary")
    public ResultVO insertDictionary(@RequestParam(value = "contentName") String contentName
            , @RequestParam(value = "signName") String signName
            , @RequestParam(value = "sortNo") int sortNo
            , @RequestParam(value = "remark", required = false) String remark) {
        return dictionaryControllerFeignInterface.insertDictionary(contentName, signName, sortNo, remark);
    }

    /**
     * 修改字典，方法ID：SE20190922002032445
     *
     * @param id            主键
     * @param idWhere       主键, Where字段
     * @param signNameWhere 标识, Where字段
     * @param defaultSelect 是否选择
     * @param sortNo        出现顺序
     * @param stopSign      是否停用
     * @param remark        备注
     * @return 影响条数
     */
    @ApiOperation(value = "修改字典", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String")
            , @ApiImplicitParam(name = "idWhere", value = "主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "signNameWhere", value = "标识", dataType = "String", required = true)
            , @ApiImplicitParam(name = "defaultSelect", value = "是否选择", dataType = "boolean")
            , @ApiImplicitParam(name = "sortNo", value = "出现顺序", dataType = "int")
            , @ApiImplicitParam(name = "stopSign", value = "是否停用", dataType = "boolean")
            , @ApiImplicitParam(name = "remark", value = "备注", dataType = "String")
    })
    @PostMapping("/updateDictionaryByAll")
    public ResultVO updateDictionaryByAll(@RequestParam(value = "id", required = false) String id
            , @RequestParam(value = "idWhere") String idWhere
            , @RequestParam(value = "signNameWhere") String signNameWhere
            , @RequestParam(value = "defaultSelect", required = false) boolean defaultSelect
            , @RequestParam(value = "sortNo", required = false) int sortNo
            , @RequestParam(value = "stopSign", required = false) boolean stopSign
            , @RequestParam(value = "remark", required = false) String remark) {
        return dictionaryControllerFeignInterface.updateDictionaryByAll(id, idWhere, signNameWhere, defaultSelect, sortNo, stopSign, remark);
    }

    /**
     * 停用，方法ID：SE20190922002032445
     *
     * @param idWhere       主键, Where字段
     * @param signNameWhere 标识, Where字段
     * @param stopSign      是否停用
     * @return 影响条数
     */
    @ApiOperation(value = "修改字典", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idWhere", value = "主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "signNameWhere", value = "标识", dataType = "String", required = true)
            , @ApiImplicitParam(name = "stopSign", value = "是否停用", dataType = "boolean", required = true)
    })
    @PostMapping("/updateDictionaryOfStopSign")
    public ResultVO updateDictionaryOfStopSign(@RequestParam(value = "idWhere") String idWhere
            , @RequestParam(value = "signNameWhere") String signNameWhere
            , @RequestParam(value = "stopSign") boolean stopSign) {
        return dictionaryControllerFeignInterface.updateDictionaryOfStopSign(idWhere, signNameWhere, stopSign);
    }

    /**
     * 删除，方法ID：SE20190922094746611
     *
     * @param id       主键
     * @param signName 标识
     * @return 影响条数
     */
    @ApiOperation(value = "删除", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String")
            , @ApiImplicitParam(name = "signName", value = "标识", dataType = "String")
    })
    @PostMapping("/deleteDictionaryBySignAndId")
    public int deleteDictionaryBySignAndId(@RequestParam(value = "id", required = false) String id
            , @RequestParam(value = "signName", required = false) String signName) {
        return dictionaryControllerFeignInterface.deleteDictionaryBySignAndId(id, signName);
    }

    /**
     * 根据标识得到内容，方法ID：SE20190924091144625
     *
     * @param id 表inf_dictionaryName,字段名id:主键
     * @return 内容
     */
    @ApiOperation(value = "根据标识得到内容", notes = "内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String", required = true)
    })
    @PostMapping("/selectSignById")
    public ResultVO selectSignById(@RequestParam(value = "id") String id) {
        return dictionaryControllerFeignInterface.selectSignById(id);
    }

    /**
     * 得到创造者用户NickNameList，方法ID：SE20190928154227197
     *
     * @return 用户信息对象
     */
    @ApiOperation(value = "得到用户ID", notes = "用户信息对象")
    @PostMapping("/selectUseCreateNickNameList")
    public List<String> selectUseCreateNickNameList() {
        return myBatisUseControllerFeignInterface.selectUseCreateNickNameList();
    }

    /**
     * 得到后端者用户NickNameList，方法ID：SE20190928154227197
     *
     * @return 用户信息对象
     */
    @ApiOperation(value = "得到用户ID", notes = "用户信息对象")
    @PostMapping("/selectUseDoNickNameList")
    public List<String> selectUseDoNickNameList() {
        return myBatisUseControllerFeignInterface.selectUseDoNickNameList();
    }

    /**
     * 得到前端用户NickNameList，方法ID：SE20190928154227197
     *
     * @return 用户信息对象
     */
    @ApiOperation(value = "得到用户ID", notes = "用户信息对象")
    @PostMapping("/selectUseFrontNickNameList")
    public List<String> selectUseFrontNickNameList() {
        return myBatisUseControllerFeignInterface.selectUseFrontNickNameList();
    }

    /**
     * 得到用户ID，方法ID：SE20190928154227197
     *
     * @param nickName 表sys_useInfo,字段名nickName:昵称
     * @return 用户信息对象
     */
    @ApiOperation(value = "得到用户ID", notes = "用户信息对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName", value = "昵称", dataType = "String", required = true)
    })
    @PostMapping("/selectUseId")
    public String selectUseId(@RequestParam(value = "nickName") String nickName) {
        return myBatisUseControllerFeignInterface.selectUseId(nickName);
    }

    /**
     * 得到需要更新的版本信息，方法ID：SE2019100218372321158B1B17A5A33
     *
     * @return 页面ID
     */
    @ApiOperation(value = "得到需要更新的版本信息", notes = "页面ID")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "useId", value = "useId", dataType = "String", required = true)
    })
    @PostMapping("/selectVersionList")
    public ResultVO selectVersionList(
            @RequestBody @ApiParam(name = "pageVersionInParamList", value = "传入PageVersionAllInParam格式")
                    PageVersionListInParam pageVersionInParamList
            , @RequestParam(value = "useId") String useId) throws ParseException {
        return pageControllerFeignInterface.selectVersionList(pageVersionInParamList, useId);
    }

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
    @ApiOperation(value = "更新页面到远程", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageKey", value = "主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "projectId", value = "项目名称", dataType = "String")
            , @ApiImplicitParam(name = "pageType", value = "页面类型", dataType = "String")
            , @ApiImplicitParam(name = "pageVersion", value = "页面版本", dataType = "int")
            , @ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "Date")
            , @ApiImplicitParam(name = "lastUpdateTime", value = "最后修改时间", dataType = "Date")
            , @ApiImplicitParam(name = "createOperator", value = "创建者", dataType = "String")
            , @ApiImplicitParam(name = "createOperatorId", value = "创建者ID", dataType = "String")
            , @ApiImplicitParam(name = "doOperator", value = "后台开发员", dataType = "String")
            , @ApiImplicitParam(name = "doOperatorId", value = "后台开发ID", dataType = "String")
            , @ApiImplicitParam(name = "frontOperator", value = "前端开发员", dataType = "String")
            , @ApiImplicitParam(name = "frontOperatorId", value = "前端开发ID", dataType = "String")
            , @ApiImplicitParam(name = "finishCount", value = "完成比较", dataType = "int")
            , @ApiImplicitParam(name = "readOnly", value = "是否只读", dataType = "boolean")
            , @ApiImplicitParam(name = "methodRemark", value = "方法说明", dataType = "String")
    })
    @PostMapping("/updatePageAndXml")
    public int updatePageAndXml(@RequestParam(value = "pageKey", required = false) String pageKey
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
            , @RequestParam(value = "methodRemark", required = false) String methodRemark) {
        return pageControllerFeignInterface.updatePageAndXml(pageKey, projectId, pageType, pageVersion
                , createTime, lastUpdateTime, createOperator, createOperatorId
                , doOperator, doOperatorId, frontOperator, frontOperatorId, finishCount, readOnly, methodRemark);
    }

    /**
     * 删除远程页面，方法ID：DE20191003140516796BAC1703BA606
     *
     * @param pageKey 主键
     * @return 影响条数
     */
    @ApiOperation(value = "删除远程页面", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageKey", value = "主键", dataType = "String", required = true)
    })
    @PostMapping("/deletePageAndXml")
    public int deletePageAndXml(@RequestParam(value = "pageKey") String pageKey
            , @RequestParam(value = "pageType") String pageType) {
        return pageControllerFeignInterface.deletePageAndXml(pageKey, pageType);
    }

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
    @ApiOperation(value = "增加页面到远程", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageKey", value = "主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "projectId", value = "项目名称", dataType = "String", required = true)
            , @ApiImplicitParam(name = "pageType", value = "页面类型", dataType = "String", required = true)
            , @ApiImplicitParam(name = "pageVersion", value = "页面版本", dataType = "int", required = true)
            , @ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "Date", required = true)
            , @ApiImplicitParam(name = "lastUpdateTime", value = "最后修改时间", dataType = "Date", required = true)
            , @ApiImplicitParam(name = "createOperator", value = "创建者", dataType = "String", required = true)
            , @ApiImplicitParam(name = "createOperatorId", value = "创建者ID", dataType = "String", required = true)
            , @ApiImplicitParam(name = "doOperator", value = "后台开发员", dataType = "String", required = true)
            , @ApiImplicitParam(name = "doOperatorId", value = "后台开发ID", dataType = "String", required = true)
            , @ApiImplicitParam(name = "frontOperator", value = "前端开发员", dataType = "String", required = true)
            , @ApiImplicitParam(name = "frontOperatorId", value = "前端开发ID", dataType = "String", required = true)
            , @ApiImplicitParam(name = "finishCount", value = "完成比较", dataType = "int", required = true)
            , @ApiImplicitParam(name = "readOnly", value = "是否只读", dataType = "boolean", required = true)
            , @ApiImplicitParam(name = "methodRemark", value = "方法说明", dataType = "String")
    })
    @PostMapping("/insertPage")
    public int insertPage(@RequestParam(value = "pageKey") String pageKey
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
            , @RequestParam(value = "methodRemark", required = false) String methodRemark) {
        return pageControllerFeignInterface.insertPage(pageKey, projectId, pageType, pageVersion, createTime
                , lastUpdateTime, createOperator, createOperatorId, doOperator, doOperatorId, frontOperator, frontOperatorId
                , finishCount, readOnly, methodRemark);
    }

    /**
     * 单文件上传
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictionary", value = "路径名，如：select", dataType = "String", required = true),
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true),
    })
    @PostMapping(value = "/uploadFile")
    public ResultVO uploadFile(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "dictionary") String dictionary
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return uploadFileControllerFeignInterface.uploadFile(fileStreamArray, dictionary, fileName);
    }

    /**
     * 单文件上传SELECT
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true)
    })
    @PostMapping(value = "/uploadFileSelect")
    public ResultVO uploadFileSelect(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return uploadFileControllerFeignInterface.uploadFileSelect(fileStreamArray, fileName);
    }

    /**
     * 单文件上传UPDATE
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true)
    })
    @PostMapping(value = "/uploadFileUpdate")
    public ResultVO uploadFileUpdate(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return uploadFileControllerFeignInterface.uploadFileUpdate(fileStreamArray, fileName);
    }

    /**
     * 单文件上传INSERT
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true)
    })
    @PostMapping(value = "/uploadFileInsert")
    public ResultVO uploadFileInsert(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return uploadFileControllerFeignInterface.uploadFileInsert(fileStreamArray, fileName);
    }

    /**
     * 单文件上传DELETE
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true)
    })
    @PostMapping(value = "/uploadFileDelete")
    public ResultVO uploadFileDelete(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return uploadFileControllerFeignInterface.uploadFileDelete(fileStreamArray, fileName);
    }

    /**
     * 下载文件
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件上传", notes = "上传文件,指定文件夹(可选),文件名(可选)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictionary", value = "所在文件夹", dataType = "String", required = true),
            @ApiImplicitParam(name = "fileName", value = "带扩展名的文件名", dataType = "String", required = true)
    })
    @PostMapping(value = "/downLoadFile")
    public byte[] downLoadFile(@RequestParam(value = "dictionary") String dictionary
            , @RequestParam(value = "fileName") String fileName) throws IOException {
        return uploadFileControllerFeignInterface.downLoadFile(dictionary, fileName);
    }

    /**
     * 修改密码，方法ID：UP2019100909184486632CFE0ACD76A
     *
     * @param useId 主键, Where字段
     * @param passWord 密码
     * @return 是否成功
     */
    @ApiOperation(value = "修改密码", notes = "是否成功")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "useId", value = "主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "passWord", value = "密码", dataType = "String", required = true)
    })
    @PostMapping("/updatePassWord")
    public int updatePassWord(@RequestParam(value = "useId") String useId
            , @RequestParam(value = "passWord") String passWord) {
        return myBatisUseControllerFeignInterface.updatePassWord(useId,passWord);
    }

}
