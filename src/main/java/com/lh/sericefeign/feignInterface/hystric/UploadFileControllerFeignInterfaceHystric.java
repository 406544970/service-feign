package com.lh.sericefeign.feignInterface.hystric;

import com.lh.sericefeign.feignInterface.UploadFileControllerFeignInterface;
import lh.model.ResultVO;
import lh.units.ResultStruct;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 姊佹槉
 * @date:2019/10/8
 */
@Service
public class UploadFileControllerFeignInterfaceHystric implements UploadFileControllerFeignInterface {
    private final String hystricMessage = "亲，服务器正忙，请稍后再戳。";

    @Override
    public ResultVO uploadFile(byte[] fileStreamArray, String dictionary, String fileName) throws IOException {
        return ResultStruct.error(hystricMessage, ResultVO.class, boolean.class);
    }

    @Override
    public ResultVO uploadFileSelect(byte[] fileStreamArray, String fileName) throws IOException {
        return ResultStruct.error(hystricMessage, ResultVO.class, boolean.class);
    }

    @Override
    public ResultVO uploadFileUpdate(byte[] fileStreamArray, String fileName) throws IOException {
        return ResultStruct.error(hystricMessage, ResultVO.class, boolean.class);
    }

    @Override
    public ResultVO uploadFileInsert(byte[] fileStreamArray, String fileName) throws IOException {
        return ResultStruct.error(hystricMessage, ResultVO.class, boolean.class);
    }

    @Override
    public ResultVO uploadFileDelete(byte[] fileStreamArray, String fileName) throws IOException {
        return ResultStruct.error(hystricMessage, ResultVO.class, boolean.class);
    }

    @Override
    public byte[] downLoadFile(String dictionary, String fileName) throws IOException {
        return new byte[0];
    }
}
