package com.ist.svc.service.newversion.impl;

import com.ist.svc.common.CodeConstant;
import com.ist.svc.common.RedisKeyUtil;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.common.util.RedisUtil;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.AddAcctBookReq;
import com.ist.svc.controller.model.BaseResp;
import com.ist.svc.controller.model.QueryBaseResp;
import com.ist.svc.controller.model.dto.*;
import com.ist.svc.dao.BagCheckMapper;
import com.ist.svc.dao.BagDrawMapper;
import com.ist.svc.dao.BagMapper;
import com.ist.svc.domain.*;
import com.ist.svc.service.AccountService;
import com.ist.svc.service.impl.BaseServiceImpl;
import com.ist.svc.service.newversion.BagService;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BagServiceImpl extends BaseServiceImpl implements BagService {
    private static final Long BAG_MAX_AMOUNT = 200L;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private BagMapper bagMapper;
    @Autowired
    private BagDrawMapper bagDrawMapper;
    @Autowired
    private BagCheckMapper bagCheckMapper;
    @Autowired
    private AccountService accountService;
    @Override
    public ApiBaseResp newBag(CNewBagReq cNewBagReq) {
        String talker = cNewBagReq.getTalker();
        String userId = cNewBagReq.getUserId();
        Integer type = cNewBagReq.getType();
        if ((type.shortValue()==IstEnum.BagType.ANSWER.getCode() || type.shortValue()==IstEnum.BagType.GUESS.getCode()) && StringUtils.isBlank(cNewBagReq.getAnswer())){
            return ApiBaseResp.result(ResultConstant.BAG_NEW_ANSWER_NULL_ERROR_CODE,ResultConstant.BAG_NEW_ANSWER_NULL_ERROR_MSG);
        }
        //5位随机数
        int random = (int)((Math.random()*9+1)*10000);
        String bagNo = DateUtil.getString(new Date(),"yyyyMMddHHmmss")+talker+userId+type+"0"+random;
        if (bagNo.length()!=46){
            return ApiBaseResp.result(ResultConstant.BAG_NEW_NO_ERROR_CODE,ResultConstant.BAG_NEW_NO_ERROR_MSG);
        }
        Date now = new Date();
        Bag bag = new Bag();
        bag.setAllocateType(cNewBagReq.getAllocateType().shortValue());
        bag.setAmount(cNewBagReq.getAmount().shortValue()); //个数
        bag.setBagNo(new BigDecimal(bagNo));
        bag.setCreatetime(now);
        bag.setUpdatetime(now);
        bag.setGetType(cNewBagReq.getGetType().shortValue());
        bag.setType(type.shortValue());
        bag.setMoney(cNewBagReq.getMoney());
        bag.setOnceType(cNewBagReq.getOnceType().shortValue());
        bag.setStatus(IstEnum.BagStatus.INIT.getCode());//
        bag.setTalker(Long.valueOf(talker));
        bag.setUserid(Long.valueOf(userId));//发包人
        if (StringUtils.isNotBlank(cNewBagReq.getTitle())){
            bag.setTitle(cNewBagReq.getTitle());
        }
        if (StringUtils.isNotBlank(cNewBagReq.getTip())){
            bag.setTip(cNewBagReq.getTip());
        }
        if (StringUtils.isNotBlank(cNewBagReq.getAnswer())){
            bag.setAnswer(cNewBagReq.getAnswer());
        }
        if (null!=cNewBagReq.getSubjectId()){
            bag.setSubjectId(cNewBagReq.getSubjectId().intValue());
        }
        if (StringUtils.isNotBlank(cNewBagReq.getDelayTime())){
            bag.setDelayTime(DateUtil.formatDateStr(cNewBagReq.getDelayTime(),DateUtil.PATTERN_DATE_TIME));
        }

        bag.setTransid("0");//默认0未支付
        bag.setSumMoney(cNewBagReq.getSumMoney());
        bagMapper.insertSelective(bag);
        return ApiBaseResp.succ(bagNo);
    }

    @Override
    public BaseResp uptBagStatus(UptBagStatusReq req) {
        Bag bag = bagMapper.selectByPrimaryKey(new BigDecimal(req.getBagNo()));
        if (null==bag){
            return BaseResp.result(ResultConstant.BAG_STATUS_ALREADY_ERROR_CODE,ResultConstant.BAG_STATUS_ALREADY_ERROR_MSG);
        }
        if (req.getStatus()==bag.getStatus().intValue()){
            return BaseResp.result(ResultConstant.BAG_STATUS_ALREADY_ERROR_CODE,ResultConstant.BAG_STATUS_ALREADY_ERROR_MSG);
        }
        if(IstEnum.BagStatus.PROVIDE_FINISH.getCode()==bag.getStatus() && req.getStatus()==IstEnum.BagStatus.MOT_PROVIDE_FEFUND.getCode()){
            return BaseResp.result(ResultConstant.BAG_STATUS_REFUND_ERROR_CODE,ResultConstant.BAG_STATUS_REFUND_ERROR_MSG);
        }
        Bag updateBag = new Bag();
        updateBag.setBagNo(bag.getBagNo());
        updateBag.setStatus(req.getStatus().shortValue());
        updateBag.setUpdatetime(new Date());
        String transId = req.getTransId();
        if (StringUtils.isNotBlank(transId)){
            updateBag.setTransid(transId);
        }
        bagMapper.updateByPrimaryKeySelective(updateBag);
        return BaseResp.ok();
    }

    @Override
    public ApiBaseResp queryBagByNo(QueryBagByNoReq req) {
        BagInfo bagInfo = new BagInfo();
        Bag bag = bagMapper.selectByPrimaryKey(req.getBagNo());
        bagInfo.setAllocateType(bag.getAllocateType().intValue());
        bagInfo.setAmount(bag.getAmount().intValue());
        bagInfo.setBagNo(req.getBagNo());
        bagInfo.setCreateTime(DateUtil.getString(bag.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
        bagInfo.setGetType(bag.getGetType().intValue());
        bagInfo.setMoney(bag.getMoney());
        bagInfo.setOnceType(bag.getOnceType().intValue());
        bagInfo.setStatus(bag.getStatus().intValue());
        if (null!=bag.getSubjectId()){
            bagInfo.setSubjectId(bag.getSubjectId().longValue());
        }
        bagInfo.setSumMoney(bag.getSumMoney());
        bagInfo.setTalker(bag.getTalker().toString());
        bagInfo.setType(bag.getType().intValue());
        bagInfo.setUpdateTime(DateUtil.getString(bag.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
        bagInfo.setUserId(bag.getUserid().toString());
        bagInfo.setTip(bag.getTip());
        bagInfo.setTitle(bag.getTitle());
        bagInfo.setAnswer(bag.getAnswer());
        return ApiBaseResp.succ(bagInfo);
    }

    @Override
    public ApiBaseResp queryBagDrawByNo(QueryBagDrawByNoReq req) {
        BagDrawExample example = new BagDrawExample();
        BagDrawExample.Criteria criteria = example.createCriteria();
        criteria.andBagNoEqualTo(req.getBagNo());
        List<BagDraw> bagDraws = bagDrawMapper.selectByExample(example);
        List<BagDrawInfo> bagDrawInfos = new ArrayList<>();
        for (BagDraw bagDraw : bagDraws){
            BagDrawInfo bagDrawInfo = new BagDrawInfo();
            bagDrawInfo.setAnswer(bagDraw.getAnswer());
            bagDrawInfo.setCreateTime(DateUtil.getString(bagDraw.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
            bagDrawInfo.setDrawMoney(bagDraw.getDrawMoney());
            bagDrawInfo.setDrawUser(bagDraw.getDrawUser());
            bagDrawInfo.setStatus(bagDraw.getStatus());
            bagDrawInfo.setUpdateTime(DateUtil.getString(bagDraw.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
            bagDrawInfos.add(bagDrawInfo);
        }
        return ApiBaseResp.succ(bagDraws);
    }

    @Override
    public ApiBaseResp drawBag(DrawBagReq req) {
        //同一个用户和红包编号一样并发请求判断
        String redisKey = RedisKeyUtil.getBagDrawConcurrentUiBagNo(req.getUserId(),req.getBagNo()+"");
        if (redisUtil.hasKey(redisKey)){
            return ApiBaseResp.result(ResultConstant.DRAW_BAG_REPEAT_REQ_ERROR_CODE,ResultConstant.DRAW_BAG_REPEAT_REQ_ERROR_MSG);
        }

        redisUtil.set(redisKey,"1",CodeConstant.REDIS_SAVE_TIME_5S);
        //redisUtil.del(RedisKeyUtil.getBagRedisKey(req.getBagNo()+""));
        //检查talker是否包含userId
        Bag bag = (Bag) redisUtil.get(RedisKeyUtil.getBagRedisKey(req.getBagNo()+""));
        if (null==bag){
            BagExample bagExample = new BagExample();
            BagExample.Criteria criteriaBag = bagExample.createCriteria();
            criteriaBag.andBagNoEqualTo(req.getBagNo());
//        criteriaBag.andTalkerEqualTo(Long.valueOf(req.getUserId()));
            List<Bag> bags = bagMapper.selectByExample(bagExample);
            if (bags==null || bags.isEmpty()){
                //不存在
                return ApiBaseResp.result(ResultConstant.DRAW_BAG_NOT_EXSIT_ERROR_CODE,ResultConstant.DRAW_BAG_NOT_EXSIT_ERROR_MSG);
            }else{
                bag = bags.get(0);
            }
        }
        if (bag.getStatus()==IstEnum.BagStatus.INIT.getCode()){
            //状态未支付
            return ApiBaseResp.result(ResultConstant.DRAW_BAG_NOT_PAY_ERROR_CODE,ResultConstant.DRAW_BAG_NOT_PAY_ERROR_MSG);
        }
        if (bag.getStatus()==IstEnum.BagStatus.PROVIDE_FINISH.getCode()){
            //已领取完
            return ApiBaseResp.result(ResultConstant.DRAW_BAG_FINISH_ERROR_CODE,ResultConstant.DRAW_BAG_FINISH_ERROR_MSG);
        }
        if (bag.getStatus()==IstEnum.BagStatus.MOT_PROVIDE_FEFUND.getCode() || bag.getStatus()==IstEnum.BagStatus.FEFUND_ALL.getCode()){
            //未发放部分已退款
            return ApiBaseResp.result(ResultConstant.DRAW_BAG_TIME_OUT_ERROR_CODE,ResultConstant.DRAW_BAG_TIME_OUT_ERROR_MSG);
        }

        //竞猜和答题红包需要验证answer是否为空
        if ((bag.getType()==IstEnum.BagType.GUESS.getCode() || bag.getType()==IstEnum.BagType.ANSWER.getCode()) && StringUtils.isBlank(req.getAnswer())){
            return ApiBaseResp.result(ResultConstant.DRAW_BAG_ANSWER_NULL_ERROR_CODE,ResultConstant.DRAW_BAG_ANSWER_NULL_ERROR_MSG);
        }
        //红包放入缓存
        redisUtil.set(RedisKeyUtil.getBagRedisKey(req.getBagNo()+""),bag,CodeConstant.REDIS_SAVE_TIME_24h);
        Integer redisAmount = 0 ;
        //查询领取记录 先从缓存获取
//        Integer redisAmount = (Integer) redisUtil.get(RedisKeyUtil.getBagDrawAmountFromRedis(req.getBagNo()+""));
//        if (redisAmount==null){
//            BagDrawExample bagDrawExample = new BagDrawExample();
//            BagDrawExample.Criteria criteriaBagDraw = bagDrawExample.createCriteria();
//            criteriaBagDraw.andStatusEqualTo(IstEnum.BagDrawStatus.DRAW_SUCC.getCode());
//            criteriaBagDraw.andBagNoEqualTo(req.getBagNo());
//            List<BagDraw> bagDraws = bagDrawMapper.selectByExample(bagDrawExample);
//            redisAmount = bagDraws.size();
//
//            if (bagDraws!=null && bag.getAmount()!=-1 && redisAmount >= bag.getAmount().intValue()){
//                redisUtil.set(RedisKeyUtil.getBagDrawAmountFromRedis(req.getBagNo()+""),redisAmount, CodeConstant.REDIS_SAVE_TIME_24h);
//                //已领取完
//                return ApiBaseResp.result(ResultConstant.DRAW_BAG_FINISH_ERROR_CODE,ResultConstant.DRAW_BAG_FINISH_ERROR_MSG);
//            }
//        }else if (bag.getAmount()!=-1 && redisAmount>=bag.getAmount().intValue()){
//            redisUtil.set(RedisKeyUtil.getBagDrawAmountFromRedis(req.getBagNo()+""),redisAmount, CodeConstant.REDIS_SAVE_TIME_24h);
//            //已领取完
//            return ApiBaseResp.result(ResultConstant.DRAW_BAG_FINISH_ERROR_CODE,ResultConstant.DRAW_BAG_FINISH_ERROR_MSG);
//        }
//        if (bag.getOnceType()==IstEnum.BagOnceType.ONCE_LIMIT.getCode().shortValue()){
        //查看该用户是否已经领取过 先从缓存查
//        BagDraw bagDrawRedis = (BagDraw) redisUtil.get(RedisKeyUtil.getBagDrawRecordKey(req.getBagNo(),req.getUserId()));
//        if (bagDrawRedis!=null){
//            return ApiBaseResp.result(ResultConstant.DRAW_BAG_RECORD_IS_EXIST_ERROR_CODE,ResultConstant.DRAW_BAG_RECORD_IS_EXIST_ERROR_MSG,bagDrawRedis);
//        }else
        if (bag.getType()==IstEnum.BagType.ANSWER.getCode()){
            if (!req.getAnswer().equalsIgnoreCase(bag.getAnswer())){
                return ApiBaseResp.result(ResultConstant.DRAW_BAG_ANSWER_ERROR_CODE,ResultConstant.DRAW_BAG_ANSWER_ERROR_MSG);
            }
            if (bag.getAllocateType()==IstEnum.BagAllocateType.AVERAGE.getBagAllocateType() && bag.getAllocateType()==IstEnum.BagAllocateType.RANDOM.getBagAllocateType()){
                return ApiBaseResp.result(ResultConstant.DRAW_BAG_ALLOCATE_ERROR_CODE,ResultConstant.DRAW_BAG_ALLOCATE_ERROR_MSG);
            }
        }
        List<BagDraw> bagDraws = (List<BagDraw>) redisUtil.get(RedisKeyUtil.getBagDrawRecordsFromRedis(req.getBagNo() + ""));
        if (bagDraws==null || bagDraws.size()==0){
            BagDrawExample bagDrawExample = new BagDrawExample();
            BagDrawExample.Criteria criteria = bagDrawExample.createCriteria();
            criteria.andBagNoEqualTo(req.getBagNo());
            bagDraws = bagDrawMapper.selectByExample(bagDrawExample);
            if (bag.getOnceType()!=-1 &&  bagDraws!=null && bagDraws.size()>0){
                redisUtil.set(RedisKeyUtil.getBagDrawRecordsFromRedis(req.getBagNo() + ""),bagDraws,CodeConstant.REDIS_SAVE_TIME_24h);
//                List<BagDraw> collectUser = bagDraws.stream().filter(item -> item.getDrawUser().longValue() == Long.valueOf(req.getUserId()).longValue()).collect(Collectors.toList());
//                List<BagDraw> collectSucc = bagDraws.stream().filter(item -> item.getStatus().shortValue() == IstEnum.BagDrawStatus.DRAW_SUCC.getCode()).collect(Collectors.toList());
//                if (collectSucc!=null && bag.getAmount()!=-1 && collectSucc.size() >= bag.getAmount().intValue()){
//                    redisAmount = collectSucc.size();
//                    //已领取完
//                    return ApiBaseResp.result(ResultConstant.DRAW_BAG_FINISH_ERROR_CODE,ResultConstant.DRAW_BAG_FINISH_ERROR_MSG);
//                }

                for (BagDraw bagDrawTemp : bagDraws){
                    if (bagDrawTemp.getStatus()==IstEnum.BagDrawStatus.DRAW_SUCC.getCode()){
                        redisAmount++;
                    }
                    //判断是否领取完
                    if (bag.getAmount()!=-1 && redisAmount >= bag.getAmount().intValue()){
                        //已领取完
                        return ApiBaseResp.result(ResultConstant.DRAW_BAG_FINISH_ERROR_CODE,ResultConstant.DRAW_BAG_FINISH_ERROR_MSG);
                    }
                    //判断用户是否已领取过
                    if (bagDrawTemp.getDrawUser().longValue() == Long.valueOf(req.getUserId()).longValue()){
                        if (bagDrawTemp.getStatus()==IstEnum.BagDrawStatus.DRAW_SUCC.getCode()){
                            return ApiBaseResp.result(ResultConstant.DRAW_BAG_RECORD_IS_EXIST_ERROR_CODE,ResultConstant.DRAW_BAG_RECORD_IS_EXIST_ERROR_MSG,bagDrawTemp);
                        }
                        if (bag.getOnceType()==1 && bagDrawTemp.getStatus()!=IstEnum.BagDrawStatus.DRAW_SUCC.getCode()){
                            return ApiBaseResp.result(ResultConstant.DRAW_BAG_RECORD_IS_EXIST_ERROR_CODE,ResultConstant.DRAW_BAG_RECORD_IS_EXIST_ERROR_MSG,bagDrawTemp);
                        }
                        if (bag.getOnceType()>1 && bagDrawTemp.getStatus()!=IstEnum.BagDrawStatus.DRAW_SUCC.getCode() && bagDraws.size() >= bag.getOnceType()){
                            return ApiBaseResp.result(ResultConstant.DRAW_BAG_RECORD_ONECE_TYPE_LIMIT_ERROR_CODE,ResultConstant.DRAW_BAG_RECORD_ONECE_TYPE_LIMIT_ERROR_MSG,bagDrawTemp);
                        }
                    }
                }
            }
        }else{
            for (BagDraw bagDrawTemp : bagDraws){
                if (bagDrawTemp.getStatus()==IstEnum.BagDrawStatus.DRAW_SUCC.getCode()){
                    redisAmount++;
                }
                if (bag.getAmount()!=-1 && redisAmount >= bag.getAmount().intValue()){
                    //已领取完
                    return ApiBaseResp.result(ResultConstant.DRAW_BAG_FINISH_ERROR_CODE,ResultConstant.DRAW_BAG_FINISH_ERROR_MSG);
                }
                if (bagDrawTemp.getDrawUser().longValue() == Long.valueOf(req.getUserId()).longValue()){
                    if (bagDrawTemp.getStatus()==IstEnum.BagDrawStatus.DRAW_SUCC.getCode()){
                        return ApiBaseResp.result(ResultConstant.DRAW_BAG_RECORD_IS_EXIST_ERROR_CODE,ResultConstant.DRAW_BAG_RECORD_IS_EXIST_ERROR_MSG,bagDrawTemp);
                    }
                    if (bag.getOnceType()==1 && bagDrawTemp.getStatus()!=IstEnum.BagDrawStatus.DRAW_SUCC.getCode()){
                        return ApiBaseResp.result(ResultConstant.DRAW_BAG_RECORD_IS_EXIST_ERROR_CODE,ResultConstant.DRAW_BAG_RECORD_IS_EXIST_ERROR_MSG,bagDrawTemp);
                    }
                    if (bag.getOnceType()>1 && bagDrawTemp.getStatus()!=IstEnum.BagDrawStatus.DRAW_SUCC.getCode() && bagDraws.size() >= bag.getOnceType()){
                        return ApiBaseResp.result(ResultConstant.DRAW_BAG_RECORD_ONECE_TYPE_LIMIT_ERROR_CODE,ResultConstant.DRAW_BAG_RECORD_ONECE_TYPE_LIMIT_ERROR_MSG,bagDrawTemp);
                    }
                }
            }
        }
        //可以领
        BagDraw bagDraw = dealDrawBag(req, bag, redisAmount);
        if (bagDraw.getStatus()==IstEnum.BagDrawStatus.DRAW_SUCC.getCode()||bagDraw.getStatus()==IstEnum.BagDrawStatus.NO_SUCC_DRAW.getCode()){
            bagDraws.add(bagDraw);
            redisUtil.set(RedisKeyUtil.getBagDrawRecordsFromRedis(req.getBagNo() + ""),bagDraws,CodeConstant.REDIS_SAVE_TIME_24h);
        }
        if (bagDraw.getStatus()==IstEnum.BagDrawStatus.NO_SUCC_DRAW.getCode() && bag.getType()==IstEnum.BagType.GUESS.getCode()){
            long answer = Float.valueOf(bag.getAnswer()).longValue();
            long userAnswer = Float.valueOf(req.getAnswer()).longValue();
            if (answer==userAnswer){
                return ApiBaseResp.result(ResultConstant.DRAW_BAG_RECORD_GUESS_SUCC_CODE,ResultConstant.DRAW_BAG_RECORD_GUESS_SUCC_MSG,bagDraw);
            }
            if(bag.getStatus()!=IstEnum.BagStatus.PROVIDEING.getCode()){
                //更新为发放中
                BagExample bagExample = new BagExample();
                BagExample.Criteria criteriaBag = bagExample.createCriteria();
                criteriaBag.andBagNoEqualTo(bag.getBagNo());
                Bag updateBag = new Bag();
                updateBag.setStatus(IstEnum.BagStatus.PROVIDEING.getCode());
                bagMapper.updateByExampleSelective(updateBag,bagExample);
            }
        }
        return ApiBaseResp.succ(bagDraw);
    }

    @Override
    public ApiBaseResp queryBagsByUserId(CQueryBagsByUserIdReq req) {
        BagExample bagExample = new BagExample();
        BagExample.Criteria criteria = bagExample.createCriteria();
        criteria.andUseridEqualTo(Long.valueOf(req.getUserId()));
        if (StringUtils.isNotBlank(req.getBeginDate())){
            criteria.andCreatetimeGreaterThanOrEqualTo(DateUtil.formatDateStr(req.getBeginDate(),DateUtil.PATTERN_DATE_TIME));
        }
        if (StringUtils.isNotBlank(req.getEndDate())){
            criteria.andCreatetimeLessThanOrEqualTo(DateUtil.formatDateStr(req.getEndDate(),DateUtil.PATTERN_DATE_TIME));
        }
        List<BagInfo> bagInfos = new ArrayList<>();
        List<Bag> bags = bagMapper.selectByExample(bagExample);
        bags.forEach(bag -> {
            BagInfo bagInfo = new BagInfo();
            bagInfo.setAllocateType(bag.getAllocateType().intValue());
            bagInfo.setAmount(bag.getAmount().intValue());
            bagInfo.setBagNo(bag.getBagNo());
            bagInfo.setCreateTime(DateUtil.getString(bag.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
            bagInfo.setGetType(bag.getGetType().intValue());
            bagInfo.setMoney(bag.getMoney());
            bagInfo.setOnceType(bag.getOnceType().intValue());
            bagInfo.setStatus(bag.getStatus().intValue());
            if (null!=bag.getSubjectId()){
                bagInfo.setSubjectId(bag.getSubjectId().longValue());
            }
            bagInfo.setSumMoney(bag.getSumMoney());
            bagInfo.setTalker(bag.getTalker().toString());
            bagInfo.setType(bag.getType().intValue());
            bagInfo.setUpdateTime(DateUtil.getString(bag.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
            bagInfo.setUserId(bag.getUserid().toString());
            bagInfo.setAnswer(bag.getAnswer());
            bagInfos.add(bagInfo);
        });
        return ApiBaseResp.succ(bagInfos);
    }

    @Override
    public ApiBaseResp queryBagDrawsByUserId(CQueryBagDrawsByUserIdReq req) {
        BagDrawExample example = new BagDrawExample();
        BagDrawExample.Criteria criteria = example.createCriteria();
        criteria.andDrawUserEqualTo(Long.valueOf(req.getUserId()));
        if (StringUtils.isNotBlank(req.getBeginDate())){
            criteria.andCreatetimeGreaterThanOrEqualTo(DateUtil.formatDateStr(req.getBeginDate(),DateUtil.PATTERN_DATE_TIME));
        }
        if (StringUtils.isNotBlank(req.getEndDate())){
            criteria.andCreatetimeLessThanOrEqualTo(DateUtil.formatDateStr(req.getEndDate(),DateUtil.PATTERN_DATE_TIME));
        }
        List<BagDraw> bagDraws = bagDrawMapper.selectByExample(example);
        List<BagDrawInfo> bagDrawInfos = new ArrayList<>();
        for (BagDraw bagDraw : bagDraws){
            BagDrawInfo bagDrawInfo = new BagDrawInfo();
            bagDrawInfo.setAnswer(bagDraw.getAnswer());
            bagDrawInfo.setCreateTime(DateUtil.getString(bagDraw.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
            bagDrawInfo.setDrawMoney(bagDraw.getDrawMoney());
            bagDrawInfo.setDrawUser(bagDraw.getDrawUser());
            bagDrawInfo.setStatus(bagDraw.getStatus());
            bagDrawInfo.setUpdateTime(DateUtil.getString(bagDraw.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
            bagDrawInfos.add(bagDrawInfo);
        }
        return ApiBaseResp.succ(bagDrawInfos);
    }

    /**
     * 领取红包具体逻辑
     * @param req
     * @param bag
     * @param redisAmount
     */
    public BagDraw dealDrawBag(DrawBagReq req, Bag bag, Integer redisAmount) {
        BagDraw bagDraw = null;
        String redisKey = RedisKeyUtil.getBagDrawConcurrentBagNo(req.getBagNo()+"");
        while (true){
            if (redisUtil.setNX(redisKey,1)){
                // 上锁成功
                redisUtil.expire(redisKey, 2*60);// 设置超时时间 2s
                try {
                    String bagNo = req.getBagNo().toString();
                    if (bag.getType()== IstEnum.BagType.NORMAL.getCode()){
                        float remainMoney = bag.getSumMoney() - bag.getMoney()*redisAmount;
                        bagDraw = allocationBagDetail(bagNo, Long.valueOf(req.getUserId()), bag.getMoney(), redisAmount, bag.getAmount().intValue(), bag.getSumMoney(), remainMoney);
                    }else if (bag.getType()==IstEnum.BagType.LUCK.getCode()){
                        //计算分配金额
                        int remainSize = bag.getAmount().intValue()-redisAmount;//剩余多少个
                        Object o = redisUtil.get(RedisKeyUtil.getBagBalanceMoneyKey(bagNo));
                        Float remainMoney = null;
                        if (o!=null){
                            remainMoney = ((Double) o).floatValue();
                        }
                        if (null==remainMoney){
                            //需要查询数据库
                            Float drawMonety = bagDrawMapper.selectSumDrawMoney(new BigDecimal(bagNo));
                            if (null==drawMonety){
                                drawMonety = Float.valueOf(0);
                            }
                            remainMoney = bag.getSumMoney()-drawMonety;//剩余多少钱
                        }
//                        float remainMoney = bag.getSumMoney()-redisAmount*bag.getMoney();//剩余多少钱
                        Double bagMoney = getRandomMoney(remainSize,remainMoney);
                        bagDraw = allocationBagDetail(bagNo,Long.valueOf(req.getUserId()), bagMoney.floatValue(), redisAmount,bag.getAmount().intValue(),bag.getSumMoney(),remainMoney);
                    }
                    else if (bag.getType()==IstEnum.BagType.GUESS.getCode()){
                        //判断是否是有效竞猜
                        long answer = Float.valueOf(bag.getAnswer()).longValue();
                        long userAnswer = Float.valueOf(req.getAnswer()).longValue();
                        //如果是有效竞猜则插入
                        bagDraw = getMinAndMaxByBagNo(bag.getBagNo(),userAnswer,answer,req.getUserId());
                        if (answer==userAnswer){
                            //先更新红包状态为已发放完
                            //更新bag状态为发放完
                            Bag bagUpdate = new Bag();
                            bagUpdate.setStatus(IstEnum.BagStatus.PROVIDE_FINISH.getCode());
                            BagExample example = new BagExample();
                            BagExample.Criteria criteria = example.createCriteria();
                            criteria.andBagNoEqualTo(bag.getBagNo());
                            criteria.andUpdatetimeEqualTo(new Date());
                            bagMapper.updateByExample(bagUpdate,example);
                            dealAllocation(bag.getBagNo(),bag.getSumMoney(),answer);
                        }
                    }
                    else if (bag.getType()==IstEnum.BagType.ANSWER.getCode()){
                        if (bag.getAllocateType()==IstEnum.BagAllocateType.AVERAGE.getBagAllocateType()){
                            float remainMoney = bag.getSumMoney() - bag.getMoney()*redisAmount;
                            bagDraw = allocationBagDetail(bagNo, Long.valueOf(req.getUserId()), bag.getMoney(), redisAmount, bag.getAmount().intValue(), bag.getSumMoney(), remainMoney);
                        }else if (bag.getAllocateType()==IstEnum.BagAllocateType.RANDOM.getBagAllocateType()){
                            //计算分配金额
                            int remainSize = bag.getAmount().intValue()-redisAmount;//剩余多少个
                            Double doubleTemp = ((Double) redisUtil.get(RedisKeyUtil.getBagBalanceMoneyKey(bagNo)));
                            Float remainMoney = null;
                            if (null!=doubleTemp){
                                remainMoney = remainMoney.floatValue();
                            }
                            if (null==remainMoney){
                                //需要查询数据库
                                Float drawMonety = bagDrawMapper.selectSumDrawMoney(new BigDecimal(bagNo));
                                if (null==drawMonety){
                                    drawMonety = Float.valueOf(0);
                                }
                                remainMoney = bag.getSumMoney()-drawMonety;//剩余多少钱
                            }
//                        float remainMoney = bag.getSumMoney()-redisAmount*bag.getMoney();//剩余多少钱
                            Double bagMoney = getRandomMoney(remainSize,remainMoney);
                            bagDraw = allocationBagDetail(bagNo,Long.valueOf(req.getUserId()), bagMoney.floatValue(), redisAmount,bag.getAmount().intValue(),bag.getSumMoney(),remainMoney);
                        }
                    }
                    redisUtil.del(redisKey);
                }catch (Exception e){
                    logger.error("dealDrawBag.err:",e);
                    redisUtil.del(redisKey);
                }
                break;
            }
        }
        return bagDraw;
    }

    private void dealAllocation(BigDecimal bagNo, Float sumMoney, long answer) {
        String bagEffectDrawByBagNo = RedisKeyUtil.getBagEffectDrawByBagNo(bagNo.toString());
        List<BagDraw> bagDrawsRedis = (List<BagDraw>) redisUtil.get(bagEffectDrawByBagNo);
        if (null==bagDrawsRedis){
            BagDrawExample example = new BagDrawExample();
            BagDrawExample.Criteria criteria = example.createCriteria();
            criteria.andBagNoEqualTo(bagNo);
            criteria.andStatusEqualTo(IstEnum.BagDrawStatus.NO_SUCC_DRAW.getCode());
            example.setOrderByClause(" id ase");
            bagDrawsRedis = bagDrawMapper.selectByExample(example);
        }
        Float a = sumMoney*0.6f;//排除量维度 50%系数
        Float b = sumMoney*0.4f; //顺位维度  50%系数
        int size = bagDrawsRedis.size();
        int[] excluNumArr = new int[size]; //记录每人排除量
        int totalExclu = 0;
        for (int index=0;index<size;index++){
            BagDraw bagDraw = bagDrawsRedis.get(index);

            int userAnswer = Integer.parseInt(bagDraw.getAnswer());
            boolean flag = false;
            //与前面所有记录比较
            for (int i = index-1;i>=0;i--){
                int answerI = Integer.valueOf(bagDrawsRedis.get(i).getAnswer());
                //与前面的每个都大于目标值的记录比较 找到则退出
                if(answerI > answer && userAnswer>=answer){
                    if (userAnswer<answerI){
                        excluNumArr[index] = answerI-userAnswer;
                    }else {
                        excluNumArr[index] = 0;
                    }
                    flag = true;
                    break;
                }
                //与前面的每个都小于目标值的记录比较
                if (answerI < answer && userAnswer<=answer){
                    flag = true;
                    if (userAnswer>answerI){
                        excluNumArr[index] = userAnswer - answerI;
                    }else {
                        excluNumArr[index] = 0;
                    }
                    flag = true;
                    break;
                }

            }
            //没有找到首尾二条与边界值比较
            if (flag==false){
                if (userAnswer>answer){
                    excluNumArr[index] = 200-userAnswer+1;
                }else if (userAnswer<answer){
                    excluNumArr[index] = userAnswer - 0;
                }else{
                    excluNumArr[index] = 200;
                }
            }
            totalExclu += excluNumArr[index];
        }
        Double[] allocaMoneyArr = new Double[size];
        int bIndex = 1;
        int totalSize = (1+size)*size/2;//递增求和计算公式
        double excloudLast = 0;//除了最后一个所有加一起总和
        for (int temp : excluNumArr){
            //第一维度占比
            double a1 = new BigDecimal((float)temp/totalExclu).setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
//            float a1 = Double.valueOf(temp)/totalExclu;
            ////第二维度占比
//            float b1 = Float.valueOf(bIndex)/totalSize;
            double b1 = new BigDecimal((float)bIndex/totalSize).setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
            allocaMoneyArr[bIndex-1] = new BigDecimal(a1*a + b1*b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (bIndex==size && excloudLast+allocaMoneyArr[bIndex-1]!=sumMoney){
                allocaMoneyArr[bIndex-1] = sumMoney - excloudLast;
            }else {
                excloudLast+=allocaMoneyArr[bIndex-1];
            }

            bIndex++;
        }
        logger.info("allocaMoneyArr:{},totalExclu:{}" + Arrays.toString(allocaMoneyArr),totalExclu);
        for (int index=0;index<size;index++){
            BagDraw bagDraw = bagDrawsRedis.get(index);
            bagDraw.setStatus(IstEnum.BagDrawStatus.DRAW_SUCC.getCode());
            bagDraw.setDrawMoney(allocaMoneyArr[index].floatValue());
            bagDrawsRedis.set(index,bagDraw);
        }
        //批量入库
        bagDrawMapper.batchInsert(bagDrawsRedis);
    }

    //获取有效范围
    private BagDraw getMinAndMaxByBagNo(BigDecimal bagNo, long userAnswer, long answer, String userId) {
        List<BagDraw> bagDraws = null;
        BagDraw bagDraw;
        String bagSectionMinMaxBagNoKey = RedisKeyUtil.getBagSectionMinMaxBagNo(bagNo.toString());
        String result = (String) redisUtil.get(bagSectionMinMaxBagNoKey);
        if (result==null){
            BagDrawExample example = new BagDrawExample();
            BagDrawExample.Criteria criteria = example.createCriteria();
            criteria.andBagNoEqualTo(bagNo);
            criteria.andStatusEqualTo(IstEnum.BagDrawStatus.NO_SUCC_DRAW.getCode());
            bagDraws = bagDrawMapper.selectByExample(example);
            if (bagDraws==null || bagDraws.size()==0){
                result =  "1," + BAG_MAX_AMOUNT;
            }else if (bagDraws.size()==1){
                Long dbAnswer = Long.valueOf(bagDraws.get(0).getAnswer()); //30
                if (dbAnswer>answer){
                    result = "1,"  + "," + dbAnswer;
                }else{
                    result = dbAnswer + "," + BAG_MAX_AMOUNT;
                }
            }else{
                long min = 1;
                long max = 200;
                for (BagDraw draw : bagDraws){
                    Long aLong = Long.valueOf(draw.getAnswer());
                    if (aLong>answer && max>aLong){
                        max = aLong;
                    }else if (aLong<answer && min<aLong){
                        min = aLong;
                    }
                }
                result = min + "," + max;
            }
        }
        Date now = new Date();
        bagDraw = new BagDraw();
        bagDraw.setBagNo(bagNo);
        bagDraw.setCreatetime(now);
        bagDraw.setUpdatetime(now);
        bagDraw.setDrawUser(Long.valueOf(userId));
        bagDraw.setDrawMoney(0F);
        bagDraw.setAnswer(userAnswer+"");
        String[] split = result.split(",");
        if (userAnswer < Long.valueOf(split[0]) || Long.valueOf(split[1]) < userAnswer){
            //无效竞猜
            bagDraw.setStatus(IstEnum.BagDrawStatus.NOT_EFFECTIVE.getCode());
        }else {
            //有效竞猜
            bagDraw.setStatus(IstEnum.BagDrawStatus.NO_SUCC_DRAW.getCode());

            if (userAnswer>answer){
                result = split[0] + "," + userAnswer;
            }else{
                result = userAnswer+ "," + split[1];
            }
        }
        bagDrawMapper.insertSelective(bagDraw);
        String bagEffectDrawByBagNo = RedisKeyUtil.getBagEffectDrawByBagNo(bagNo.toString());
        List<BagDraw> bagDrawsRedis = (List<BagDraw>) redisUtil.get(bagEffectDrawByBagNo);
        if (bagDrawsRedis==null){
            bagDraws = new ArrayList<>();
            //查询数据库
            if (bagDraws==null){
                BagDrawExample example = new BagDrawExample();
                BagDrawExample.Criteria criteria = example.createCriteria();
                criteria.andBagNoEqualTo(bagNo);
                criteria.andStatusEqualTo(IstEnum.BagDrawStatus.NO_SUCC_DRAW.getCode());
                bagDrawsRedis = bagDrawMapper.selectByExample(example);
            }else{
                bagDrawsRedis = bagDraws;
            }
        }
        bagDrawsRedis.add(bagDraw);
        redisUtil.set(bagEffectDrawByBagNo,bagDrawsRedis,CodeConstant.REDIS_SAVE_TIME_24h);
        redisUtil.set(bagSectionMinMaxBagNoKey,result,CodeConstant.REDIS_SAVE_TIME_24h);
        return bagDraw;
    }

    public BagDraw allocationBagDetail(String bagNo,long userId,float drawMoney,Integer redisAmount,Integer bagAmount,float sumMoney,float remainMoney) {
        Integer blanceAmount = bagAmount - redisAmount;
        Date now = new Date();
        BagDraw bagDraw = new BagDraw();
        bagDraw.setBagNo(new BigDecimal(bagNo));
        bagDraw.setBlanceAmount(blanceAmount.shortValue());
        bagDraw.setCreatetime(now);
        bagDraw.setUpdatetime(now);
        bagDraw.setBlanceMoney(remainMoney);
        bagDraw.setDrawUser(userId);
        bagDraw.setStatus(IstEnum.BagDrawStatus.DRAW_SUCC.getCode());
        bagDraw.setDrawMoney(drawMoney);
        bagDrawMapper.insertSelective(bagDraw);
        redisAmount++;

        //打款
        AddAcctBookReq addAcctBookReq = new AddAcctBookReq();
        addAcctBookReq.setDirect(1);
        addAcctBookReq.setUserId(userId+"");
        addAcctBookReq.setMoney(drawMoney);
        addAcctBookReq.setAcctType(IstEnum.AcctType.CASH.getType());
        addAcctBookReq.setOptUserId(userId+"");
        addAcctBookReq.setPayType(IstEnum.PayType.INSIDE.getCode());
        addAcctBookReq.setOrderId("0");
        addAcctBookReq.setStatus(1);
        addAcctBookReq.setBizType((int) IstEnum.BookBizType.BAG.getCode());
        addAcctBookReq.setDescr("红包");
        QueryBaseResp queryBaseResp = new QueryBaseResp();
        accountService.recordAcctBook(addAcctBookReq,queryBaseResp);
        if (redisAmount==bagAmount && bagAmount!=-1){
            //更新红包状态为发放完
            Bag updateBag = new Bag();
            updateBag.setBagNo(new BigDecimal(bagNo));
            updateBag.setStatus(IstEnum.BagStatus.PROVIDE_FINISH.getCode());
            bagMapper.updateByPrimaryKeySelective(updateBag);
            redisUtil.del(RedisKeyUtil.getBagRedisKey(bagNo));

            //插入对账
            BagCheck bagCheck = new BagCheck();
            bagCheck.setBagNo(new BigDecimal(bagNo));
            bagCheck.setAmount(redisAmount.shortValue());
            bagCheck.setBackMoney((float) 0);
            bagCheck.setCreatetime(now);
            bagCheck.setMoney(sumMoney);
            bagCheck.setDrawMoney(sumMoney);
            bagCheck.setResult(IstEnum.BagCheckResult.NORMAL.getCode());
            bagCheck.setUpdatetime(now);
            bagCheckMapper.insertSelective(bagCheck);
        }
        redisUtil.set(RedisKeyUtil.getBagDrawAmountFromRedis(bagNo),redisAmount, CodeConstant.REDIS_SAVE_TIME_24h);
        Float lastRemainMoney = remainMoney-drawMoney;
        redisUtil.set(RedisKeyUtil.getBagBalanceMoneyKey(bagNo),lastRemainMoney,CodeConstant.REDIS_SAVE_TIME_24h);
        return bagDraw;
    }

//    public void allocationBagDetail(DrawBagReq req, Bag bag, Integer redisAmount) {
//        Date now = new Date();
//        BagDraw bagDraw = new BagDraw();
//        bagDraw.setBagNo(req.getBagNo());
//        bagDraw.setBlanceAmount((short) (bag.getAmount().intValue()-redisAmount));
//        bagDraw.setCreatetime(now);
//        bagDraw.setUpdatetime(now);
//        bagDraw.setBlanceMoney(bag.getSumMoney()-redisAmount*bag.getMoney());
//        bagDraw.setDrawUser(Long.valueOf(req.getUserId()));
//        bagDraw.setStatus(IstEnum.BagDrawStatus.DRAW_SUCC.getCode());
//        bagDraw.setDrawMoney(bag.getMoney());
//        bagDrawMapper.insertSelective(bagDraw);
//        redisAmount++;
//
//        //打款
//        AddAcctBookReq addAcctBookReq = new AddAcctBookReq();
//        addAcctBookReq.setDirect(1);
//        addAcctBookReq.setUserId(req.getUserId());
//        addAcctBookReq.setMoney(bag.getMoney());
//        addAcctBookReq.setAcctType(IstEnum.AcctType.BAG.getType());
//        addAcctBookReq.setOptUserId(req.getUserId());
//        addAcctBookReq.setPayType(IstEnum.PayType.INSIDE.getCode());
//        addAcctBookReq.setOrderId("0");
//        addAcctBookReq.setStatus(1);
//        addAcctBookReq.setBizType((int) IstEnum.BookBizType.BAG.getCode());
//        QueryBaseResp queryBaseResp = new QueryBaseResp();
//        accountService.recordAcctBook(addAcctBookReq,queryBaseResp);
//        if (redisAmount==bag.getAmount().intValue() && bag.getAmount()!=-1){
//            //更新红包状态为发放完
//            Bag updateBag = new Bag();
//            updateBag.setBagNo(bag.getBagNo());
//            updateBag.setStatus(IstEnum.BagStatus.PROVIDE_FINISH.getCode());
//            bagMapper.updateByPrimaryKeySelective(updateBag);
//
//            //插入对账
//            BagCheck bagCheck = new BagCheck();
//            bagCheck.setBagNo(req.getBagNo());
//            bagCheck.setAmount(redisAmount.shortValue());
//            bagCheck.setBackMoney((float) 0);
//            bagCheck.setCreatetime(now);
//            bagCheck.setMoney(bag.getSumMoney());
//            bagCheck.setDrawMoney(bag.getMoney());
//            bagCheck.setResult(IstEnum.BagCheckResult.NORMAL.getCode());
//            bagCheck.setUpdatetime(now);
//            bagCheckMapper.insertSelective(bagCheck);
//        }
//        redisUtil.set(RedisKeyUtil.getBagDrawAmountFromRedis(req.getBagNo()+""),redisAmount, CodeConstant.REDIS_SAVE_TIME_24h);
//    }

    public double getRandomMoney(int remainSize,double remainMoney){
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (remainSize == 1)
        {
            remainSize--;
            return (double) Math.round(remainMoney * 100) / 100;
        }
        Random r = new Random();
        double min   = 0.01; //
        double max   = remainMoney / remainSize * 2;
        double money = r.nextDouble() * max;
        money = money <= min ? 0.01: money;
        money = Math.floor(money * 100) / 100;
        remainSize--;
        remainMoney -= money;
        return money;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(1);
        System.out.println(a.get(0));
    }
}
