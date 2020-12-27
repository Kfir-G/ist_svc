package com.ist.svc.controller;

import com.alibaba.fastjson.JSON;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.pojo.FileDTO;
import com.ist.svc.common.pojo.ResultVO;
import com.ist.svc.common.util.FileComponent;
import com.ist.svc.common.util.ResultUtil;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.UserVerifyTokenReq;
import com.ist.svc.controller.model.UserVerifyTokenResp;
import com.ist.svc.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理文件
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private FileComponent fileComponent;
    @Autowired
    private UserTokenService userTokenService;

    /**
     * 单文件上传
     */
    @PostMapping("single")
    public ResultVO single(@RequestParam("file") MultipartFile multipartFile){

        return null;
    }

    /**
     * 多文件上传，多文件上传其实还是走的单文件上传
     */
    @PostMapping("multi")
    public ResultVO multi(HttpServletRequest request){
        System.out.println("文件上传请求 》》》");
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        String userId = request.getParameter("userId");
        String tokenId = request.getParameter("tokenId");
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(tokenId);
        userVerifyTokenReq.setUserId(userId);
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            return ResultUtil.errorResultVO(IstEnum.ResultEnum.OPERATE_FAIL, userVerifyTokenResp.getMsg());
        }
        List<FileDTO> fileDTOList = new ArrayList<>();
        for ( MultipartFile multipartFile : files) {
            FileDTO fileDTO = fileComponent.fileUpload(multipartFile);
            if (fileDTO != null) {
                fileDTOList.add(fileDTO);
            }
        }
        int uploadNum = files.size();
        int successNum = fileDTOList.size();

        if (successNum == uploadNum) {
            System.out.println("response >>> "+ JSON.toJSONString(fileDTOList));
            return ResultUtil.okResultVO(fileDTOList);
        }
        return ResultUtil.errorResultVO(IstEnum.ResultEnum.OPERATE_FAIL, "上传["+uploadNum+"]个文件，成功["+successNum+"]个。");
    }

}
