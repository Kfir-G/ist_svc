package com.ist.svc.service.impl;

import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.*;
import com.ist.svc.dao.GradeProcMapper;
import com.ist.svc.domain.GradeProc;
import com.ist.svc.domain.GradeProcExample;
import com.ist.svc.service.GradeService;
import com.ist.svc.service.UserTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: sunhaitao
 */
@Service(value = "gradeService")
public class GradeServiceImpl extends BaseServiceImpl implements GradeService {
    @Autowired
    private GradeProcMapper gradeProcMapper;
    @Autowired
    private UserTokenService userTokenService;
    @Override
    public void gradeOrder(GradeOrderReq req, BaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.GRADE_ORDER_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.GRADE_ORDER_TOKENID_ERROR_MSG);
            return;
        }
        Date now = new Date();
        if (req.getGradeOrders()!=null){
            for (GradeOrder gradeOrder : req.getGradeOrders()){
                GradeProc gradeProc = new GradeProc();
                gradeProc.setAnonym(gradeOrder.getAnonym().shortValue());
                gradeProc.setDescr(gradeOrder.getDescr());
                gradeProc.setCreatetime(now);
                gradeProc.setDeliverygrade(gradeOrder.getDeliveryGrade()!=null?gradeOrder.getDeliveryGrade().shortValue():0);
                gradeProc.setDescrgrade(gradeOrder.getDescrGrade()!=null?gradeOrder.getDescrGrade().shortValue():0);
                gradeProc.setGrade(gradeOrder.getGrade()!=null?gradeOrder.getGrade().shortValue():0);
                if (gradeOrder.getImgs()!=null && gradeOrder.getImgs().size()>0){
                    StringBuilder sb = new StringBuilder();
                    for (String img : gradeOrder.getImgs()){
                        sb.append(img).append(",");
                    }
                    gradeProc.setImgs(StringUtils.substringBeforeLast(sb.toString(),","));
                }
                gradeProc.setName(gradeOrder.getName()!=null?gradeOrder.getName():"");
                gradeProc.setNickname(gradeOrder.getNikeName()!=null?gradeOrder.getNikeName():"");
                gradeProc.setOrderid(gradeOrder.getOrderId()!=null?Long.valueOf(gradeOrder.getOrderId()):0L);
                gradeProc.setProdid(gradeOrder.getProdId()!=null?Integer.parseInt(gradeOrder.getProdId()):0);
                gradeProc.setProdinfoid(gradeOrder.getProdInfoId()!=null?Integer.parseInt(gradeOrder.getProdInfoId()):0);
                gradeProc.setServicegrade(gradeOrder.getServiceGrade()!=null?gradeOrder.getServiceGrade().shortValue():0);
                gradeProc.setDeliverygrade(gradeOrder.getDeliveryGrade()!=null?gradeOrder.getDeliveryGrade().shortValue():0);
                gradeProc.setShopid(gradeOrder.getProdInfoId()!=null?Integer.parseInt(gradeOrder.getProdInfoId()):0);
                gradeProc.setSpec(gradeOrder.getSpec()!=null?gradeOrder.getSpec():"");
                if (gradeOrder.getStartTime()!=null){
                    gradeProc.setStarttime(DateUtil.formatDateStr(gradeOrder.getStartTime(),DateUtil.PATTERN_DATE_TIME));
                }
                gradeProc.setStatus(IstEnum.GradeProcStatus.NORMAL.getStatus());
                gradeProc.setType(gradeOrder.getType()!=null?gradeOrder.getType().shortValue():0);
                gradeProc.setVideo(gradeOrder.getVideo()!=null?gradeOrder.getVideo():"");
                gradeProc.setUserid(Long.valueOf(req.getUserId()));
                gradeProc.setZannum(gradeOrder.getZanNum()!=null?gradeOrder.getZanNum().shortValue():0);
                gradeProcMapper.insertSelective(gradeProc);
            }
        }
        resp.setCode(ResultConstant.GRADE_ORDER_SUCC_CODE);
        resp.setMsg(ResultConstant.GRADE_ORDER_SUCC_MSG);
    }

    @Override
    public void getProdGradeList(GetProdGradeReq req, QueryBaseResp resp) throws Exception {
        if (StringUtils.isBlank(req.getOrderId()) && StringUtils.isBlank(req.getUserId()) && StringUtils.isBlank(req.getProdInfoId()) || StringUtils.isBlank(req.getGradeId())){
            resp.setCode(ResultConstant.PARAM_ERROR_CODE);
            resp.setMsg(ResultConstant.PARAM_ERROR_MSG + "[orderId|userId|prodInfoId]");
        }
        GradeProcExample example = new GradeProcExample();
        GradeProcExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNoneBlank(req.getProdInfoId())){
            criteria.andProdinfoidEqualTo(new BigDecimal(req.getProdInfoId()));
        }
        if (StringUtils.isNotBlank(req.getUserId())){
            criteria.andUseridEqualTo(Long.valueOf(req.getUserId()));
        }
        if (StringUtils.isNotBlank(req.getOrderId())){
            criteria.andOrderidEqualTo(Long.valueOf(req.getOrderId()));
        }
        if (StringUtils.isNotBlank(req.getGradeId())){
            criteria.andGradeidEqualTo(Long.valueOf(req.getGradeId()));
        }
        if (req.getGrade()!=null){
            criteria.andGradeEqualTo(req.getGrade().shortValue());
        }
        if (StringUtils.isNotBlank(req.getStartTime())){
            criteria.andCreatetimeGreaterThanOrEqualTo(DateUtil.formatDateStr(req.getStartTime(),DateUtil.PATTERN_DATE_TIME));
        }
        if (StringUtils.isNotBlank(req.getEndTime())){
            criteria.andCreatetimeLessThanOrEqualTo(DateUtil.formatDateStr(req.getEndTime(),DateUtil.PATTERN_DATE_TIME));
        }
        if (req.getIsHaveImg()==1){
            criteria.andImgsIsNotNull();
        }
        if (req.getIsHaveAppendDescr()==1){
            criteria.andAppenddescrIsNotNull();
        }
        if (req.getIsHaveVideo()==1){
            criteria.andVideoIsNotNull();
        }
        List<ProdGrade> data = new ArrayList<>();
        List<GradeProc> gradeProcs = gradeProcMapper.selectByExample(example);
        for (GradeProc gp : gradeProcs){
            ProdGrade prodGrade = new ProdGrade();
            prodGrade.setAnonym(gp.getAnonym().intValue());
            prodGrade.setAppendDescr(gp.getAppenddescr()!=null?gp.getAppenddescr():"");
            if (gp.getAppendtime()!=null){
                prodGrade.setAppendTime(DateUtil.getString(gp.getAppendtime(),DateUtil.PATTERN_DATE_TIME));
            }
            if (gp.getCreatetime()!=null){
                prodGrade.setCreateTime(DateUtil.getString(gp.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
            }
            prodGrade.setDescr(gp.getDescr()!=null?gp.getDescr():"");
            prodGrade.setDetailId(gp.getDetailid()!=null?gp.getDetailid().toString():"");
            if (gp.getGrade()!=null){
                prodGrade.setGrade(gp.getGrade().intValue());
            }
            prodGrade.setGradeId(gp.getGradeid().toString());
            if (StringUtils.isNoneBlank(gp.getImgs())){
                prodGrade.setImgs(Arrays.asList(gp.getImgs().split(",")));
            }
            prodGrade.setName(gp.getName()!=null?gp.getName():"");
            prodGrade.setNikeName(gp.getNickname()!=null?gp.getNickname():"");
            prodGrade.setOrderId(gp.getOrderid()!=null?gp.getOrderid().toString():"");
            prodGrade.setProdId(gp.getProdid()!=null?gp.getProdid().toString():"");
            prodGrade.setProdInfoId(gp.getProdinfoid()!=null?gp.getProdinfoid().toString():"");
            prodGrade.setReply(gp.getReply()!=null?gp.getReply():"");
            if(gp.getReplytime()!=null){
                prodGrade.setReplyTime(DateUtil.getString(gp.getReplytime(),DateUtil.PATTERN_DATE_TIME));
            }
            prodGrade.setShopId(gp.getShopid()!=null?gp.getShopid().toString():"");
            prodGrade.setSpec(gp.getSpec()!=null?gp.getSpec():"");
            if (gp.getStarttime()!=null){
                prodGrade.setStartTime(DateUtil.getString(gp.getStarttime(),DateUtil.PATTERN_DATE_TIME));
            }
            prodGrade.setUserId(gp.getUserid()!=null?gp.getUserid().toString():"");
            prodGrade.setVideo(gp.getVideo()!=null?gp.getVideo():"");
            prodGrade.setZanNum(gp.getZannum()!=null?gp.getZannum().intValue():0);
            data.add(prodGrade);
        }
        resp.setData(data);
        resp.setCode(ResultConstant.GET_PROD_GRADE_LIST_SUCC_CODE);
        resp.setMsg(ResultConstant.GET_PROD_GRADE_LIST_SUCC_MSG);
    }
}
