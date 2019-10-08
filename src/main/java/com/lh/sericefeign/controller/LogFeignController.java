package com.lh.sericefeign.controller;

import com.lh.sericefeign.feignInterface.MyBatisUseControllerFeignInterface;
import com.lh.sericefeign.feignInterface.hystric.MyBatisUseControllerFeignInterfaceHystric;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-21 23:31
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/logFeign")
@Api(value = "登录", description = "BS、CS单点登录")
public class LogFeignController {
    @Autowired
    MyBatisUseControllerFeignInterface myBatisUseControllerFeignInterface;

    /**
     * 用户登录CS，方法ID：SE20190929112838909B3-04-31-E6-9C-3B
     *
     * @param num      表sys_useInfo,字段名useName:账号、手机号或邮箱
     * @param passWord 表sys_useInfo,字段名passWord:密码
     * @return 用户信息
     */
    @ApiOperation(value = "用户登录", notes = "用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "账号", dataType = "String", required = true),
            @ApiImplicitParam(name = "passWord", value = "密码", dataType = "String", required = true)
    })
    @PostMapping("/useLogCS")
    public ResultVO useLogCS(@RequestParam(value = "num") String num
            , @RequestParam(value = "passWord") String passWord) {
        return myBatisUseControllerFeignInterface.useLogCS(num, passWord);
    }

}
