package com.lh.sericefeign.controller;

import com.lh.sericefeign.feignInterface.AuthorityFeignInterface;
import com.lh.sericefeign.feignInterface.PerControllerFeignInterface;
import com.lh.sericefeign.feignInterface.ServerNameFeignInterface;
import com.lh.sericefeign.feignInterface.UseControllerInterface;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import static com.netflix.discovery.DiscoveryManager.getInstance;

@RestController
@RequestMapping("/useFeign")
@Api(value = "测试代码生成器", description = "代码生成器描述")
public class ServerNameFeignControl {

    @Value("${server.port}")
    String mySelfPort;
    @Value("${eureka.instance.metadata-map.version}")
    private String version;

    @Autowired
    ServerNameFeignInterface serverNameFeignInterface;

    @Autowired
    PerControllerFeignInterface perControllerFeignInterface;

    @Autowired
    UseControllerInterface useControllerInterface;

    @Autowired
    AuthorityFeignInterface authorityFeignInterface;

    @PostMapping("/testTimeOut")
    public String testTimeOut(@RequestParam(value = "timeOut") long timeOut) {
        return serverNameFeignInterface.testTimeOut(timeOut);
    }

    @PostMapping(value = "/useLogOfManagerInBS")
    public ResultVO useLogOfManagerInBS(@RequestParam(value = "num") String num
            , @RequestParam(value = "passWord") String passWord) {
        return authorityFeignInterface.useLogOfManagerInBS(num, passWord);
    }

    @PostMapping("/selectMySystemNameList")
    public ResultVO selectMySystemNameList(@RequestParam(value = "id") String id) {
        return authorityFeignInterface.selectMySystemNameList(id);
    }

    @PostMapping(value = "/myVersion")
    public String myVersion() {
        RibbonFilterContextHolder.getCurrentContext().add("version", version);
        return String.format("My port is %s; My version is %s; 粒子层：%s", this.mySelfPort, this.version, serverNameFeignInterface.myVersion());
    }

    //    @PostMapping(value = "/isGet")
//    public boolean isGet(){
//        return serverNameFeignInterface.isGet();
//    }
//
//    @PostMapping(value = "/hello2")
//    public String hello2(@RequestParam(value = "index",defaultValue = "2") int index){
//        return "Feign:" + serverNameFeignInterface.hello2(index);
//    }
    @PostMapping(value = "/myPort")
    public String myPort() {
        return "Feign:" + this.mySelfPort + ",Server-name:" + serverNameFeignInterface.myPort();
    }

    @GetMapping(value = "/downLine")
    public void downLine() {
        getInstance().shutdownComponent();
    }

    /**
     * 测试增加员工，方法ID：SE20190910212446127
     *
     * @param name    姓名
     * @param sex     性别（0：男、1：女）
     * @param age     年龄
     * @param classNo 班级序号
     * @return 员工主键
     */
    @ApiOperation(value = "测试增加员工", notes = "员工主键")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String")
            , @ApiImplicitParam(name = "sex", value = "性别（0：男、1：女）", dataType = "int")
            , @ApiImplicitParam(name = "age", value = "年龄", dataType = "int", required = true)
            , @ApiImplicitParam(name = "classNo", value = "班级序号", dataType = "int", required = true)
    })
    @PostMapping("/insertIntoPerson")
    public String insertIntoPerson(@RequestParam(value = "name", required = false) String name
            , @RequestParam(value = "sex", required = false, defaultValue = "10") int sex
            , @RequestParam(value = "age", defaultValue = "100") int age
            , @RequestParam(value = "classNo", defaultValue = "1") int classNo) {
        name = name == null ? name : name.trim();
        return perControllerFeignInterface.insertIntoPerson(name, sex, age, classNo);
    }

    /**
     * 用户登录，方法ID：SE20190918154314137
     *
     * @param mobile 表sys_userinfo,字段名mobile:手机号码
     * @return 结构体
     */
    @ApiOperation(value = "用户登录", notes = "结构体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", required = true),
            @ApiImplicitParam(name = "passWord", value = "登录密码", dataType = "String", required = true)
    })
    @PostMapping("/useLogByNameAndPassWord")
    public ResultVO useLogByNameAndPassWord(@RequestParam(value = "mobile") String mobile
            , @RequestParam(value = "passWord") String passWord) {
        ResultVO resultVO = useControllerInterface.useLogByNameAndPassWord(mobile, passWord);
        return resultVO;
    }

    /**
     * 用户登录，方法ID：SE20190918154314137
     *
     * @param mobile 表sys_userinfo,字段名mobile:手机号码
     * @param passWord 表sys_userinfo,字段名passWord:登录密码
     * @return 结构体
     */
    @ApiOperation(value = "用户登录", notes = "结构体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", required = true),
            @ApiImplicitParam(name = "passWord", value = "登录密码", dataType = "String", required = true)
    })
    @PostMapping("/useLogByNameAndPassWordCS")
    public ResultVO useLogByNameAndPassWordCS(@RequestParam(value = "mobile") String mobile
            , @RequestParam(value = "passWord") String passWord) {
        ResultVO resultVO = useControllerInterface.useLogByNameAndPassWordCS(mobile, passWord);
        return resultVO;
    }

}
