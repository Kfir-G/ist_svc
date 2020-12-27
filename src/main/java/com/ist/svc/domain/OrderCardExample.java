package com.ist.svc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderCardExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Long value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Long value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Long value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Long value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Long value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Long value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Long> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Long> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Long value1, Long value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Long value1, Long value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andShopidIsNull() {
            addCriterion("shopid is null");
            return (Criteria) this;
        }

        public Criteria andShopidIsNotNull() {
            addCriterion("shopid is not null");
            return (Criteria) this;
        }

        public Criteria andShopidEqualTo(Integer value) {
            addCriterion("shopid =", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotEqualTo(Integer value) {
            addCriterion("shopid <>", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThan(Integer value) {
            addCriterion("shopid >", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopid >=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThan(Integer value) {
            addCriterion("shopid <", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThanOrEqualTo(Integer value) {
            addCriterion("shopid <=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidIn(List<Integer> values) {
            addCriterion("shopid in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotIn(List<Integer> values) {
            addCriterion("shopid not in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidBetween(Integer value1, Integer value2) {
            addCriterion("shopid between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotBetween(Integer value1, Integer value2) {
            addCriterion("shopid not between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andProdidIsNull() {
            addCriterion("prodid is null");
            return (Criteria) this;
        }

        public Criteria andProdidIsNotNull() {
            addCriterion("prodid is not null");
            return (Criteria) this;
        }

        public Criteria andProdidEqualTo(Integer value) {
            addCriterion("prodid =", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidNotEqualTo(Integer value) {
            addCriterion("prodid <>", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidGreaterThan(Integer value) {
            addCriterion("prodid >", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("prodid >=", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidLessThan(Integer value) {
            addCriterion("prodid <", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidLessThanOrEqualTo(Integer value) {
            addCriterion("prodid <=", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidIn(List<Integer> values) {
            addCriterion("prodid in", values, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidNotIn(List<Integer> values) {
            addCriterion("prodid not in", values, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidBetween(Integer value1, Integer value2) {
            addCriterion("prodid between", value1, value2, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidNotBetween(Integer value1, Integer value2) {
            addCriterion("prodid not between", value1, value2, "prodid");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Float value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Float value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Float value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Float value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Float value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Float value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Float> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Float> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Float value1, Float value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Float value1, Float value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andOnceIsNull() {
            addCriterion("once is null");
            return (Criteria) this;
        }

        public Criteria andOnceIsNotNull() {
            addCriterion("once is not null");
            return (Criteria) this;
        }

        public Criteria andOnceEqualTo(Float value) {
            addCriterion("once =", value, "once");
            return (Criteria) this;
        }

        public Criteria andOnceNotEqualTo(Float value) {
            addCriterion("once <>", value, "once");
            return (Criteria) this;
        }

        public Criteria andOnceGreaterThan(Float value) {
            addCriterion("once >", value, "once");
            return (Criteria) this;
        }

        public Criteria andOnceGreaterThanOrEqualTo(Float value) {
            addCriterion("once >=", value, "once");
            return (Criteria) this;
        }

        public Criteria andOnceLessThan(Float value) {
            addCriterion("once <", value, "once");
            return (Criteria) this;
        }

        public Criteria andOnceLessThanOrEqualTo(Float value) {
            addCriterion("once <=", value, "once");
            return (Criteria) this;
        }

        public Criteria andOnceIn(List<Float> values) {
            addCriterion("once in", values, "once");
            return (Criteria) this;
        }

        public Criteria andOnceNotIn(List<Float> values) {
            addCriterion("once not in", values, "once");
            return (Criteria) this;
        }

        public Criteria andOnceBetween(Float value1, Float value2) {
            addCriterion("once between", value1, value2, "once");
            return (Criteria) this;
        }

        public Criteria andOnceNotBetween(Float value1, Float value2) {
            addCriterion("once not between", value1, value2, "once");
            return (Criteria) this;
        }

        public Criteria andUsenumIsNull() {
            addCriterion("usenum is null");
            return (Criteria) this;
        }

        public Criteria andUsenumIsNotNull() {
            addCriterion("usenum is not null");
            return (Criteria) this;
        }

        public Criteria andUsenumEqualTo(Float value) {
            addCriterion("usenum =", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumNotEqualTo(Float value) {
            addCriterion("usenum <>", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumGreaterThan(Float value) {
            addCriterion("usenum >", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumGreaterThanOrEqualTo(Float value) {
            addCriterion("usenum >=", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumLessThan(Float value) {
            addCriterion("usenum <", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumLessThanOrEqualTo(Float value) {
            addCriterion("usenum <=", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumIn(List<Float> values) {
            addCriterion("usenum in", values, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumNotIn(List<Float> values) {
            addCriterion("usenum not in", values, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumBetween(Float value1, Float value2) {
            addCriterion("usenum between", value1, value2, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumNotBetween(Float value1, Float value2) {
            addCriterion("usenum not between", value1, value2, "usenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumIsNull() {
            addCriterion("leavenum is null");
            return (Criteria) this;
        }

        public Criteria andLeavenumIsNotNull() {
            addCriterion("leavenum is not null");
            return (Criteria) this;
        }

        public Criteria andLeavenumEqualTo(Float value) {
            addCriterion("leavenum =", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumNotEqualTo(Float value) {
            addCriterion("leavenum <>", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumGreaterThan(Float value) {
            addCriterion("leavenum >", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumGreaterThanOrEqualTo(Float value) {
            addCriterion("leavenum >=", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumLessThan(Float value) {
            addCriterion("leavenum <", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumLessThanOrEqualTo(Float value) {
            addCriterion("leavenum <=", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumIn(List<Float> values) {
            addCriterion("leavenum in", values, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumNotIn(List<Float> values) {
            addCriterion("leavenum not in", values, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumBetween(Float value1, Float value2) {
            addCriterion("leavenum between", value1, value2, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumNotBetween(Float value1, Float value2) {
            addCriterion("leavenum not between", value1, value2, "leavenum");
            return (Criteria) this;
        }

        public Criteria andCanceltypeIsNull() {
            addCriterion("canceltype is null");
            return (Criteria) this;
        }

        public Criteria andCanceltypeIsNotNull() {
            addCriterion("canceltype is not null");
            return (Criteria) this;
        }

        public Criteria andCanceltypeEqualTo(Short value) {
            addCriterion("canceltype =", value, "canceltype");
            return (Criteria) this;
        }

        public Criteria andCanceltypeNotEqualTo(Short value) {
            addCriterion("canceltype <>", value, "canceltype");
            return (Criteria) this;
        }

        public Criteria andCanceltypeGreaterThan(Short value) {
            addCriterion("canceltype >", value, "canceltype");
            return (Criteria) this;
        }

        public Criteria andCanceltypeGreaterThanOrEqualTo(Short value) {
            addCriterion("canceltype >=", value, "canceltype");
            return (Criteria) this;
        }

        public Criteria andCanceltypeLessThan(Short value) {
            addCriterion("canceltype <", value, "canceltype");
            return (Criteria) this;
        }

        public Criteria andCanceltypeLessThanOrEqualTo(Short value) {
            addCriterion("canceltype <=", value, "canceltype");
            return (Criteria) this;
        }

        public Criteria andCanceltypeIn(List<Short> values) {
            addCriterion("canceltype in", values, "canceltype");
            return (Criteria) this;
        }

        public Criteria andCanceltypeNotIn(List<Short> values) {
            addCriterion("canceltype not in", values, "canceltype");
            return (Criteria) this;
        }

        public Criteria andCanceltypeBetween(Short value1, Short value2) {
            addCriterion("canceltype between", value1, value2, "canceltype");
            return (Criteria) this;
        }

        public Criteria andCanceltypeNotBetween(Short value1, Short value2) {
            addCriterion("canceltype not between", value1, value2, "canceltype");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeIsNull() {
            addCriterion("endcanceltype is null");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeIsNotNull() {
            addCriterion("endcanceltype is not null");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeEqualTo(Short value) {
            addCriterion("endcanceltype =", value, "endcanceltype");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeNotEqualTo(Short value) {
            addCriterion("endcanceltype <>", value, "endcanceltype");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeGreaterThan(Short value) {
            addCriterion("endcanceltype >", value, "endcanceltype");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeGreaterThanOrEqualTo(Short value) {
            addCriterion("endcanceltype >=", value, "endcanceltype");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeLessThan(Short value) {
            addCriterion("endcanceltype <", value, "endcanceltype");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeLessThanOrEqualTo(Short value) {
            addCriterion("endcanceltype <=", value, "endcanceltype");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeIn(List<Short> values) {
            addCriterion("endcanceltype in", values, "endcanceltype");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeNotIn(List<Short> values) {
            addCriterion("endcanceltype not in", values, "endcanceltype");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeBetween(Short value1, Short value2) {
            addCriterion("endcanceltype between", value1, value2, "endcanceltype");
            return (Criteria) this;
        }

        public Criteria andEndcanceltypeNotBetween(Short value1, Short value2) {
            addCriterion("endcanceltype not between", value1, value2, "endcanceltype");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(Short value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(Short value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(Short value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(Short value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(Short value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(Short value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<Short> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<Short> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(Short value1, Short value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(Short value1, Short value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}