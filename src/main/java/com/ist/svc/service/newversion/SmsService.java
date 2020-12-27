package com.ist.svc.service.newversion;

import com.ist.svc.controller.model.SendMsgResp;
import com.ist.svc.controller.model.dto.SendSmsReq;

public interface SmsService {
   SendMsgResp sendSms(SendSmsReq sendSmsReq); //发送短信
}
