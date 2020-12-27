package com.ist.svc.service.impl;

import com.ist.svc.common.CodeConstant;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.AddAcctBookReq;
import com.ist.svc.controller.model.QueryBaseResp;
import com.ist.svc.controller.model.WxPayNotifyResp;
import com.ist.svc.controller.model.dto.UptBagStatusReq;
import com.ist.svc.dao.*;
import com.ist.svc.domain.*;
import com.ist.svc.service.AccountService;
import com.ist.svc.service.newversion.BagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl extends BaseServiceImpl implements AccountService {
    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private UserSubAccountMapper userSubAccountMapper;
    @Autowired
    private UserAccountBookMapper userAccountBookMapper;
    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private BagService bagService;

    @Override
    public UserAccount getUserAcctByOwnUserId(BigDecimal ownUserId) {
        UserAccountExample example = new UserAccountExample();
        UserAccountExample.Criteria criteria = example.createCriteria();
        criteria.andOwnuseridEqualTo(ownUserId.longValue());
        List<UserAccount> userAccounts = userAccountMapper.selectByExample(example);
        if (userAccounts!=null && userAccounts.size()>0){
            return userAccounts.get(0);
        }
        return null;
    }

    @Override
    public UserSubAccount getUserSubAcctByAcctIdAndAcctType(BigDecimal acctId, Integer acctType) {
        UserSubAccountExample example = new UserSubAccountExample();
        UserSubAccountExample.Criteria criteria = example.createCriteria();
        criteria.andAccountidEqualTo(acctId.longValue());
        criteria.andAccttypeEqualTo(acctType.shortValue());
        List<UserSubAccount> userSubAccounts = userSubAccountMapper.selectByExample(example);
        if (userSubAccounts!=null && userSubAccounts.size()>0){
            return userSubAccounts.get(0);
        }
        return null;
    }

    @Override
    public Long createUserAcct(UserAccount userAccount) {
        int result = userAccountMapper.insert(userAccount);
        return result>0?userAccount.getAccountid():null;
    }

    @Override
    public Long createSubAcct(UserSubAccount userSubAccount) {
        int result = userSubAccountMapper.insert(userSubAccount);
        return result>0?userSubAccount.getSubaccountid():null;
    }

    @Override
    public int updateSubAcct(UserSubAccount userSubAccount) {
        return userSubAccountMapper.updateByPrimaryKeySelective(userSubAccount);
    }

    @Override
    public String recordAcctBook(AddAcctBookReq req, QueryBaseResp resp) {
        Long acctId;
        Long subAcctId;
        //查账户是否存在，状态是否正常
        UserAccount userAcct = getUserAcctByOwnUserId(new BigDecimal(req.getUserId()));
        Float balance = 0f;
        Date now = new Date();
        if (userAcct==null){
            //创建账户 如果不是记账的话 肯定不能支出
            if (req.getDirect()==2 && req.getAcctType()!= IstEnum.AcctType.BOOK.getType()){
                resp.setCode(ResultConstant.ADD_ACCT_BOOK_BALANCE_LOW_ERROR_CODE);
                resp.setMsg(ResultConstant.ADD_ACCT_BOOK_BALANCE_LOW_ERROR_MSG);
                return null;
            }
            UserAccount userAccount = new UserAccount();
            userAccount.setCreatetime(now);
            userAccount.setUpdatetime(now);
            userAccount.setOwnuserid(Long.valueOf(req.getUserId()));
            userAccount.setName(req.getName());
            userAccount.setStatus(IstEnum.AcctStatus.NORMAL.getStatus());
            userAccount.setUsertype((short) 0);
            acctId = createUserAcct(userAccount);
            //创建子账户
            subAcctId = createSubAcct(req, acctId, now);
        }else{
            if (userAcct.getStatus()==IstEnum.AcctStatus.LOCK.getStatus()){
                resp.setCode(ResultConstant.ADD_ACCT_BOOK_ACCT_LOCK_ERROR_CODE);
                resp.setMsg(ResultConstant.ADD_ACCT_BOOK_ACCT_LOCK_ERROR_MSG);
                return null;
            }
            acctId = userAcct.getAccountid();
            //查询子账户是否存在，状态是否正常
            UserSubAccount userSubAcct = getUserSubAcctByAcctIdAndAcctType(new BigDecimal(userAcct.getAccountid()), req.getAcctType());
            if (userSubAcct==null){
                //创建子账户
                if (req.getDirect()==2 && req.getAcctType()!=IstEnum.AcctType.BOOK.getType()){
                    resp.setCode(ResultConstant.ADD_ACCT_BOOK_BALANCE_LOW_ERROR_CODE);
                    resp.setMsg(ResultConstant.ADD_ACCT_BOOK_BALANCE_LOW_ERROR_MSG);
                    return null;
                }
                subAcctId = createSubAcct(req, acctId, now);
            }else{
                if (userSubAcct.getStatus()==IstEnum.AcctStatus.LOCK.getStatus()){
                    resp.setCode(ResultConstant.ADD_ACCT_BOOK_SUBACCT_LOCK_ERROR_CODE);
                    resp.setMsg(ResultConstant.ADD_ACCT_BOOK_SUBACCT_LOCK_ERROR_MSG);
                    return null;
                }

                subAcctId = userSubAcct.getSubaccountid();
                //不是记账需要 更新余额
                if (req.getAcctType()!=IstEnum.AcctType.BOOK.getType()){
                    UserSubAccount subAccountUpdate = new UserSubAccount();
                    subAccountUpdate.setSubaccountid(userSubAcct.getSubaccountid());
                    subAccountUpdate.setUpdatetime(new Date());
                    if (req.getStatus()!=IstEnum.AcctBookStatus.PAY_FINISH.getStatus().intValue()){
                        resp.setCode(ResultConstant.ADD_ACCT_BOOK_STATUS_ERROR_CODE);
                        resp.setMsg(ResultConstant.ADD_ACCT_BOOK_STATUS_ERROR_MSG);
                        return null;
                    }
                    if (req.getDirect()==2){
                        //判断余额是否充足
                        if (userSubAcct.getBalance()-req.getMoney()<0){
                            resp.setCode(ResultConstant.ADD_ACCT_BOOK_BALANCE_LOW_ERROR_CODE);
                            resp.setMsg(ResultConstant.ADD_ACCT_BOOK_BALANCE_LOW_ERROR_MSG);
                            return null;
                        }
                        subAccountUpdate.setBalance(userSubAcct.getBalance()-req.getMoney());
                    }else{
                        subAccountUpdate.setBalance(userSubAcct.getBalance()+req.getMoney());
                    }
                    int result = updateSubAcct(subAccountUpdate);
                    if (result<1){
                        resp.setCode(ResultConstant.ADD_ACCT_BOOK_UPDATE_SUB_ACCT_ERROR_CODE);
                        resp.setMsg(ResultConstant.ADD_ACCT_BOOK_UPDATE_SUB_ACCT_ERROR_MSG);
                        return null;
                    }
                    balance = subAccountUpdate.getBalance();
                }
            }
        }
        //创建账本记录
        UserAccountBook userAccountBook = new UserAccountBook();
        String currentDay = DateUtil.getString(new Date(),DateUtil.PATTERN_DATE);
        String newId = commonMapper.querySeqNextVal(IstEnum.SeqName.TRANS_ID.getSeqValue()).toString();
        newId = getNumberString(newId, 9, "0");
        String transId = currentDay + CodeConstant.ENVIRONMENT_NO + newId;
        userAccountBook.setTransid(Long.valueOf(transId));
        userAccountBook.setAccountid(acctId);
        userAccountBook.setAccttype(req.getAcctType().shortValue());
        if (req.getAcctType()!=IstEnum.AcctType.BOOK.getType()){
            userAccountBook.setBalance(balance);
        }else{
            userAccountBook.setBalance((float) 0);
        }
        userAccountBook.setCreatetime(now);
        userAccountBook.setUpdatetime(now);
        userAccountBook.setDirect(req.getDirect().shortValue());
        userAccountBook.setMoney(req.getMoney());
        userAccountBook.setOptuserid(Long.valueOf(req.getOptUserId()));
        userAccountBook.setOrderid(req.getOrderId());
        userAccountBook.setPaytype(req.getPayType().shortValue());
        userAccountBook.setStatus(req.getStatus().shortValue());
        userAccountBook.setSubaccountid(subAcctId);
        if (req.getBizType()!=null){
            userAccountBook.setBiztype(req.getBizType().shortValue());
        }
        userAccountBookMapper.insert(userAccountBook);
        return transId;
    }

    @Override
    public void orderPayFinishBack(WxPayNotifyResp resp, String transId, String otherOrder, String otherAcct) {
        UserAccountBookExample example = new UserAccountBookExample();
        UserAccountBookExample.Criteria criteria = example.createCriteria();
        criteria.andTransidEqualTo(Long.valueOf(transId));
        List<UserAccountBook> userAccountBooks = userAccountBookMapper.selectByExample(example);
        if (userAccountBooks!=null && userAccountBooks.size()>0){
            UserAccountBook userAccountBook = userAccountBooks.get(0);
            if (userAccountBook.getStatus()!= IstEnum.AcctBookStatus.PAY_FINISH.getStatus()){
                updateUserAccountAndOrderStatusToFinish(otherOrder, otherAcct, userAccountBook);
            }else{
                logger.warn("transId " + transId + " is already finish");
            }
        }else{
            logger.warn("transId " + transId + " is not exist");
            resp.setReturnCode(ResultConstant.WEIXIN_NOTIFY_ERROR_CODE);
            resp.setReturnMsg("流水号不存在");
        }
    }
    @Override
    public void updateUserAccountAndOrderStatusToFinish(String otherOrder, String otherAcct, UserAccountBook userAccountBook) {
        String transId = userAccountBook.getTransid()+"";
//        UserAccountBook updataBook = new UserAccountBook();
//        updataBook.setStatus(IstEnum.AcctBookStatus.PAY_FINISH.getStatus());
//        updataBook.setOtherorder(otherOrder);
//        updataBook.setOtheracct(otherAcct);
//        userAccountBookMapper.updateByExampleSelective(updataBook,example);
        //更新UserAccountBook为已付款状态
        UserAccountBook updateUserAccountBook = new UserAccountBook();
        updateUserAccountBook.setTransid(userAccountBook.getTransid());
        updateUserAccountBook.setStatus(IstEnum.AcctBookStatus.PAY_FINISH.getStatus());
        updateUserAccountBook.setOtherorder(otherOrder);
        updateUserAccountBook.setOtheracct(otherAcct);
        updateUserAccountBook.setUpdatetime(new Date());
        userAccountBookMapper.updateByPrimaryKeySelective(updateUserAccountBook);

        //根据业务类型判断是订单支付 还是红包支付
        String orderids = userAccountBook.getOrderid();
        if (userAccountBook.getBiztype()==IstEnum.BookBizType.ORDER.getCode()){
            if (StringUtils.isNoneBlank(orderids)){
                for (String orderId : orderids.split(",")){
                    OrderExample orderExample = new OrderExample();
                    OrderExample.Criteria criteria1 = orderExample.createCriteria();
                    criteria1.andOrderidEqualTo(Long.valueOf(orderId));
                    List<Short> values = new ArrayList<>();
                    values.add(IstEnum.OrderStatus.NOT_PAY.getStatus());
                    values.add(IstEnum.OrderStatus.PAY.getStatus());
                    criteria1.andStatusIn(values);
                    Order updataOrder = new Order();
                    updataOrder.setUpdatetime(new Date());
                    updataOrder.setTransid(transId);
                    updataOrder.setStatus(IstEnum.OrderStatus.PAY.getStatus());
                    orderMapper.updateByExampleSelective(updataOrder,orderExample);

                    OrderDetailExample detailExample = new OrderDetailExample();
                    OrderDetailExample.Criteria criteria2 = detailExample.createCriteria();
                    criteria2.andOrderidEqualTo(Long.valueOf(orderId));

                    OrderDetail updateOrderDetail = new OrderDetail();
                    updateOrderDetail.setStatus(IstEnum.OrderStatus.PAY.getStatus());
                    updateOrderDetail.setUpdatetime(new Date());
                    orderDetailMapper.updateByExampleSelective(updateOrderDetail,detailExample);

                }
            }
        }else if (userAccountBook.getBiztype()==IstEnum.BookBizType.BAG.getCode()){
            UptBagStatusReq req = new UptBagStatusReq();
            req.setBagNo(orderids);
            req.setStatus(IstEnum.BagStatus.PAY_COMPLETE.getCode());
            req.setTransId(transId);
            bagService.uptBagStatus(req);
        }else{
            logger.warn("transId " + transId + " is unknown");
        }
    }

    @Override
    public UserSubAccount querySubAcct(Map<String, Object> params) {
        return userSubAccountMapper.querySubAcct(params);
    }

    private String getNumberString(String number, int count, String spot) {
        String temp = number;
        for (Integer i = temp.length(); i < count; i++) {
            temp = spot + temp;
        }
        return temp;
    }
    private Long createSubAcct(AddAcctBookReq req, Long acctId, Date now) {
        Long subAcctId;
        UserSubAccount userSubAccount = new UserSubAccount();
        userSubAccount.setAccountid(acctId);
        String subAcctIdStr = acctId + String.format("%02d",req.getAcctType());
        subAcctId = Long.valueOf(subAcctIdStr);
        userSubAccount.setSubaccountid(subAcctId);
        userSubAccount.setAccttype(req.getAcctType().shortValue());
        if(IstEnum.AcctType.BOOK.getType()==req.getAcctType()){
            userSubAccount.setBalance((float) 0);
        }else{
            userSubAccount.setBalance(req.getMoney());
        }
        userSubAccount.setCreatetime(now);
        userSubAccount.setUpdatetime(now);
        userSubAccount.setStatus(IstEnum.AcctStatus.NORMAL.getStatus());
        createSubAcct(userSubAccount);
        return subAcctId;
    }
}
