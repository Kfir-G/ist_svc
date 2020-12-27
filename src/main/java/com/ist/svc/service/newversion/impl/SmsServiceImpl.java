package com.ist.svc.service.newversion.impl;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.config.IstConfig;
import com.ist.svc.controller.model.SendMsgResp;
import com.ist.svc.controller.model.dto.SendSmsReq;
import com.ist.svc.service.impl.BaseServiceImpl;
import com.ist.svc.service.newversion.SmsService;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class SmsServiceImpl extends BaseServiceImpl implements SmsService {
    @Autowired
    private IstConfig istConfig;

    SmsClient smsClient = null;
    @Override
    public SendMsgResp sendSms(SendSmsReq sendSmsReq) {
        SendMsgResp sendMsgResp = new SendMsgResp();
        try {
            sendMsgResp.setCode(ResultConstant.SUCCESS_CODE);
            sendMsgResp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
            SendSmsRequest sendSmsRequest = new SendSmsRequest();
            sendSmsRequest.setSmsSdkAppid(istConfig.getSmsAppId());
            sendSmsRequest.setSign(istConfig.getSmsSign());
            sendSmsRequest.setTemplateID(sendSmsReq.getTemplateId());
            sendSmsRequest.setPhoneNumberSet(sendSmsReq.getPhoneNums());
            sendSmsRequest.setTemplateParamSet(sendSmsReq.getTemplateParams());
            SendSmsResponse sendSmsResponse = smsClient.SendSms(sendSmsRequest);
            logger.info("sendSms.req=>{},resp=>{}",sendSmsReq.toString(),SendSmsResponse.toJsonString(sendSmsResponse));
            return sendMsgResp;
        }catch (Exception e){
            sendMsgResp.setCode(ResultConstant.SEND_SMS_ERROR_CODE);
            sendMsgResp.setCode(ResultConstant.SEND_SMS_ERROR_MSG);
            return sendMsgResp;
        }
    }
    @PostConstruct()
    public void init() {
        if (smsClient==null){
            Credential cred = new Credential(istConfig.getSmsSecretId(), istConfig.getSmsSecretKey());
            smsClient = new SmsClient(cred,"ap-shanghai");
        }
    }
}
