package com.ist.svc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDetailExample() {
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

        public Criteria andDetailidIsNull() {
            addCriterion("detailid is null");
            return (Criteria) this;
        }

        public Criteria andDetailidIsNotNull() {
            addCriterion("detailid is not null");
            return (Criteria) this;
        }

        public Criteria andDetailidEqualTo(Long value) {
            addCriterion("detailid =", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotEqualTo(Long value) {
            addCriterion("detailid <>", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidGreaterThan(Long value) {
            addCriterion("detailid >", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidGreaterThanOrEqualTo(Long value) {
            addCriterion("detailid >=", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidLessThan(Long value) {
            addCriterion("detailid <", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidLessThanOrEqualTo(Long value) {
            addCriterion("detailid <=", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidIn(List<Long> values) {
            addCriterion("detailid in", values, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotIn(List<Long> values) {
            addCriterion("detailid not in", values, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidBetween(Long value1, Long value2) {
            addCriterion("detailid between", value1, value2, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotBetween(Long value1, Long value2) {
            addCriterion("detailid not between", value1, value2, "detailid");
            return (Criteria) this;
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

        public Criteria andHeadimgIsNull() {
            addCriterion("headimg is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNotNull() {
            addCriterion("headimg is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgEqualTo(String value) {
            addCriterion("headimg =", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotEqualTo(String value) {
            addCriterion("headimg <>", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThan(String value) {
            addCriterion("headimg >", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThanOrEqualTo(String value) {
            addCriterion("headimg >=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThan(String value) {
            addCriterion("headimg <", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThanOrEqualTo(String value) {
            addCriterion("headimg <=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLike(String value) {
            addCriterion("headimg like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotLike(String value) {
            addCriterion("headimg not like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgIn(List<String> values) {
            addCriterion("headimg in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotIn(List<String> values) {
            addCriterion("headimg not in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgBetween(String value1, String value2) {
            addCriterion("headimg between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotBetween(String value1, String value2) {
            addCriterion("headimg not between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("spec is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("spec =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("spec <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("spec >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("spec >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("spec <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("spec <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLike(String value) {
            addCriterion("spec like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("spec not like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<String> values) {
            addCriterion("spec in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<String> values) {
            addCriterion("spec not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("spec between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("spec not between", value1, value2, "spec");
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

        public Criteria andSumfeeIsNull() {
            addCriterion("SumFee is null");
            return (Criteria) this;
        }

        public Criteria andSumfeeIsNotNull() {
            addCriterion("SumFee is not null");
            return (Criteria) this;
        }

        public Criteria andSumfeeEqualTo(Float value) {
            addCriterion("SumFee =", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeNotEqualTo(Float value) {
            addCriterion("SumFee <>", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeGreaterThan(Float value) {
            addCriterion("SumFee >", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("SumFee >=", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeLessThan(Float value) {
            addCriterion("SumFee <", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeLessThanOrEqualTo(Float value) {
            addCriterion("SumFee <=", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeIn(List<Float> values) {
            addCriterion("SumFee in", values, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeNotIn(List<Float> values) {
            addCriterion("SumFee not in", values, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeBetween(Float value1, Float value2) {
            addCriterion("SumFee between", value1, value2, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeNotBetween(Float value1, Float value2) {
            addCriterion("SumFee not between", value1, value2, "sumfee");
            return (Criteria) this;
        }

        public Criteria andDiscountidIsNull() {
            addCriterion("discountid is null");
            return (Criteria) this;
        }

        public Criteria andDiscountidIsNotNull() {
            addCriterion("discountid is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountidEqualTo(Integer value) {
            addCriterion("discountid =", value, "discountid");
            return (Criteria) this;
        }

        public Criteria andDiscountidNotEqualTo(Integer value) {
            addCriterion("discountid <>", value, "discountid");
            return (Criteria) this;
        }

        public Criteria andDiscountidGreaterThan(Integer value) {
            addCriterion("discountid >", value, "discountid");
            return (Criteria) this;
        }

        public Criteria andDiscountidGreaterThanOrEqualTo(Integer value) {
            addCriterion("discountid >=", value, "discountid");
            return (Criteria) this;
        }

        public Criteria andDiscountidLessThan(Integer value) {
            addCriterion("discountid <", value, "discountid");
            return (Criteria) this;
        }

        public Criteria andDiscountidLessThanOrEqualTo(Integer value) {
            addCriterion("discountid <=", value, "discountid");
            return (Criteria) this;
        }

        public Criteria andDiscountidIn(List<Integer> values) {
            addCriterion("discountid in", values, "discountid");
            return (Criteria) this;
        }

        public Criteria andDiscountidNotIn(List<Integer> values) {
            addCriterion("discountid not in", values, "discountid");
            return (Criteria) this;
        }

        public Criteria andDiscountidBetween(Integer value1, Integer value2) {
            addCriterion("discountid between", value1, value2, "discountid");
            return (Criteria) this;
        }

        public Criteria andDiscountidNotBetween(Integer value1, Integer value2) {
            addCriterion("discountid not between", value1, value2, "discountid");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeIsNull() {
            addCriterion("discountfee is null");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeIsNotNull() {
            addCriterion("discountfee is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeEqualTo(Float value) {
            addCriterion("discountfee =", value, "discountfee");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeNotEqualTo(Float value) {
            addCriterion("discountfee <>", value, "discountfee");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeGreaterThan(Float value) {
            addCriterion("discountfee >", value, "discountfee");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("discountfee >=", value, "discountfee");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeLessThan(Float value) {
            addCriterion("discountfee <", value, "discountfee");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeLessThanOrEqualTo(Float value) {
            addCriterion("discountfee <=", value, "discountfee");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeIn(List<Float> values) {
            addCriterion("discountfee in", values, "discountfee");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeNotIn(List<Float> values) {
            addCriterion("discountfee not in", values, "discountfee");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeBetween(Float value1, Float value2) {
            addCriterion("discountfee between", value1, value2, "discountfee");
            return (Criteria) this;
        }

        public Criteria andDiscountfeeNotBetween(Float value1, Float value2) {
            addCriterion("discountfee not between", value1, value2, "discountfee");
            return (Criteria) this;
        }

        public Criteria andCouponidIsNull() {
            addCriterion("couponid is null");
            return (Criteria) this;
        }

        public Criteria andCouponidIsNotNull() {
            addCriterion("couponid is not null");
            return (Criteria) this;
        }

        public Criteria andCouponidEqualTo(Integer value) {
            addCriterion("couponid =", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidNotEqualTo(Integer value) {
            addCriterion("couponid <>", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidGreaterThan(Integer value) {
            addCriterion("couponid >", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidGreaterThanOrEqualTo(Integer value) {
            addCriterion("couponid >=", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidLessThan(Integer value) {
            addCriterion("couponid <", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidLessThanOrEqualTo(Integer value) {
            addCriterion("couponid <=", value, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidIn(List<Integer> values) {
            addCriterion("couponid in", values, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidNotIn(List<Integer> values) {
            addCriterion("couponid not in", values, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidBetween(Integer value1, Integer value2) {
            addCriterion("couponid between", value1, value2, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponidNotBetween(Integer value1, Integer value2) {
            addCriterion("couponid not between", value1, value2, "couponid");
            return (Criteria) this;
        }

        public Criteria andCouponfeeIsNull() {
            addCriterion("couponfee is null");
            return (Criteria) this;
        }

        public Criteria andCouponfeeIsNotNull() {
            addCriterion("couponfee is not null");
            return (Criteria) this;
        }

        public Criteria andCouponfeeEqualTo(Float value) {
            addCriterion("couponfee =", value, "couponfee");
            return (Criteria) this;
        }

        public Criteria andCouponfeeNotEqualTo(Float value) {
            addCriterion("couponfee <>", value, "couponfee");
            return (Criteria) this;
        }

        public Criteria andCouponfeeGreaterThan(Float value) {
            addCriterion("couponfee >", value, "couponfee");
            return (Criteria) this;
        }

        public Criteria andCouponfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("couponfee >=", value, "couponfee");
            return (Criteria) this;
        }

        public Criteria andCouponfeeLessThan(Float value) {
            addCriterion("couponfee <", value, "couponfee");
            return (Criteria) this;
        }

        public Criteria andCouponfeeLessThanOrEqualTo(Float value) {
            addCriterion("couponfee <=", value, "couponfee");
            return (Criteria) this;
        }

        public Criteria andCouponfeeIn(List<Float> values) {
            addCriterion("couponfee in", values, "couponfee");
            return (Criteria) this;
        }

        public Criteria andCouponfeeNotIn(List<Float> values) {
            addCriterion("couponfee not in", values, "couponfee");
            return (Criteria) this;
        }

        public Criteria andCouponfeeBetween(Float value1, Float value2) {
            addCriterion("couponfee between", value1, value2, "couponfee");
            return (Criteria) this;
        }

        public Criteria andCouponfeeNotBetween(Float value1, Float value2) {
            addCriterion("couponfee not between", value1, value2, "couponfee");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(Float value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(Float value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(Float value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(Float value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(Float value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<Float> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<Float> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(Float value1, Float value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(Float value1, Float value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeIsNull() {
            addCriterion("freightfee is null");
            return (Criteria) this;
        }

        public Criteria andFreightfeeIsNotNull() {
            addCriterion("freightfee is not null");
            return (Criteria) this;
        }

        public Criteria andFreightfeeEqualTo(Float value) {
            addCriterion("freightfee =", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeNotEqualTo(Float value) {
            addCriterion("freightfee <>", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeGreaterThan(Float value) {
            addCriterion("freightfee >", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("freightfee >=", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeLessThan(Float value) {
            addCriterion("freightfee <", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeLessThanOrEqualTo(Float value) {
            addCriterion("freightfee <=", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeIn(List<Float> values) {
            addCriterion("freightfee in", values, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeNotIn(List<Float> values) {
            addCriterion("freightfee not in", values, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeBetween(Float value1, Float value2) {
            addCriterion("freightfee between", value1, value2, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeNotBetween(Float value1, Float value2) {
            addCriterion("freightfee not between", value1, value2, "freightfee");
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

        public Criteria andDeliverynoIsNull() {
            addCriterion("deliveryno is null");
            return (Criteria) this;
        }

        public Criteria andDeliverynoIsNotNull() {
            addCriterion("deliveryno is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverynoEqualTo(String value) {
            addCriterion("deliveryno =", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoNotEqualTo(String value) {
            addCriterion("deliveryno <>", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoGreaterThan(String value) {
            addCriterion("deliveryno >", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryno >=", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoLessThan(String value) {
            addCriterion("deliveryno <", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoLessThanOrEqualTo(String value) {
            addCriterion("deliveryno <=", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoLike(String value) {
            addCriterion("deliveryno like", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoNotLike(String value) {
            addCriterion("deliveryno not like", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoIn(List<String> values) {
            addCriterion("deliveryno in", values, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoNotIn(List<String> values) {
            addCriterion("deliveryno not in", values, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoBetween(String value1, String value2) {
            addCriterion("deliveryno between", value1, value2, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoNotBetween(String value1, String value2) {
            addCriterion("deliveryno not between", value1, value2, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andPayfeeIsNull() {
            addCriterion("payfee is null");
            return (Criteria) this;
        }

        public Criteria andPayfeeIsNotNull() {
            addCriterion("payfee is not null");
            return (Criteria) this;
        }

        public Criteria andPayfeeEqualTo(Float value) {
            addCriterion("payfee =", value, "payfee");
            return (Criteria) this;
        }

        public Criteria andPayfeeNotEqualTo(Float value) {
            addCriterion("payfee <>", value, "payfee");
            return (Criteria) this;
        }

        public Criteria andPayfeeGreaterThan(Float value) {
            addCriterion("payfee >", value, "payfee");
            return (Criteria) this;
        }

        public Criteria andPayfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("payfee >=", value, "payfee");
            return (Criteria) this;
        }

        public Criteria andPayfeeLessThan(Float value) {
            addCriterion("payfee <", value, "payfee");
            return (Criteria) this;
        }

        public Criteria andPayfeeLessThanOrEqualTo(Float value) {
            addCriterion("payfee <=", value, "payfee");
            return (Criteria) this;
        }

        public Criteria andPayfeeIn(List<Float> values) {
            addCriterion("payfee in", values, "payfee");
            return (Criteria) this;
        }

        public Criteria andPayfeeNotIn(List<Float> values) {
            addCriterion("payfee not in", values, "payfee");
            return (Criteria) this;
        }

        public Criteria andPayfeeBetween(Float value1, Float value2) {
            addCriterion("payfee between", value1, value2, "payfee");
            return (Criteria) this;
        }

        public Criteria andPayfeeNotBetween(Float value1, Float value2) {
            addCriterion("payfee not between", value1, value2, "payfee");
            return (Criteria) this;
        }

        public Criteria andDescrIsNull() {
            addCriterion("descr is null");
            return (Criteria) this;
        }

        public Criteria andDescrIsNotNull() {
            addCriterion("descr is not null");
            return (Criteria) this;
        }

        public Criteria andDescrEqualTo(String value) {
            addCriterion("descr =", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotEqualTo(String value) {
            addCriterion("descr <>", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrGreaterThan(String value) {
            addCriterion("descr >", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrGreaterThanOrEqualTo(String value) {
            addCriterion("descr >=", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLessThan(String value) {
            addCriterion("descr <", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLessThanOrEqualTo(String value) {
            addCriterion("descr <=", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLike(String value) {
            addCriterion("descr like", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotLike(String value) {
            addCriterion("descr not like", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrIn(List<String> values) {
            addCriterion("descr in", values, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotIn(List<String> values) {
            addCriterion("descr not in", values, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrBetween(String value1, String value2) {
            addCriterion("descr between", value1, value2, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotBetween(String value1, String value2) {
            addCriterion("descr not between", value1, value2, "descr");
            return (Criteria) this;
        }

        public Criteria andSafekeepIsNull() {
            addCriterion("safekeep is null");
            return (Criteria) this;
        }

        public Criteria andSafekeepIsNotNull() {
            addCriterion("safekeep is not null");
            return (Criteria) this;
        }

        public Criteria andSafekeepEqualTo(Short value) {
            addCriterion("safekeep =", value, "safekeep");
            return (Criteria) this;
        }

        public Criteria andSafekeepNotEqualTo(Short value) {
            addCriterion("safekeep <>", value, "safekeep");
            return (Criteria) this;
        }

        public Criteria andSafekeepGreaterThan(Short value) {
            addCriterion("safekeep >", value, "safekeep");
            return (Criteria) this;
        }

        public Criteria andSafekeepGreaterThanOrEqualTo(Short value) {
            addCriterion("safekeep >=", value, "safekeep");
            return (Criteria) this;
        }

        public Criteria andSafekeepLessThan(Short value) {
            addCriterion("safekeep <", value, "safekeep");
            return (Criteria) this;
        }

        public Criteria andSafekeepLessThanOrEqualTo(Short value) {
            addCriterion("safekeep <=", value, "safekeep");
            return (Criteria) this;
        }

        public Criteria andSafekeepIn(List<Short> values) {
            addCriterion("safekeep in", values, "safekeep");
            return (Criteria) this;
        }

        public Criteria andSafekeepNotIn(List<Short> values) {
            addCriterion("safekeep not in", values, "safekeep");
            return (Criteria) this;
        }

        public Criteria andSafekeepBetween(Short value1, Short value2) {
            addCriterion("safekeep between", value1, value2, "safekeep");
            return (Criteria) this;
        }

        public Criteria andSafekeepNotBetween(Short value1, Short value2) {
            addCriterion("safekeep not between", value1, value2, "safekeep");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyIsNull() {
            addCriterion("safekeepmoney is null");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyIsNotNull() {
            addCriterion("safekeepmoney is not null");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyEqualTo(Float value) {
            addCriterion("safekeepmoney =", value, "safekeepmoney");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyNotEqualTo(Float value) {
            addCriterion("safekeepmoney <>", value, "safekeepmoney");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyGreaterThan(Float value) {
            addCriterion("safekeepmoney >", value, "safekeepmoney");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("safekeepmoney >=", value, "safekeepmoney");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyLessThan(Float value) {
            addCriterion("safekeepmoney <", value, "safekeepmoney");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyLessThanOrEqualTo(Float value) {
            addCriterion("safekeepmoney <=", value, "safekeepmoney");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyIn(List<Float> values) {
            addCriterion("safekeepmoney in", values, "safekeepmoney");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyNotIn(List<Float> values) {
            addCriterion("safekeepmoney not in", values, "safekeepmoney");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyBetween(Float value1, Float value2) {
            addCriterion("safekeepmoney between", value1, value2, "safekeepmoney");
            return (Criteria) this;
        }

        public Criteria andSafekeepmoneyNotBetween(Float value1, Float value2) {
            addCriterion("safekeepmoney not between", value1, value2, "safekeepmoney");
            return (Criteria) this;
        }

        public Criteria andTransferorderidIsNull() {
            addCriterion("transferorderid is null");
            return (Criteria) this;
        }

        public Criteria andTransferorderidIsNotNull() {
            addCriterion("transferorderid is not null");
            return (Criteria) this;
        }

        public Criteria andTransferorderidEqualTo(Long value) {
            addCriterion("transferorderid =", value, "transferorderid");
            return (Criteria) this;
        }

        public Criteria andTransferorderidNotEqualTo(Long value) {
            addCriterion("transferorderid <>", value, "transferorderid");
            return (Criteria) this;
        }

        public Criteria andTransferorderidGreaterThan(Long value) {
            addCriterion("transferorderid >", value, "transferorderid");
            return (Criteria) this;
        }

        public Criteria andTransferorderidGreaterThanOrEqualTo(Long value) {
            addCriterion("transferorderid >=", value, "transferorderid");
            return (Criteria) this;
        }

        public Criteria andTransferorderidLessThan(Long value) {
            addCriterion("transferorderid <", value, "transferorderid");
            return (Criteria) this;
        }

        public Criteria andTransferorderidLessThanOrEqualTo(Long value) {
            addCriterion("transferorderid <=", value, "transferorderid");
            return (Criteria) this;
        }

        public Criteria andTransferorderidIn(List<Long> values) {
            addCriterion("transferorderid in", values, "transferorderid");
            return (Criteria) this;
        }

        public Criteria andTransferorderidNotIn(List<Long> values) {
            addCriterion("transferorderid not in", values, "transferorderid");
            return (Criteria) this;
        }

        public Criteria andTransferorderidBetween(Long value1, Long value2) {
            addCriterion("transferorderid between", value1, value2, "transferorderid");
            return (Criteria) this;
        }

        public Criteria andTransferorderidNotBetween(Long value1, Long value2) {
            addCriterion("transferorderid not between", value1, value2, "transferorderid");
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

        public Criteria andReservetimeIsNull() {
            addCriterion("reservetime is null");
            return (Criteria) this;
        }

        public Criteria andReservetimeIsNotNull() {
            addCriterion("reservetime is not null");
            return (Criteria) this;
        }

        public Criteria andReservetimeEqualTo(Date value) {
            addCriterion("reservetime =", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeNotEqualTo(Date value) {
            addCriterion("reservetime <>", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeGreaterThan(Date value) {
            addCriterion("reservetime >", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reservetime >=", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeLessThan(Date value) {
            addCriterion("reservetime <", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeLessThanOrEqualTo(Date value) {
            addCriterion("reservetime <=", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeIn(List<Date> values) {
            addCriterion("reservetime in", values, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeNotIn(List<Date> values) {
            addCriterion("reservetime not in", values, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeBetween(Date value1, Date value2) {
            addCriterion("reservetime between", value1, value2, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeNotBetween(Date value1, Date value2) {
            addCriterion("reservetime not between", value1, value2, "reservetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeIsNull() {
            addCriterion("usetime is null");
            return (Criteria) this;
        }

        public Criteria andUsetimeIsNotNull() {
            addCriterion("usetime is not null");
            return (Criteria) this;
        }

        public Criteria andUsetimeEqualTo(Date value) {
            addCriterion("usetime =", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotEqualTo(Date value) {
            addCriterion("usetime <>", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeGreaterThan(Date value) {
            addCriterion("usetime >", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("usetime >=", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeLessThan(Date value) {
            addCriterion("usetime <", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeLessThanOrEqualTo(Date value) {
            addCriterion("usetime <=", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeIn(List<Date> values) {
            addCriterion("usetime in", values, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotIn(List<Date> values) {
            addCriterion("usetime not in", values, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeBetween(Date value1, Date value2) {
            addCriterion("usetime between", value1, value2, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotBetween(Date value1, Date value2) {
            addCriterion("usetime not between", value1, value2, "usetime");
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