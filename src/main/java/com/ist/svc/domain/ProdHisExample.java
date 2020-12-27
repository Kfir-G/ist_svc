package com.ist.svc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdHisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProdHisExample() {
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

        public Criteria andHisidIsNull() {
            addCriterion("hisid is null");
            return (Criteria) this;
        }

        public Criteria andHisidIsNotNull() {
            addCriterion("hisid is not null");
            return (Criteria) this;
        }

        public Criteria andHisidEqualTo(Integer value) {
            addCriterion("hisid =", value, "hisid");
            return (Criteria) this;
        }

        public Criteria andHisidNotEqualTo(Integer value) {
            addCriterion("hisid <>", value, "hisid");
            return (Criteria) this;
        }

        public Criteria andHisidGreaterThan(Integer value) {
            addCriterion("hisid >", value, "hisid");
            return (Criteria) this;
        }

        public Criteria andHisidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hisid >=", value, "hisid");
            return (Criteria) this;
        }

        public Criteria andHisidLessThan(Integer value) {
            addCriterion("hisid <", value, "hisid");
            return (Criteria) this;
        }

        public Criteria andHisidLessThanOrEqualTo(Integer value) {
            addCriterion("hisid <=", value, "hisid");
            return (Criteria) this;
        }

        public Criteria andHisidIn(List<Integer> values) {
            addCriterion("hisid in", values, "hisid");
            return (Criteria) this;
        }

        public Criteria andHisidNotIn(List<Integer> values) {
            addCriterion("hisid not in", values, "hisid");
            return (Criteria) this;
        }

        public Criteria andHisidBetween(Integer value1, Integer value2) {
            addCriterion("hisid between", value1, value2, "hisid");
            return (Criteria) this;
        }

        public Criteria andHisidNotBetween(Integer value1, Integer value2) {
            addCriterion("hisid not between", value1, value2, "hisid");
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

        public Criteria andProdinfoidIsNull() {
            addCriterion("prodinfoid is null");
            return (Criteria) this;
        }

        public Criteria andProdinfoidIsNotNull() {
            addCriterion("prodinfoid is not null");
            return (Criteria) this;
        }

        public Criteria andProdinfoidEqualTo(Integer value) {
            addCriterion("prodinfoid =", value, "prodinfoid");
            return (Criteria) this;
        }

        public Criteria andProdinfoidNotEqualTo(Integer value) {
            addCriterion("prodinfoid <>", value, "prodinfoid");
            return (Criteria) this;
        }

        public Criteria andProdinfoidGreaterThan(Integer value) {
            addCriterion("prodinfoid >", value, "prodinfoid");
            return (Criteria) this;
        }

        public Criteria andProdinfoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("prodinfoid >=", value, "prodinfoid");
            return (Criteria) this;
        }

        public Criteria andProdinfoidLessThan(Integer value) {
            addCriterion("prodinfoid <", value, "prodinfoid");
            return (Criteria) this;
        }

        public Criteria andProdinfoidLessThanOrEqualTo(Integer value) {
            addCriterion("prodinfoid <=", value, "prodinfoid");
            return (Criteria) this;
        }

        public Criteria andProdinfoidIn(List<Integer> values) {
            addCriterion("prodinfoid in", values, "prodinfoid");
            return (Criteria) this;
        }

        public Criteria andProdinfoidNotIn(List<Integer> values) {
            addCriterion("prodinfoid not in", values, "prodinfoid");
            return (Criteria) this;
        }

        public Criteria andProdinfoidBetween(Integer value1, Integer value2) {
            addCriterion("prodinfoid between", value1, value2, "prodinfoid");
            return (Criteria) this;
        }

        public Criteria andProdinfoidNotBetween(Integer value1, Integer value2) {
            addCriterion("prodinfoid not between", value1, value2, "prodinfoid");
            return (Criteria) this;
        }

        public Criteria andProdtypeIsNull() {
            addCriterion("prodtype is null");
            return (Criteria) this;
        }

        public Criteria andProdtypeIsNotNull() {
            addCriterion("prodtype is not null");
            return (Criteria) this;
        }

        public Criteria andProdtypeEqualTo(Short value) {
            addCriterion("prodtype =", value, "prodtype");
            return (Criteria) this;
        }

        public Criteria andProdtypeNotEqualTo(Short value) {
            addCriterion("prodtype <>", value, "prodtype");
            return (Criteria) this;
        }

        public Criteria andProdtypeGreaterThan(Short value) {
            addCriterion("prodtype >", value, "prodtype");
            return (Criteria) this;
        }

        public Criteria andProdtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("prodtype >=", value, "prodtype");
            return (Criteria) this;
        }

        public Criteria andProdtypeLessThan(Short value) {
            addCriterion("prodtype <", value, "prodtype");
            return (Criteria) this;
        }

        public Criteria andProdtypeLessThanOrEqualTo(Short value) {
            addCriterion("prodtype <=", value, "prodtype");
            return (Criteria) this;
        }

        public Criteria andProdtypeIn(List<Short> values) {
            addCriterion("prodtype in", values, "prodtype");
            return (Criteria) this;
        }

        public Criteria andProdtypeNotIn(List<Short> values) {
            addCriterion("prodtype not in", values, "prodtype");
            return (Criteria) this;
        }

        public Criteria andProdtypeBetween(Short value1, Short value2) {
            addCriterion("prodtype between", value1, value2, "prodtype");
            return (Criteria) this;
        }

        public Criteria andProdtypeNotBetween(Short value1, Short value2) {
            addCriterion("prodtype not between", value1, value2, "prodtype");
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

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
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

        public Criteria andOriginalfeeIsNull() {
            addCriterion("originalfee is null");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeIsNotNull() {
            addCriterion("originalfee is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeEqualTo(Float value) {
            addCriterion("originalfee =", value, "originalfee");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeNotEqualTo(Float value) {
            addCriterion("originalfee <>", value, "originalfee");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeGreaterThan(Float value) {
            addCriterion("originalfee >", value, "originalfee");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("originalfee >=", value, "originalfee");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeLessThan(Float value) {
            addCriterion("originalfee <", value, "originalfee");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeLessThanOrEqualTo(Float value) {
            addCriterion("originalfee <=", value, "originalfee");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeIn(List<Float> values) {
            addCriterion("originalfee in", values, "originalfee");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeNotIn(List<Float> values) {
            addCriterion("originalfee not in", values, "originalfee");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeBetween(Float value1, Float value2) {
            addCriterion("originalfee between", value1, value2, "originalfee");
            return (Criteria) this;
        }

        public Criteria andOriginalfeeNotBetween(Float value1, Float value2) {
            addCriterion("originalfee not between", value1, value2, "originalfee");
            return (Criteria) this;
        }

        public Criteria andSalefeeIsNull() {
            addCriterion("salefee is null");
            return (Criteria) this;
        }

        public Criteria andSalefeeIsNotNull() {
            addCriterion("salefee is not null");
            return (Criteria) this;
        }

        public Criteria andSalefeeEqualTo(Float value) {
            addCriterion("salefee =", value, "salefee");
            return (Criteria) this;
        }

        public Criteria andSalefeeNotEqualTo(Float value) {
            addCriterion("salefee <>", value, "salefee");
            return (Criteria) this;
        }

        public Criteria andSalefeeGreaterThan(Float value) {
            addCriterion("salefee >", value, "salefee");
            return (Criteria) this;
        }

        public Criteria andSalefeeGreaterThanOrEqualTo(Float value) {
            addCriterion("salefee >=", value, "salefee");
            return (Criteria) this;
        }

        public Criteria andSalefeeLessThan(Float value) {
            addCriterion("salefee <", value, "salefee");
            return (Criteria) this;
        }

        public Criteria andSalefeeLessThanOrEqualTo(Float value) {
            addCriterion("salefee <=", value, "salefee");
            return (Criteria) this;
        }

        public Criteria andSalefeeIn(List<Float> values) {
            addCriterion("salefee in", values, "salefee");
            return (Criteria) this;
        }

        public Criteria andSalefeeNotIn(List<Float> values) {
            addCriterion("salefee not in", values, "salefee");
            return (Criteria) this;
        }

        public Criteria andSalefeeBetween(Float value1, Float value2) {
            addCriterion("salefee between", value1, value2, "salefee");
            return (Criteria) this;
        }

        public Criteria andSalefeeNotBetween(Float value1, Float value2) {
            addCriterion("salefee not between", value1, value2, "salefee");
            return (Criteria) this;
        }

        public Criteria andDeliveryIsNull() {
            addCriterion("delivery is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIsNotNull() {
            addCriterion("delivery is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryEqualTo(Short value) {
            addCriterion("delivery =", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotEqualTo(Short value) {
            addCriterion("delivery <>", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryGreaterThan(Short value) {
            addCriterion("delivery >", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryGreaterThanOrEqualTo(Short value) {
            addCriterion("delivery >=", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLessThan(Short value) {
            addCriterion("delivery <", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLessThanOrEqualTo(Short value) {
            addCriterion("delivery <=", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryIn(List<Short> values) {
            addCriterion("delivery in", values, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotIn(List<Short> values) {
            addCriterion("delivery not in", values, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryBetween(Short value1, Short value2) {
            addCriterion("delivery between", value1, value2, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotBetween(Short value1, Short value2) {
            addCriterion("delivery not between", value1, value2, "delivery");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeIsNull() {
            addCriterion("onlinetime is null");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeIsNotNull() {
            addCriterion("onlinetime is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeEqualTo(Date value) {
            addCriterion("onlinetime =", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeNotEqualTo(Date value) {
            addCriterion("onlinetime <>", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeGreaterThan(Date value) {
            addCriterion("onlinetime >", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("onlinetime >=", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeLessThan(Date value) {
            addCriterion("onlinetime <", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeLessThanOrEqualTo(Date value) {
            addCriterion("onlinetime <=", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeIn(List<Date> values) {
            addCriterion("onlinetime in", values, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeNotIn(List<Date> values) {
            addCriterion("onlinetime not in", values, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeBetween(Date value1, Date value2) {
            addCriterion("onlinetime between", value1, value2, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeNotBetween(Date value1, Date value2) {
            addCriterion("onlinetime not between", value1, value2, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOfftimeIsNull() {
            addCriterion("offtime is null");
            return (Criteria) this;
        }

        public Criteria andOfftimeIsNotNull() {
            addCriterion("offtime is not null");
            return (Criteria) this;
        }

        public Criteria andOfftimeEqualTo(Date value) {
            addCriterion("offtime =", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeNotEqualTo(Date value) {
            addCriterion("offtime <>", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeGreaterThan(Date value) {
            addCriterion("offtime >", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeGreaterThanOrEqualTo(Date value) {
            addCriterion("offtime >=", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeLessThan(Date value) {
            addCriterion("offtime <", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeLessThanOrEqualTo(Date value) {
            addCriterion("offtime <=", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeIn(List<Date> values) {
            addCriterion("offtime in", values, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeNotIn(List<Date> values) {
            addCriterion("offtime not in", values, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeBetween(Date value1, Date value2) {
            addCriterion("offtime between", value1, value2, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeNotBetween(Date value1, Date value2) {
            addCriterion("offtime not between", value1, value2, "offtime");
            return (Criteria) this;
        }

        public Criteria andMonthnumIsNull() {
            addCriterion("monthnum is null");
            return (Criteria) this;
        }

        public Criteria andMonthnumIsNotNull() {
            addCriterion("monthnum is not null");
            return (Criteria) this;
        }

        public Criteria andMonthnumEqualTo(Short value) {
            addCriterion("monthnum =", value, "monthnum");
            return (Criteria) this;
        }

        public Criteria andMonthnumNotEqualTo(Short value) {
            addCriterion("monthnum <>", value, "monthnum");
            return (Criteria) this;
        }

        public Criteria andMonthnumGreaterThan(Short value) {
            addCriterion("monthnum >", value, "monthnum");
            return (Criteria) this;
        }

        public Criteria andMonthnumGreaterThanOrEqualTo(Short value) {
            addCriterion("monthnum >=", value, "monthnum");
            return (Criteria) this;
        }

        public Criteria andMonthnumLessThan(Short value) {
            addCriterion("monthnum <", value, "monthnum");
            return (Criteria) this;
        }

        public Criteria andMonthnumLessThanOrEqualTo(Short value) {
            addCriterion("monthnum <=", value, "monthnum");
            return (Criteria) this;
        }

        public Criteria andMonthnumIn(List<Short> values) {
            addCriterion("monthnum in", values, "monthnum");
            return (Criteria) this;
        }

        public Criteria andMonthnumNotIn(List<Short> values) {
            addCriterion("monthnum not in", values, "monthnum");
            return (Criteria) this;
        }

        public Criteria andMonthnumBetween(Short value1, Short value2) {
            addCriterion("monthnum between", value1, value2, "monthnum");
            return (Criteria) this;
        }

        public Criteria andMonthnumNotBetween(Short value1, Short value2) {
            addCriterion("monthnum not between", value1, value2, "monthnum");
            return (Criteria) this;
        }

        public Criteria andStarttypeIsNull() {
            addCriterion("starttype is null");
            return (Criteria) this;
        }

        public Criteria andStarttypeIsNotNull() {
            addCriterion("starttype is not null");
            return (Criteria) this;
        }

        public Criteria andStarttypeEqualTo(Short value) {
            addCriterion("starttype =", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeNotEqualTo(Short value) {
            addCriterion("starttype <>", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeGreaterThan(Short value) {
            addCriterion("starttype >", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeGreaterThanOrEqualTo(Short value) {
            addCriterion("starttype >=", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeLessThan(Short value) {
            addCriterion("starttype <", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeLessThanOrEqualTo(Short value) {
            addCriterion("starttype <=", value, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeIn(List<Short> values) {
            addCriterion("starttype in", values, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeNotIn(List<Short> values) {
            addCriterion("starttype not in", values, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeBetween(Short value1, Short value2) {
            addCriterion("starttype between", value1, value2, "starttype");
            return (Criteria) this;
        }

        public Criteria andStarttypeNotBetween(Short value1, Short value2) {
            addCriterion("starttype not between", value1, value2, "starttype");
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

        public Criteria andAfekeepIsNull() {
            addCriterion("afekeep is null");
            return (Criteria) this;
        }

        public Criteria andAfekeepIsNotNull() {
            addCriterion("afekeep is not null");
            return (Criteria) this;
        }

        public Criteria andAfekeepEqualTo(Short value) {
            addCriterion("afekeep =", value, "afekeep");
            return (Criteria) this;
        }

        public Criteria andAfekeepNotEqualTo(Short value) {
            addCriterion("afekeep <>", value, "afekeep");
            return (Criteria) this;
        }

        public Criteria andAfekeepGreaterThan(Short value) {
            addCriterion("afekeep >", value, "afekeep");
            return (Criteria) this;
        }

        public Criteria andAfekeepGreaterThanOrEqualTo(Short value) {
            addCriterion("afekeep >=", value, "afekeep");
            return (Criteria) this;
        }

        public Criteria andAfekeepLessThan(Short value) {
            addCriterion("afekeep <", value, "afekeep");
            return (Criteria) this;
        }

        public Criteria andAfekeepLessThanOrEqualTo(Short value) {
            addCriterion("afekeep <=", value, "afekeep");
            return (Criteria) this;
        }

        public Criteria andAfekeepIn(List<Short> values) {
            addCriterion("afekeep in", values, "afekeep");
            return (Criteria) this;
        }

        public Criteria andAfekeepNotIn(List<Short> values) {
            addCriterion("afekeep not in", values, "afekeep");
            return (Criteria) this;
        }

        public Criteria andAfekeepBetween(Short value1, Short value2) {
            addCriterion("afekeep between", value1, value2, "afekeep");
            return (Criteria) this;
        }

        public Criteria andAfekeepNotBetween(Short value1, Short value2) {
            addCriterion("afekeep not between", value1, value2, "afekeep");
            return (Criteria) this;
        }

        public Criteria andTransferIsNull() {
            addCriterion("transfer is null");
            return (Criteria) this;
        }

        public Criteria andTransferIsNotNull() {
            addCriterion("transfer is not null");
            return (Criteria) this;
        }

        public Criteria andTransferEqualTo(Short value) {
            addCriterion("transfer =", value, "transfer");
            return (Criteria) this;
        }

        public Criteria andTransferNotEqualTo(Short value) {
            addCriterion("transfer <>", value, "transfer");
            return (Criteria) this;
        }

        public Criteria andTransferGreaterThan(Short value) {
            addCriterion("transfer >", value, "transfer");
            return (Criteria) this;
        }

        public Criteria andTransferGreaterThanOrEqualTo(Short value) {
            addCriterion("transfer >=", value, "transfer");
            return (Criteria) this;
        }

        public Criteria andTransferLessThan(Short value) {
            addCriterion("transfer <", value, "transfer");
            return (Criteria) this;
        }

        public Criteria andTransferLessThanOrEqualTo(Short value) {
            addCriterion("transfer <=", value, "transfer");
            return (Criteria) this;
        }

        public Criteria andTransferIn(List<Short> values) {
            addCriterion("transfer in", values, "transfer");
            return (Criteria) this;
        }

        public Criteria andTransferNotIn(List<Short> values) {
            addCriterion("transfer not in", values, "transfer");
            return (Criteria) this;
        }

        public Criteria andTransferBetween(Short value1, Short value2) {
            addCriterion("transfer between", value1, value2, "transfer");
            return (Criteria) this;
        }

        public Criteria andTransferNotBetween(Short value1, Short value2) {
            addCriterion("transfer not between", value1, value2, "transfer");
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
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