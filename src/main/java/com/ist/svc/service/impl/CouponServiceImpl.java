package com.ist.svc.service.impl;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.*;
import com.ist.svc.dao.CommonMapper;
import com.ist.svc.dao.ShopCouponMapper;
import com.ist.svc.dao.UserCouponMapper;
import com.ist.svc.domain.ShopCoupon;
import com.ist.svc.domain.ShopCouponExample;
import com.ist.svc.domain.ShopCouponProd;
import com.ist.svc.domain.UserCoupon;
import com.ist.svc.domain.UserCouponExample;
import com.ist.svc.service.CouponService;
import com.ist.svc.service.UserTokenService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author: sunhaitao
 */
@Service(value = "couponService")
public class CouponServiceImpl extends BaseServiceImpl implements CouponService {
    @Autowired
    private UserTokenService userTokenService;
    @Autowired
    private UserCouponMapper userCouponMapper;
    @Autowired
    private ShopCouponMapper shopCouponMapper;
    @Autowired
    private CommonMapper commonMapper;
    @Override
    public void getUserCoupon(GetUserCouponReq req, QueryBaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.GET_USER_COUPON_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.GET_USER_COUPON_TOKENID_ERROR_MSG);
            return;
        }
        List<GetUserCouponData> data = new ArrayList<>();
        Map<String,Object> params = new HashMap<>();
        params.put("userId",req.getUserId());
        if(StringUtils.isNotBlank(req.getShopIds())){
            params.put("shopIds",req.getShopIds().split(","));
        }
        if (req.getStatus()!=null){
            params.put("status",req.getStatus());
        }
        if (StringUtils.isNoneBlank(req.getEndTime())){
            params.put("endTime",DateUtil.formatDateStr(req.getEndTime(),DateUtil.PATTERN_DATE_TIME));
        }
        List<UserCoupon> userCoupons = userCouponMapper.selectByParams(params);
        if (userCoupons!=null && !userCoupons.isEmpty()){
            for (UserCoupon userCoupon : userCoupons){
                GetUserCouponData getUserCouponData = new GetUserCouponData();
                getUserCouponData.setConditionMoney(userCoupon.getConditionMoney());
                getUserCouponData.setCouponId(userCoupon.getCouponid().toString());
                getUserCouponData.setUserCouponId(userCoupon.getId().toString());
                getUserCouponData.setEndTime(DateUtil.getString(userCoupon.getEndtime(),DateUtil.PATTERN_DATE_TIME));
                getUserCouponData.setNo(userCoupon.getNo().toString());
                getUserCouponData.setMoney(userCoupon.getMoney());
//                getUserCouponData.setProdId(userCoupon.getOrderid()==null?"":userCoupon.getOrderid().toString());
                getUserCouponData.setShopId(userCoupon.getShopid().toString());
                getUserCouponData.setStatus(userCoupon.getStatus().intValue());
                getUserCouponData.setType(userCoupon.getType().intValue());
                getUserCouponData.setShopName(userCoupon.getShopName());
                getUserCouponData.setCouponName(userCoupon.getCouponName());
                if (userCoupon.getUsertime()!=null){
                    getUserCouponData.setUseTime(DateUtil.getString(userCoupon.getEndtime(),DateUtil.PATTERN_DATE_TIME));
                }
                if (userCoupon.getCreatetime()!=null){
                    getUserCouponData.setCreateTime(DateUtil.getString(userCoupon.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                }
                getUserCouponData.setDescr(userCoupon.getDescr());
                List<com.ist.svc.controller.model.ShopCouponProd> shopCouponProds = new ArrayList<>();
                for (ShopCouponProd shopCouponProd : userCoupon.getShopCouponProds()){
                    com.ist.svc.controller.model.ShopCouponProd scp = new com.ist.svc.controller.model.ShopCouponProd();
                    scp.setCouponId(shopCouponProd.getCouponid());
                    scp.setHeadImg(shopCouponProd.getHeadimg());
                    scp.setProdId(shopCouponProd.getProdid());
                    scp.setProdInfoId(shopCouponProd.getProdinfoid());
                    scp.setProdName(shopCouponProd.getProdname());
                    shopCouponProds.add(scp);
                }
                getUserCouponData.setShopCouponProds(shopCouponProds);
                data.add(getUserCouponData);
            }
        }
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
        resp.setData(data);
    }

    @Override
    public void receiveCoupon(ReceiveCouponReq req, BaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.RECEIVE_COUPON_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.RECEIVE_COUPON_TOKENID_ERROR_MSG);
            return;
        }

        ShopCoupon shopCoupon = shopCouponMapper.selectByPrimaryKey(Integer.parseInt(req.getCouponId()));
        if(null==shopCoupon){
            resp.setCode(ResultConstant.RECEIVE_COUPON_NOT_EXIST_ERROR_CODE);
            resp.setMsg(ResultConstant.RECEIVE_COUPON_NOT_EXIST_ERROR_MSG);
            return;
        }
        //验证状态是否正常 1正常
        if (shopCoupon.getStatus().intValue()!=1){
            resp.setCode(ResultConstant.RECEIVE_COUPON_STATUS_ERROR_CODE);
            resp.setMsg(ResultConstant.RECEIVE_COUPON_STATUS_ERROR_MSG);
            return;
        }
        //验证领取时间是否合理
        Date now = new Date();
        if (shopCoupon.getOnlinetime().after(now)){
            resp.setCode(ResultConstant.RECEIVE_COUPON_TIME_BEFORE_ERROR_CODE);
            resp.setMsg(ResultConstant.RECEIVE_COUPON_TIME_BEFORE_ERROR_MSG);
            return;
        }
        //验证领取时间是否结束
        if (shopCoupon.getOfftime().before(now)){
            resp.setCode(ResultConstant.RECEIVE_COUPON_TIME_OVER_ERROR_CODE);
            resp.setMsg(ResultConstant.RECEIVE_COUPON_TIME_OVER_ERROR_MSG);
            return;
        }
        //验证劵是否被领完
        if (shopCoupon.getAmount() <= shopCoupon.getTake()) {
            resp.setCode(ResultConstant.RECEIVE_COUPON_BE_REBBED_ERROR_CODE);
            resp.setMsg(ResultConstant.RECEIVE_COUPON_BE_REBBED_ERROR_MSG);
            return;
        }
        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setCouponid(shopCoupon.getCouponid());
//        userCoupon.setProdid(shopCoupon.getProdid());
        userCoupon.setCreatetime(now);
        userCoupon.setEndtime(shopCoupon.getEndtime());
        Long no = commonMapper.querySeqNextVal(IstEnum.SeqName.USER_COUPON_NO.getSeqValue());
        userCoupon.setNo(Integer.parseInt(shopCoupon.getCouponid()+no.toString()));
        userCoupon.setShopid(shopCoupon.getShopid());
        userCoupon.setStatus(IstEnum.UserCouponStatus.NOT_USED.getStatus());
        userCoupon.setUserid(Long.valueOf(req.getUserId()));
        userCouponMapper.insertSelective(userCoupon);
        resp.setCode(ResultConstant.RECEIVE_COUPON_SUCC_CODE);
        resp.setMsg(ResultConstant.RECEIVE_COUPON_SUCC_MSG);
    }

    @Override
    public void useCoupon(UseCouponReq req, BaseResp resp) throws Exception {
        resp.setCode(ResultConstant.USE_COUPON_NO_RECORD_SUCC_CODE);
        resp.setMsg(ResultConstant.USE_COUPON_NO_RECORD_SUCC_MSG);

        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.USE_COUPON_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.USE_COUPON_TOKENID_ERROR_MSG);
            return;
        }

        UserCouponExample example = new UserCouponExample();
        UserCouponExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(Long.valueOf(req.getUserCouponId()));
        List<UserCoupon> userCoupons = userCouponMapper.selectByExample(example);
        if (userCoupons!=null && userCoupons.size()>0){
            UserCoupon userCoupon = userCoupons.get(0);
            //验证是否使用过
            if (userCoupon.getStatus().shortValue()==IstEnum.UserCouponStatus.USED.getStatus()){
                resp.setCode(ResultConstant.USE_COUPON_USED_ERROR_CODE);
                resp.setMsg(ResultConstant.USE_COUPON_USED_ERROR_MSG);
                return;
            }
            //验证是否过期
            if (userCoupon.getEndtime().before(new Date())){
                resp.setCode(ResultConstant.USE_COUPON_TIME_OVER_ERROR_CODE);
                resp.setMsg(ResultConstant.USE_COUPON_TIME_OVER_ERROR_MSG);
                return;
            }
            UserCoupon updateUserCoupon = new UserCoupon();
            updateUserCoupon.setStatus(IstEnum.UserCouponStatus.USED.getStatus());
            updateUserCoupon.setOrderid(StringUtils.isNoneBlank(req.getOrderId())?Long.valueOf(req.getOrderId()):0l);
            updateUserCoupon.setUsertime(new Date());
            userCouponMapper.updateByExampleSelective(updateUserCoupon,example);
        }else {
            resp.setCode(ResultConstant.USE_COUPON_NO_RECORD_ERROR_CODE);
            resp.setMsg(ResultConstant.USE_COUPON_NO_RECORD_ERROR_MSG);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void getShopCoupon(GetShopCouponReq req, QueryBaseResp resp) throws Exception {
        //校验token
//        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
//        userVerifyTokenReq.setTokenId(req.getTokenId());
//        userVerifyTokenReq.setUserId(req.getUserId());
//        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
//        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
//        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
//            resp.setCode(ResultConstant.GET_SHOP_COUPON_TOKENID_ERROR_CODE);
//            resp.setMsg(ResultConstant.GET_SHOP_COUPON_TOKENID_ERROR_MSG);
//            return;
//        }

        Map<String,Object> params = new HashMap<>();
        params.put("shopIds",req.getShopIds().split(","));

//        ShopCouponExample example = new ShopCouponExample();
//        ShopCouponExample.Criteria criteria = example.createCriteria();
//        criteria.andUseridEqualTo(Long.valueOf(req.getUserId()));
//        List<String> listShopIds = Arrays.asList(req.getShopIds().split(","));
//        List<Integer> intShopIds = new ArrayList<>();
//        CollectionUtils.collect(listShopIds, new Transformer() {
//            @Override
//            public Object transform(Object input) {
//                return input;
//            }
//        },intShopIds);
//        criteria.andShopidIn(intShopIds);
        if (req.getStatus()!=null){
            params.put("status",req.getStatus());
//            criteria.andStatusEqualTo(req.getStatus().shortValue());
        }
//        if (StringUtils.isNoneBlank(req.getProdId())){
//            criteria.andProdidEqualTo(Integer.parseInt(req.getProdId()));
//        }
        if (StringUtils.isNoneBlank(req.getOffTime())){
            params.put("offtime",DateUtil.formatDateStr(req.getOffTime(),DateUtil.PATTERN_DATE_TIME));
//            criteria.andOfftimeGreaterThanOrEqualTo(DateUtil.formatDateStr(req.getOffTime(),DateUtil.PATTERN_DATE_TIME));
        }
        List<ShopCoupon> shopCoupons = shopCouponMapper.selectByParams(params);
        List<GetShopCouponData> data = new ArrayList<>();
        for (ShopCoupon shopCoupon : shopCoupons){
            GetShopCouponData getShopCouponData = new GetShopCouponData();
            getShopCouponData.setAmount(shopCoupon.getAmount());
            getShopCouponData.setConditionMoney(shopCoupon.getConditionmoney().longValue());
            getShopCouponData.setCouponId(shopCoupon.getCouponid().toString());
            getShopCouponData.setCreateTime(DateUtil.getString(shopCoupon.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
            getShopCouponData.setEndTime(DateUtil.getString(shopCoupon.getEndtime(),DateUtil.PATTERN_DATE_TIME));
            getShopCouponData.setStartTime(DateUtil .getString(shopCoupon.getStarttime(),DateUtil.PATTERN_DATE_TIME));
            getShopCouponData.setShopId(shopCoupon.getShopid().toString());
            getShopCouponData.setOffTime(DateUtil.getString(shopCoupon.getOfftime(),DateUtil.PATTERN_DATE_TIME));
            getShopCouponData.setOnlineTime(DateUtil.getString(shopCoupon.getOnlinetime(),DateUtil.PATTERN_DATE_TIME));
            getShopCouponData.setMoney(shopCoupon.getMoney().longValue());
//            getShopCouponData.setProdId(shopCoupon.getProdid().toString());
            getShopCouponData.setType(shopCoupon.getType().intValue());
            getShopCouponData.setTake(shopCoupon.getTake());
            getShopCouponData.setStatus(shopCoupon.getStatus().intValue());
            getShopCouponData.setShopName(shopCoupon.getShopname());
            getShopCouponData.setCouponName(shopCoupon.getCouponname());
            getShopCouponData.setDescr(shopCoupon.getDescr());
            List<com.ist.svc.controller.model.ShopCouponProd> shopCouponProds = new ArrayList<>();
            for (ShopCouponProd shopCouponProd : shopCoupon.getShopCouponProds()){
                com.ist.svc.controller.model.ShopCouponProd scp = new com.ist.svc.controller.model.ShopCouponProd();
                scp.setCouponId(shopCouponProd.getCouponid());
                scp.setHeadImg(shopCouponProd.getHeadimg());
                scp.setProdId(shopCouponProd.getProdid());
                scp.setProdInfoId(shopCouponProd.getProdinfoid());
                scp.setProdName(shopCouponProd.getProdname());
                shopCouponProds.add(scp);
            }
            getShopCouponData.setShopCouponProds(shopCouponProds);
            data.add(getShopCouponData);
        }
        resp.setData(data);
        resp.setCode(ResultConstant.GET_SHOP_COUPON_SUCC_CODE);
        resp.setMsg(ResultConstant.GET_SHOP_COUPON_SUCC_MSG);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void useCouponOrder(UseCouponReq req, BaseResp resp) throws Exception {
        resp.setCode(ResultConstant.USE_COUPON_NO_RECORD_SUCC_CODE);
        resp.setMsg(ResultConstant.USE_COUPON_NO_RECORD_SUCC_MSG);
        UserCouponExample example = new UserCouponExample();
        UserCouponExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(Long.valueOf(req.getUserCouponId()));
        if (StringUtils.isNoneBlank(req.getCouponId())){
            criteria.andCouponidEqualTo(Integer.parseInt(req.getCouponId()));
        }
        if (StringUtils.isNoneBlank(req.getUserId())){
            criteria.andUseridEqualTo(Long.valueOf(req.getUserId()));
        }
        List<UserCoupon> userCoupons = userCouponMapper.selectByExample(example);
        if (userCoupons!=null && userCoupons.size()>0){
            UserCoupon userCoupon = userCoupons.get(0);
            //验证是否使用过
            if (userCoupon.getStatus().shortValue()==IstEnum.UserCouponStatus.USED.getStatus()){
                resp.setCode(ResultConstant.USE_COUPON_USED_ERROR_CODE);
                resp.setMsg(ResultConstant.USE_COUPON_USED_ERROR_MSG);
                return;
            }
            //验证是否过期
            if (userCoupon.getEndtime().before(new Date())){
                resp.setCode(ResultConstant.USE_COUPON_TIME_OVER_ERROR_CODE);
                resp.setMsg(ResultConstant.USE_COUPON_TIME_OVER_ERROR_MSG);
                return;
            }
            UserCoupon updateUserCoupon = new UserCoupon();
            updateUserCoupon.setStatus(IstEnum.UserCouponStatus.USED.getStatus());
            updateUserCoupon.setOrderid(StringUtils.isNoneBlank(req.getOrderId())?Long.valueOf(req.getOrderId()):0l);
            updateUserCoupon.setUsertime(new Date());
            userCouponMapper.updateByExampleSelective(updateUserCoupon,example);
        }else {
            resp.setCode(ResultConstant.USE_COUPON_NO_RECORD_ERROR_CODE);
            resp.setMsg(ResultConstant.USE_COUPON_NO_RECORD_ERROR_MSG);
        }
    }
}
