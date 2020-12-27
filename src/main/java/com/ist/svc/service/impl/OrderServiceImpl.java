package com.ist.svc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ist.svc.common.Exception.ServiceException;
import com.ist.svc.common.ResultConstant;
import com.ist.svc.common.util.DateUtil;
import com.ist.svc.common.util.XMLUtil;
import com.ist.svc.config.IstConfig;
import com.ist.svc.config.IstEnum;
import com.ist.svc.controller.model.*;
import com.ist.svc.controller.model.OrderDetail;
import com.ist.svc.controller.model.dto.ApiBaseResp;
import com.ist.svc.controller.model.dto.QuerySubAcctReq;
import com.ist.svc.controller.model.dto.SubAcctVo;
import com.ist.svc.dao.*;
import com.ist.svc.domain.*;
import com.ist.svc.domain.Order;
import com.ist.svc.service.*;
import com.ist.svc.service.newversion.PayService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Author: sunhaitao
 */
@Service(value = "orderService")
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {
    @Autowired
    private UserTokenService userTokenService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    private ProdMapper prodMapper;
    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private OrderLogMapper orderLogMapper;
    @Autowired
    private UserAccountBookMapper userAccountBookMapper;
    @Autowired
    private IstConfig istConfig;
    @Autowired
    private PayService payService;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void getCartProdList(GetCartProdListReq req, QueryBaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.GET_CARTPROD_LIST_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.GET_CARTPROD_LIST_TOKENID_ERROR_MSG);
            return;
        }
        Map<String,Object> params = new HashMap<>();
        params.put("userId",req.getUserId());
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        Page<Cart> page = (Page<Cart>) cartMapper.selectsByParams(params);
        List<Cart> list = page.getResult();
        List<CartProdData> data = new ArrayList<>();
        if (null != list && list.size() > 0) {
            for (Cart cart : list){
                CartProdData cartProdData = new CartProdData();
                cartProdData.setAmount(cart.getAmount().intValue());
                cartProdData.setCartFee(cart.getCartfee());
                cartProdData.setCreateTime(DateUtil.getString(cart.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                cartProdData.setHeadImg(cart.getHeadImg());
                cartProdData.setId(cart.getId().toString());
                cartProdData.setName(cart.getName());
                cartProdData.setProdId(cart.getProdid().toString());
                cartProdData.setProdInfoId(cart.getProdinfoid().toString());
                cartProdData.setSaleFee(cart.getSaleFee());
                cartProdData.setCartFee(cart.getCartfee());
                cartProdData.setSelected(cart.getSelected().intValue());
                cartProdData.setShopId(cart.getShopid().toString());
                cartProdData.setSpec(cart.getSpec());
                cartProdData.setUpdateTime(DateUtil.getString(cart.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
                cartProdData.setUserId(cart.getUserid().toString());
                data.add(cartProdData);
            }
        }
        //设置成功返回
        resp.setCode(ResultConstant.GET_CARTPROD_LIST_SUCC_CODE);
        resp.setMsg(ResultConstant.GET_CARTPROD_LIST_SUCC_MSG);
        resp.setData(data);
    }

    @Override
    @Transactional
    public void getOrderList(GetOrderListReq req, QueryBaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.GET_ORDER_LIST_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.GET_ORDER_LIST_TOKENID_ERROR_MSG);
            return;
        }

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        Map<String,Object> params = new HashMap<>();
        params.put("userId",req.getUserId());
//        OrderExample orderExample = new OrderExample();
//        OrderExample.Criteria criteria = orderExample.createCriteria();
//        criteria.andUseridEqualTo(Long.valueOf(req.getUserId()));
        if (req.getStatus()!=null){
//            criteria.andStatusEqualTo(req.getStatus().shortValue());
            params.put("status",req.getStatus().shortValue());
        }
        Page<Order> pageOrder = (Page<Order>) orderMapper.selectsByParams(params);
        List<Order> resultList = pageOrder.getResult();
        List<GetOrderListData> data = new ArrayList<>();
        if (resultList != null && resultList.size() > 0) {
            for (Order order : resultList){
                GetOrderListData getOrderListData = new GetOrderListData();
                getOrderListData.setCreateTime(DateUtil.getString(order.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                getOrderListData.setDeductionFee(order.getDeductionfee()==null?0:order.getDeductionfee());
                getOrderListData.setDiscountFee(order.getDiscountfee()==null?0:order.getDiscountfee());
                getOrderListData.setCouponFee(order.getCouponfee()==null?0:order.getCouponfee());
                getOrderListData.setFee(order.getFee()==null?0:order.getFee());
                getOrderListData.setFreightFee(order.getFreightfee()==null?0:order.getFreightfee());
                getOrderListData.setOrderId(order.getOrderid().toString());
                getOrderListData.setPayFee(order.getPayfee()==null?0:order.getPayfee());
                getOrderListData.setPayTime(DateUtil.getString(order.getPaytime(),DateUtil.PATTERN_DATE_TIME));
//                getOrderListData.setPayType(order.getPaytype()==null?0:order.getPaytype().intValue());
                getOrderListData.setStatus(order.getStatus().intValue());
                getOrderListData.setShopId(order.getShopId()==null?"":order.getShopId().toString());
                getOrderListData.setShopName(order.getShopName()==null?"":order.getShopName());
                getOrderListData.setAmount(order.getAmount());
                getOrderListData.setSumFee(order.getSumfee());
                getOrderListData.setUpdateTime(DateUtil.getString(order.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
                getOrderListData.setUserId(order.getUserid().toString());

                //設置address
                Map<String,Object> paramsAddress = new HashMap<>();
                paramsAddress.put("addressId",order.getAddressid());
                List<com.ist.svc.controller.model.UserAddress> userAddresses = userAddressService.queryByParams(paramsAddress);
                if (userAddresses!=null && userAddresses.size()>0){
                    getOrderListData.setAddress(userAddresses.get(0));
                }
                //设置orderDetails
//                OrderDetailExample orderDetailExample = new OrderDetailExample();
//                OrderDetailExample.Criteria criteriaOrderDetail = orderDetailExample.createCriteria();
//                criteriaOrderDetail.andOrderidEqualTo(order.getOrderid());
//                List<com.ist.svc.domain.OrderDetail> orderDetailDb = orderDetailMapper.selectByExample(orderDetailExample);
                List<OrderDetail> orderDetails = new ArrayList<>();
                for (com.ist.svc.domain.OrderDetail detail : order.getOrderDetails()){
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setAmount(detail.getAmount().intValue());
                    orderDetail.setCreateTime(DateUtil.getString(detail.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                    orderDetail.setDescr(detail.getDescr());
                    orderDetail.setDetailId(detail.getDetailid().toString());
                    orderDetail.setDiscountFee(detail.getDiscountfee());
                    orderDetail.setCouponFee(detail.getCouponfee());
                    orderDetail.setFee(detail.getFee());
                    orderDetail.setFreightFee(detail.getFreightfee());
                    orderDetail.setHeadImg(detail.getHeadimg());
                    orderDetail.setName(detail.getName());
                    orderDetail.setOrderId(detail.getOrderid().toString());
                    orderDetail.setProdId(detail.getProdid().toString());
                    orderDetail.setProdInfoId(detail.getProdinfoid().toString());
                    orderDetail.setSaleFee(detail.getSalefee());
                    orderDetail.setShopId(detail.getShopid().toString());
                    orderDetail.setStatus(detail.getStatus().intValue());
                    orderDetail.setSumFee(detail.getSumfee());
                    orderDetail.setUpdateTime(DateUtil.getString(detail.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
                    orderDetail.setSpec(detail.getSpec()==null?"":detail.getSpec());
                    orderDetails.add(orderDetail);
                    getOrderListData.setDetails(orderDetails);
                }
                data.add(getOrderListData);
            }
        }
        resp.setData(data);
        //设置成功返回
        resp.setCode(ResultConstant.GET_ORDER_LIST_SUCC_CODE);
        resp.setMsg(ResultConstant.GET_ORDER_LIST_SUCC_MSG);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void joinCart(JoinCartReq req, QueryBaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.JOIN_CART_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.JOIN_CART_TOKENID_ERROR_MSG);
            return;
        }
        //查prod
        Map<String, Object> params = new HashMap<>();
        params.put("prodId",req.getProdId());
        params.put("prodInfoId",req.getProdInfoId());
        List<Prod> prods = prodMapper.selectByParams(params);
        if (prods==null || prods.isEmpty()){
            //商品不存在
            resp.setCode(ResultConstant.JOIN_CART_PROD_NOT_EXSIT_ERROR_CODE);
            resp.setMsg(ResultConstant.JOIN_CART_PROD_NOT_EXSIT_ERROR_MSG);
            return;
        }
        //验证商品状态
        Prod prod = prods.get(0);
        if (prod.getStatus()!= IstEnum.ProdStatus.NORMAL.getStatus()){
            resp.setCode(ResultConstant.JOIN_CART_PROD_STATUS_ERROR_CODE);
            resp.setMsg(ResultConstant.JOIN_CART_PROD_STATUS_ERROR_MSG);
            return;
        }
        List<String> ids = new ArrayList();
        //验证是否同商品加过购物车 若加过则数量加amount
        Map<String,Object> cartParams = new HashMap<>();
        cartParams.put("userId",req.getUserId());
        cartParams.put("prodId",req.getProdId());
        cartParams.put("prodInfoId",req.getProdInfoId());
        List<Cart> carts = cartMapper.selectsByParams(cartParams);
        if (carts!=null&&carts.size()>0){
            Cart cartDb = carts.get(0);
            Cart updateCart = new Cart();
            short amountTotal = (short) (cartDb.getAmount().shortValue()+req.getAmount().shortValue());
            updateCart.setAmount(amountTotal);
            updateCart.setSelected(req.getSelected().shortValue());
            updateCart.setCartfee(req.getCartFee());
            updateCart.setUpdatetime(new Date());
            CartExample cartExample = new CartExample();
            CartExample.Criteria criteria = cartExample.createCriteria();
            criteria.andIdEqualTo(cartDb.getId());
            cartMapper.updateByExampleSelective(updateCart,cartExample);
            ids.add(cartDb.getId().toString());
        }else {
            Date now = new Date();
            Cart cart = new Cart();
            cart.setAmount(req.getAmount().shortValue());
            cart.setCartfee(req.getCartFee());
            cart.setCreatetime(now);
            cart.setProdid(Integer.parseInt(req.getProdId()));
            cart.setUserid(Long.valueOf(req.getUserId()));
            cart.setProdinfoid(Integer.parseInt(req.getProdInfoId()));
            cart.setHeadImg(prod.getHeadimg());
            cart.setName(prod.getProdname());
            cart.setSaleFee(prod.getSaleFee());
            cart.setSpec(req.getSpec()); //前端传
            cart.setShopid(prod.getShopid());
            cart.setUpdatetime(now);
            cart.setSelected(req.getSelected().shortValue());
            cartMapper.insertSelective(cart);
            ids.add(cart.getId().toString());
        }
        resp.setData(ids);
        resp.setCode(ResultConstant.JOIN_CART_SUCC_CODE);
        resp.setMsg(ResultConstant.JOIN_CART_SUCC_MSG);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delCart(DelCartReq req, BaseResp resp) throws Exception {
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.DEL_CART_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.DEL_CART_TOKENID_ERROR_MSG);
            return;
        }
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        List<Long> ids = new ArrayList<>();
        for (String id : req.getIds().split(",")){
            ids.add(Long.valueOf(id));
        }
        criteria.andIdIn(ids);
        criteria.andUseridEqualTo(Long.valueOf(req.getUserId()));
        cartMapper.deleteByExample(example);
        resp.setCode(ResultConstant.DEL_CART_SUCC_CODE);
        resp.setMsg(ResultConstant.DEL_CART_SUCC_MSG);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void order(OrderReq req, QueryBaseResp resp) throws Exception {
        resp.setCode(ResultConstant.ORDER_SUCC_CODE);
        resp.setMsg(ResultConstant.ORDER_SUCC_MSG);
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.ORDER_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.ORDER_TOKENID_ERROR_MSG);
            return;
        }

        if (req.getOrders()!=null && req.getOrders().size()>0){
            List<String> orderIds = new ArrayList<>();
            for (com.ist.svc.controller.model.Order orderTemp : req.getOrders()){
                Order order = new Order();
                order.setAddressid(Long.valueOf(req.getAddressId()));
                order.setOrderno(this.getOrderNo());
                order.setUserid(Long.valueOf(req.getUserId()));
                order.setStatus(IstEnum.OrderStatus.NOT_PAY.getStatus());
                order.setSumfee(orderTemp.getSumFee()!=null?orderTemp.getSumFee():0);
                order.setDiscountfee(orderTemp.getDiscountFee()!=null?orderTemp.getDiscountFee():0);
                order.setCouponfee(orderTemp.getCouponFee()!=null?orderTemp.getCouponFee():0);
                order.setDiscountfee(orderTemp.getDiscountFee()!=null?orderTemp.getDiscountFee():0);
                order.setFee(orderTemp.getFee()!=null?orderTemp.getFee():0);
                order.setFreightfee(orderTemp.getFreightFee()!=null?orderTemp.getFreightFee():0);
                order.setPayfee(orderTemp.getPayFee()!=null?orderTemp.getPayFee():0);
                Date now = new Date();
                order.setPaytime(now);
                order.setCreatetime(now);
                order.setUpdatetime(now);
                order.setChannelid(0);
                order.setShopId(Integer.parseInt(orderTemp.getShopId()));
                order.setShopName(orderTemp.getShopName());
//                order.setOrderid(this.getOrderId());
                orderMapper.insertSelective(order);
                orderIds.add(order.getOrderid().toString());
                if (orderTemp.getDetails() != null && orderTemp.getDetails().size()>0){
                    for (OrderDetail orderDetailTemp : orderTemp.getDetails()){
                        com.ist.svc.domain.OrderDetail orderDetail = new com.ist.svc.domain.OrderDetail();
                        orderDetail.setOrderid(order.getOrderid());
                        orderDetail.setShopid(orderDetailTemp.getShopId()!=null?Integer.parseInt(orderDetailTemp.getShopId()):0);
                        orderDetail.setProdinfoid(orderDetailTemp.getProdInfoId()!=null?Integer.parseInt(orderDetailTemp.getProdInfoId()):0);
                        orderDetail.setProdid(orderDetailTemp.getProdId()!=null?Integer.parseInt(orderDetailTemp.getProdId()):0);
                        orderDetail.setName(orderDetailTemp.getName()!=null?orderDetailTemp.getName():"");
                        orderDetail.setHeadimg(orderDetailTemp.getHeadImg()!=null?orderDetailTemp.getHeadImg():"");
                        orderDetail.setSpec(orderDetailTemp.getSpec()!=null?orderDetailTemp.getSpec():""); //规格
                        orderDetail.setStatus(IstEnum.OrderStatus.NOT_PAY.getStatus());
                        orderDetail.setSalefee(orderDetailTemp.getSaleFee()!=null?orderDetailTemp.getSaleFee():0);
                        orderDetail.setAmount(orderDetailTemp.getAmount()!=null?orderDetailTemp.getAmount():0);
                        orderDetail.setSumfee(orderDetailTemp.getSumFee()!=null?orderDetailTemp.getSumFee():0);
                        orderDetail.setDiscountid(orderDetailTemp.getDiscountId()!=null?orderDetailTemp.getDiscountId():0); //优惠id
                        orderDetail.setDiscountfee(orderDetailTemp.getDiscountFee()!=null?orderDetailTemp.getDiscountFee():0);
                        orderDetail.setCouponid(orderDetailTemp.getCouponId()!=null?orderDetailTemp.getCouponId():0);
                        orderDetail.setCouponfee(orderDetailTemp.getCouponFee()!=null?orderDetailTemp.getCouponFee():0);
                        orderDetail.setFee(orderDetailTemp.getFee()!=null?orderDetailTemp.getFee():0);
                        orderDetail.setFreightfee(orderDetailTemp.getFreightFee()!=null?orderDetailTemp.getFreightFee():0);
                        orderDetail.setDelivery(orderDetailTemp.getDelivery()!=null?orderDetailTemp.getDelivery().shortValue():0);
                        orderDetail.setDeliveryno(orderDetailTemp.getDeliveryNo()!=null?orderDetailTemp.getDeliveryNo():"");
                        orderDetail.setPayfee(orderDetailTemp.getPayFee()!=null?orderDetailTemp.getPayFee():0);
                        orderDetail.setDescr(orderDetailTemp.getDescr()!=null?orderDetailTemp.getDescr():"");
                        orderDetail.setUserid(Long.valueOf(req.getUserId()));
                        if (StringUtils.isNoneBlank(orderDetailTemp.getUserCouponId())){
                            //校验劵 锁定劵
                            UseCouponReq useCouponReq = new UseCouponReq();
                            useCouponReq.setCouponId(orderDetailTemp.getCouponId()!=null?orderDetailTemp.getCouponId().toString():"");
                            useCouponReq.setOrderId(order.getOrderid().toString());
                            useCouponReq.setUserCouponId(orderDetailTemp.getUserCouponId());
                            BaseResp baseResp = new BaseResp();
                            couponService.useCouponOrder(useCouponReq,baseResp);
                            if (!ResultConstant.SUCCESS_CODE.equals(baseResp.getCode())){
                                resp.setCode(baseResp.getCode());
                                resp.setMsg(baseResp.getMsg());
                                throw new ServiceException(baseResp.getMsg());
                            }
                        }
                        orderDetailMapper.insertSelective(orderDetail);
                    }
                }else {
                    resp.setCode(ResultConstant.ORDER_DETAIL_ERROR_CODE);
                    resp.setMsg(ResultConstant.ORDER_DETAIL_ERROR_MSG);
                    throw new ServiceException(ResultConstant.ORDER_DETAIL_ERROR_MSG);
                }
            }
            resp.setData(orderIds);
        }else {
            resp.setCode(ResultConstant.ORDER_LIST_ERROR_CODE);
            resp.setMsg(ResultConstant.ORDER_LIST_ERROR_MSG);
            throw new ServiceException(ResultConstant.ORDER_LIST_ERROR_MSG);
        }
    }


//    private Long getOrderId() {
//        String nowTime = DateUtil.getString(new Date(),DateUtil.PATTERN_DATE);
//        String seq = String.format("%10d", commonMapper.querySeqNextVal(IstEnum.SeqName.ORDER_NO.getSeqValue()).intValue());
//        return Long.valueOf(nowTime + seq);
//    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void closeOrder(CloseOrderReq req, BaseResp resp) throws Exception {
        resp.setCode(ResultConstant.CLOSE_ORDER_SUCC_CODE);
        resp.setMsg(ResultConstant.CLOSE_ORDER_SUCC_MSG);
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.CLOSE_ORDER_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.CLOSE_ORDER_TOKENID_ERROR_MSG);
            return;
        }
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderidEqualTo(Long.valueOf(req.getOrderId()));
        criteria.andUseridEqualTo(Long.valueOf(userVerifyTokenResp.getUserId()));
        List<Order> orders = orderMapper.selectByExample(example);
        if (orders==null || orders.isEmpty()){
            resp.setCode(ResultConstant.CLOSE_ORDER_NOT_EXIST_ERROR_CODE);
            resp.setMsg(ResultConstant.CLOSE_ORDER_NOT_EXIST_ERROR_MSG);
            return;
        }
        Order dbOrder = orders.get(0);
        if (dbOrder.getStatus()!=IstEnum.OrderStatus.NOT_PAY.getStatus()){
            resp.setCode(ResultConstant.CLOSE_ORDER_STATUS_ERROR_CODE);
            resp.setMsg(ResultConstant.CLOSE_ORDER_STATUS_ERROR_MSG);
            return;
        }
        Order updateOrder = new Order();
        updateOrder.setStatus(IstEnum.OrderStatus.CANCEL.getStatus());
        updateOrder.setUpdatetime(new Date());
        orderMapper.updateByExampleSelective(updateOrder,example);

        //更新OrderDetail
        com.ist.svc.domain.OrderDetail updateOrderDetail = new com.ist.svc.domain.OrderDetail();
        OrderDetailExample detailExample = new OrderDetailExample();
        OrderDetailExample.Criteria detailCriteria1 = detailExample.createCriteria();
        detailCriteria1.andOrderidEqualTo(Long.valueOf(req.getOrderId()));
        updateOrderDetail.setStatus(IstEnum.OrderStatus.CANCEL.getStatus());
        updateOrderDetail.setUpdatetime(new Date());
        orderDetailMapper.updateByExampleSelective(updateOrderDetail,detailExample);

        //记录日志Order_log
        OrderLog orderLog = new OrderLog();
        orderLog.setCreatetime(new Date());
        orderLog.setOrderid(Long.valueOf(req.getOrderId()));
        orderLog.setShopid(dbOrder.getShopId());
        if (StringUtils.isNoneBlank(req.getDescr())){
            orderLog.setDescr(req.getDescr());
        }
        orderLog.setCreatetime(new Date());
        orderLog.setOptuserid(Long.valueOf(req.getUserId()));
        orderLog.setStatus(IstEnum.OrderStatus.CANCEL.getStatus());
        orderLogMapper.insert(orderLog);
    }

    @Override
    public void updateOrder(UpdateOrderReq req, BaseResp resp) throws Exception {
        if (IstEnum.OrderStatus.DELIVERY.getStatus() == req.getStatus().shortValue() && StringUtils.isBlank(req.getDeliveryNo())){
            resp.setCode(ResultConstant.UPDATE_ORDER_DELIVERY_NO_NULL_ERROR_CODE);
            resp.setMsg(ResultConstant.UPDATE_ORDER_DELIVERY_NO_NULL_ERROR_MSG);
            return;
        }
        resp.setCode(ResultConstant.UPDATE_ORDER_SUCC_CODE);
        resp.setMsg(ResultConstant.UPDATE_ORDER_SUCC_MSG);
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.UPDATE_ORDER_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.UPDATE_ORDER_TOKENID_ERROR_MSG);
            return;
        }
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderidEqualTo(Long.valueOf(req.getOrderId()));
        criteria.andUseridEqualTo(Long.valueOf(userVerifyTokenResp.getUserId()));
        List<Order> orders = orderMapper.selectByExample(example);
        if (orders==null || orders.isEmpty()){
            resp.setCode(ResultConstant.UPDATE_ORDER_NOT_EXIST_ERROR_CODE);
            resp.setMsg(ResultConstant.UPDATE_ORDER_NOT_EXIST_ERROR_MSG);
            return;
        }

        Order updateOrder = new Order();
        updateOrder.setStatus(req.getStatus().shortValue());
        updateOrder.setUpdatetime(new Date());
        orderMapper.updateByExampleSelective(updateOrder,example);

        //更新OrderDetail
        com.ist.svc.domain.OrderDetail updateOrderDetail = new com.ist.svc.domain.OrderDetail();
        OrderDetailExample detailExample = new OrderDetailExample();
        OrderDetailExample.Criteria detailCriteria1 = detailExample.createCriteria();
        detailCriteria1.andOrderidEqualTo(Long.valueOf(req.getOrderId()));
        updateOrderDetail.setStatus(req.getStatus().shortValue());
        updateOrderDetail.setUpdatetime(new Date());
        orderDetailMapper.updateByExampleSelective(updateOrderDetail,detailExample);

        //记录日志Order_log
        Order dbOrder = orders.get(0);
        OrderLog orderLog = new OrderLog();
        orderLog.setCreatetime(new Date());
        orderLog.setOrderid(Long.valueOf(req.getOrderId()));
        orderLog.setShopid(dbOrder.getShopId());
        if (StringUtils.isNoneBlank(req.getDescr())){
            orderLog.setDescr(req.getDescr());
        }
        orderLog.setCreatetime(new Date());
        orderLog.setOptuserid(Long.valueOf(req.getUserId()));
        orderLog.setStatus(req.getStatus().shortValue());
        orderLogMapper.insert(orderLog);

    }

    @Override
    public void wxPayNotify(String receviceStr, WxPayNotifyResp resp) throws Exception{
        resp.setReturnCode(ResultConstant.WEIXIN_NOTIFY_SUCC_CODE);
        resp.setReturnMsg(ResultConstant.WEIXIN_NOTIFY_SUCC_MSG);
        Map map = XMLUtil.doXMLParse(receviceStr);
        if (validSign(map)){
            String resultCode = (String) map.get("result_code");
            if (StringUtils.equalsIgnoreCase("SUCCESS",resultCode)){
                //成功
                String transId = (String) map.get("out_trade_no");
                String otherOrder = (String) map.get("transaction_id");
                String otherAcct = (String) map.get("openid");
                accountService.orderPayFinishBack(resp, transId, otherOrder, otherAcct);
            }else{
                //失败

            }

        }else{
            //签名失败
            resp.setReturnCode(ResultConstant.WEIXIN_NOTIFY_ERROR_CODE);
            resp.setReturnMsg(ResultConstant.WEIXIN_NOTIFY_SIGN_CHECK_ERROR_MSG);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addAcctBook(AddAcctBookReq req, QueryBaseResp resp) throws Exception {
        resp.setCode(ResultConstant.ADD_ACCT_BOOK_SUCC_CODE);
        resp.setMsg(ResultConstant.ADD_ACCT_BOOK_SUCC_MSG);
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.ADD_ACCT_BOOK_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.ADD_ACCT_BOOK_TOKENID_ERROR_MSG);
            return;
        }
        String transId = accountService.recordAcctBook(req, resp);
        if (transId == null) return;
        AddAcctBookData data = new AddAcctBookData();
        data.setTransId(transId);
        resp.setData(data);
    }



    @Override
    public void queryAcctBook(QueryAcctBookReq req, QueryBaseResp resp) throws Exception {
        resp.setCode(ResultConstant.QUERY_ACCT_BOOK_SUCC_CODE);
        resp.setMsg(ResultConstant.QUERY_ACCT_BOOK_SUCC_MSG);
        if (StringUtils.isBlank(req.getTransId()) && StringUtils.isBlank(req.getSubAccountId())){
            resp.setCode(ResultConstant.QUERY_ACCT_BOOK_NULL_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_ACCT_BOOK_NULL_ERROR_MSG);
            return;
        }
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.QUERY_ACCT_BOOK_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.QUERY_ACCT_BOOK_TOKENID_ERROR_MSG);
            return;
        }
        UserAccountBookExample example = new UserAccountBookExample();
        UserAccountBookExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNoneBlank(req.getSubAccountId())){
            criteria.andSubaccountidEqualTo(Long.valueOf(req.getSubAccountId()));
        }
        if (StringUtils.isNoneBlank(req.getTransId())){
            criteria.andTransidEqualTo(Long.valueOf(req.getTransId()));
        }
        List<UserAccountBook> userAccountBooks = userAccountBookMapper.selectByExample(example);
        List<AcctBook> books = new ArrayList<>();
        if (userAccountBooks!=null && userAccountBooks.size()>0){
            for (UserAccountBook userAccountBook : userAccountBooks){
                AcctBook book = new AcctBook();
                book.setAccountId(userAccountBook.getAccountid().toString());
                book.setAcctType(userAccountBook.getAccttype().intValue());
                book.setDirect(userAccountBook.getDirect().intValue());
                book.setMoney(userAccountBook.getMoney());
                book.setOrderId(userAccountBook.getOrderid());
                book.setPayType(userAccountBook.getPaytype().intValue());
                book.setStatus(userAccountBook.getStatus().intValue());
                //needCheck如果为1且不是支付完成状态的 去查询支付接入方的订单
                if (userAccountBook.getStatus().intValue()==IstEnum.AcctBookStatus.TO_BE_PAY.getStatus() && req.getNeedCheck()!=null && req.getNeedCheck()==1){
                    Integer payType = userAccountBook.getPaytype().intValue();
                    boolean isPayFinish = payService.tradeQuery(userAccountBook, payType);
                    if (isPayFinish){
                        book.setStatus(IstEnum.AcctBookStatus.PAY_FINISH.getStatus().intValue());
                        //更新UserAccountBook为已付款状态
//                        UserAccountBook updateUserAccountBook = new UserAccountBook();
//                        updateUserAccountBook.setTransid(userAccountBook.getTransid());
//                        updateUserAccountBook.setStatus(IstEnum.AcctBookStatus.PAY_FINISH.getStatus());
//                        userAccountBookMapper.updateByPrimaryKeySelective(updateUserAccountBook);
//                        String otherOrder = "";
//                        String otherAcct=  "";
//                        accountService.updateUserAccountAndOrderStatusToFinish(userAccountBook);
                    }
                }

                book.setSubAccountId(userAccountBook.getSubaccountid().toString());
                book.setTransId(userAccountBook.getTransid().toString());
                book.setCreateTime(DateUtil.getString(userAccountBook.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
                book.setUpdateTime(DateUtil.getString(userAccountBook.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
                book.setDescr(userAccountBook.getDescr());
                book.setOtherOrder(userAccountBook.getOtherorder());
                book.setOtherAcct(userAccountBook.getOtheracct());
                book.setBalance(userAccountBook.getBalance());
                books.add(book);
            }
        }
        resp.setData(books);

    }

    @Override
    public void addAcct(AddAcctReq req, QueryBaseResp resp) throws Exception {
        resp.setCode(ResultConstant.ADD_ACCT_SUCC_CODE);
        resp.setMsg(ResultConstant.ADD_ACCT_SUCC_MSG);
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.ADD_ACCT_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.ADD_ACCT_TOKENID_ERROR_MSG);
            return;
        }
        //查账户是否存在，状态是否正常
        UserAccount userAcct = accountService.getUserAcctByOwnUserId(new BigDecimal(req.getOwnUserId()));
        if (userAcct!=null){
            if (userAcct.getStatus()==IstEnum.AcctStatus.LOCK.getStatus()){
                resp.setCode(ResultConstant.ADD_ACCT_LOCK_ERROR_CODE);
                resp.setMsg(ResultConstant.ADD_ACCT_LOCK_ERROR_MSG);
                return;
            }else {
                AddAcctData data = new AddAcctData();
                data.setAccountId(userAcct.getAccountid().toString());
                resp.setData(data);
                return;
            }
        }else{
            //新增
            Date now = new Date();
            UserAccount userAccount = new UserAccount();
            userAccount.setCreatetime(now);
            userAccount.setUpdatetime(now);
            userAccount.setOwnuserid(Long.valueOf(req.getOwnUserId()));
            userAccount.setName(req.getName());
            userAccount.setStatus(IstEnum.AcctStatus.NORMAL.getStatus());
            userAccount.setUsertype((short) 0);
            long acctId = accountService.createUserAcct(userAccount);
            AddAcctData data = new AddAcctData();
            data.setAccountId(acctId+"");
            resp.setData(data);
            return;
        }
    }

    @Override
    public void addSubAcct(AddSubAcctReq req, QueryBaseResp resp) throws Exception {
        resp.setCode(ResultConstant.ADD_SUB_ACCT_SUCC_CODE);
        resp.setMsg(ResultConstant.ADD_SUB_ACCT_SUCC_MSG);
        //校验token
        UserVerifyTokenReq userVerifyTokenReq = new UserVerifyTokenReq();
        userVerifyTokenReq.setTokenId(req.getTokenId());
        userVerifyTokenReq.setUserId(req.getUserId());
        UserVerifyTokenResp userVerifyTokenResp = new UserVerifyTokenResp();
        userTokenService.verifyToken(userVerifyTokenReq,userVerifyTokenResp);
        if(!ResultConstant.VERIFY_TOKEN_SUCC_CODE.equals(userVerifyTokenResp.getCode())){
            resp.setCode(ResultConstant.ADD_SUB_ACCT_TOKENID_ERROR_CODE);
            resp.setMsg(ResultConstant.ADD_SUB_ACCT_TOKENID_ERROR_MSG);
            return;
        }
        //查账户是否存在，状态是否正常
        UserAccount userAcct = accountService.getUserAcctByOwnUserId(new BigDecimal(req.getOwnUserId()));
        AddSubAcctData data = new AddSubAcctData();
        if (userAcct!=null){
            if (userAcct.getStatus()==IstEnum.AcctStatus.LOCK.getStatus()){
                resp.setCode(ResultConstant.ADD_SUB_ACCT_LOCK_ERROR_CODE);
                resp.setMsg(ResultConstant.ADD_SUB_ACCT_LOCK_ERROR_MSG);
                return;
            }else {
                //查询子账户是否存在，状态是否正常
                UserSubAccount userSubAcct = accountService.getUserSubAcctByAcctIdAndAcctType(new BigDecimal(userAcct.getAccountid()), req.getAcctType());
                if (userSubAcct==null){
                    UserSubAccount userSubAccount = new UserSubAccount();
                    userSubAccount.setAccountid(userAcct.getAccountid());
                    String subAcctIdStr = userAcct.getAccountid() + String.format("%02d",req.getAcctType());
                    long subAcctId = Long.valueOf(subAcctIdStr);
                    userSubAccount.setSubaccountid(subAcctId);
                    userSubAccount.setAccttype(req.getAcctType().shortValue());
                    if(IstEnum.AcctType.BOOK.getType()==req.getAcctType()){
                        userSubAccount.setBalance((float) 0);
                    }else{
                        userSubAccount.setBalance(0f);
                    }
                    Date now = new Date();
                    userSubAccount.setCreatetime(now);
                    userSubAccount.setUpdatetime(now);
                    userSubAccount.setStatus(IstEnum.AcctStatus.NORMAL.getStatus());
                    accountService.createSubAcct(userSubAccount);
                    data.setSubAccountId(subAcctId+"");
                }else if(userSubAcct.getStatus()==IstEnum.AcctStatus.LOCK.getStatus()){
                    resp.setCode(ResultConstant.ADD_SUB_SUBACCT_LOCK_ERROR_CODE);
                    resp.setMsg(ResultConstant.ADD_SUB_SUBACCT_LOCK_ERROR_MSG);
                    return;
                }else {
                    data.setSubAccountId(userSubAcct.getSubaccountid()+"");
                    return;
                }
                resp.setData(data);
            }
        }

    }

    @Override
    public void querySubAcct(QuerySubAcctReq req, ApiBaseResp resp) {
        if (null==req.getUserType()){
            req.setUserType(IstEnum.AcctUserType.USER.getAcctUserType());
        }
        Map<String,Object> params = new HashMap<>();
        params.put("ownUserId",req.getOwnUserId());
        params.put("acctType",req.getAcctType());
        params.put("userType",req.getUserType());
        UserSubAccount userSubAccount = accountService.querySubAcct(params);
        if (null!=userSubAccount){
            SubAcctVo subAcctVo = new SubAcctVo();
            subAcctVo.setAccountId(userSubAccount.getAccountid().toString());
            subAcctVo.setAcctType(userSubAccount.getAccttype().intValue());
            subAcctVo.setBalance(userSubAccount.getBalance());
            subAcctVo.setCreateTime(DateUtil.getString(userSubAccount.getCreatetime(),DateUtil.PATTERN_DATE_TIME));
            subAcctVo.setUpdateTime(DateUtil.getString(userSubAccount.getUpdatetime(),DateUtil.PATTERN_DATE_TIME));
            subAcctVo.setStatus(userSubAccount.getStatus().intValue());
            subAcctVo.setSubAccountId(userSubAccount.getSubaccountid().toString());
            resp.setData(subAcctVo);
        }
        resp.setCode(ResultConstant.SUCCESS_CODE);
        resp.setMsg(ResultConstant.SUCCESS_CODE_MSG);
    }

    private boolean validSign(Map map) {
        if (map==null){
            return false;
        }
        Map<String, String> resultMap = new HashMap<String, String>();
        List<String> keyList = new ArrayList<String>(map.keySet());
        for (String k : keyList) {
            resultMap.put(k, map.get(k).toString());
        }
        String sign=resultMap.remove("sign");
        keyList = new ArrayList<>(resultMap.keySet());
        Collections.sort(keyList);
        StringBuilder sb = new StringBuilder();
        //拼接参数
        for (String k : keyList) {
            String value = resultMap.get(k);
            sb.append(k).append("=").append(value).append("&");
        }
        sb.append("key=").append(istConfig.getWxNotifyKey());//key为商户平台设置的密钥key
        //本地签名生成
        String localSign= DigestUtils.md5Hex(sb.toString());
        if(!StringUtils.equalsIgnoreCase(localSign, sign)){
            logger.warn("微信支付通知组装签名数据:"+sb.toString() + ",签名校验失败,localSign:"+localSign+",sign:"+sign);
            return false;
        }
        return true;
    }

    private Integer getOrderNo() {
        //获取时间
//        String nowTime = DateUtil.getString(new Date(),DateUtil.PATTERN_DATE_TIME);
        return commonMapper.querySeqNextVal(IstEnum.SeqName.ORDER_NO.getSeqValue()).intValue();
    }
}
