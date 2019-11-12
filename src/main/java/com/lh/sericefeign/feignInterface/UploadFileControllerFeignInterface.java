package com.lh.sericefeign.feignInterface;

import com.lh.sericefeign.feignInterface.hystric.PageControllerFeignInterfaceHystric;
import com.lh.sericefeign.feignInterface.hystric.UploadFileControllerFeignInterfaceHystric;
import lh.model.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

/**
 * @author ：flyman，后端工程师：flyman2，前端工程师：flyman3
 * @create 2019-10-08 12:03
 * @function
 * @editLog
 */
@Repository
@FeignClient(value = "MYBATISUSE-MUCON/UploadFileController", fallback = UploadFileControllerFeignInterfaceHystric.class)
public interface UploadFileControllerFeignInterface {
    @PostMapping(value = "/uploadFile")
    ResultVO uploadFile(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "dictionary") String dictionary
            , @RequestParam(value = "fileName") String fileName) throws IOException;

    @PostMapping(value = "/uploadFileSelect")
    ResultVO uploadFileSelect(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException;

    @PostMapping(value = "/uploadFileUpdate")
    ResultVO uploadFileUpdate(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException;

    @PostMapping(value = "/uploadFileInsert")
    ResultVO uploadFileInsert(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException;

    @PostMapping(value = "/uploadFileDelete")
    ResultVO uploadFileDelete(@RequestBody byte[] fileStreamArray
            , @RequestParam(value = "fileName") String fileName) throws IOException;

    @PostMapping(value = "/downLoadFile")
    byte[] downLoadFile(@RequestParam(value = "dictionary") String dictionary
            , @RequestParam(value = "fileName") String fileName) throws IOException;
}
