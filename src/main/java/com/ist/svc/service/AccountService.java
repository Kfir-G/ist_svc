package com.ist.svc.service;

import com.ist.svc.controller.model.AddAcctBookReq;
import com.ist.svc.controller.model.QueryBaseResp;
import com.ist.svc.controller.model.WxPayNotifyResp;
import com.ist.svc.domain.UserAccount;
import com.ist.svc.domain.UserAccountBook;
import com.ist.svc.domain.UserSubAccount;

import java.math.BigDecimal;
import java.util.Map;

public interface AccountService {
    //根据ownUserId 查询账户
    UserAccount getUserAcctByOwnUserId(BigDecimal ownUserId);
    //根据Accountid和acctType查询子账户
    UserSubAccount getUserSubAcctByAcctIdAndAcctType(BigDecimal acctId,Integer acctType);
    //创建账户
    Long createUserAcct(UserAccount userAccount);
    //创建子账户
    Long createSubAcct(UserSubAccount userSubAccount);
    //根据id更新子账户
    int updateSubAcct(UserSubAccount userSubAccount);
    //记录账本
    String recordAcctBook(AddAcctBookReq req, QueryBaseResp resp);

    void orderPayFinishBack(WxPayNotifyResp resp, String transId, String otherOrder, String otherAcct);

    void updateUserAccountAndOrderStatusToFinish(String otherOrder, String otherAcct, UserAccountBook userAccountBook);

    UserSubAccount querySubAcct(Map<String, Object> params);
}
