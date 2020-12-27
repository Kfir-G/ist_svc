package com.ist.svc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrdernoIsNull() {
            addCriterion("orderno is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("orderno is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(Integer value) {
            addCriterion("orderno =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(Integer value) {
            addCriterion("orderno <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(Integer value) {
            addCriterion("orderno >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderno >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(Integer value) {
            addCriterion("orderno <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(Integer value) {
            addCriterion("orderno <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<Integer> values) {
            addCriterion("orderno in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<Integer> values) {
            addCriterion("orderno not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(Integer value1, Integer value2) {
            addCriterion("orderno between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(Integer value1, Integer value2) {
            addCriterion("orderno not between", value1, value2, "orderno");
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

        public Criteria andAddressidIsNull() {
            addCriterion("addressid is null");
            return (Criteria) this;
        }

        public Criteria andAddressidIsNotNull() {
            addCriterion("addressid is not null");
            return (Criteria) this;
        }

        public Criteria andAddressidEqualTo(Long value) {
            addCriterion("addressid =", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotEqualTo(Long value) {
            addCriterion("addressid <>", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidGreaterThan(Long value) {
            addCriterion("addressid >", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidGreaterThanOrEqualTo(Long value) {
            addCriterion("addressid >=", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidLessThan(Long value) {
            addCriterion("addressid <", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidLessThanOrEqualTo(Long value) {
            addCriterion("addressid <=", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidIn(List<Long> values) {
            addCriterion("addressid in", values, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotIn(List<Long> values) {
            addCriterion("addressid not in", values, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidBetween(Long value1, Long value2) {
            addCriterion("addressid between", value1, value2, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotBetween(Long value1, Long value2) {
            addCriterion("addressid not between", value1, value2, "addressid");
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

        public Criteria andSumfeeIsNull() {
            addCriterion("sumfee is null");
            return (Criteria) this;
        }

        public Criteria andSumfeeIsNotNull() {
            addCriterion("sumfee is not null");
            return (Criteria) this;
        }

        public Criteria andSumfeeEqualTo(Float value) {
            addCriterion("sumfee =", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeNotEqualTo(Float value) {
            addCriterion("sumfee <>", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeGreaterThan(Float value) {
            addCriterion("sumfee >", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("sumfee >=", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeLessThan(Float value) {
            addCriterion("sumfee <", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeLessThanOrEqualTo(Float value) {
            addCriterion("sumfee <=", value, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeIn(List<Float> values) {
            addCriterion("sumfee in", values, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeNotIn(List<Float> values) {
            addCriterion("sumfee not in", values, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeBetween(Float value1, Float value2) {
            addCriterion("sumfee between", value1, value2, "sumfee");
            return (Criteria) this;
        }

        public Criteria andSumfeeNotBetween(Float value1, Float value2) {
            addCriterion("sumfee not between", value1, value2, "sumfee");
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

        public Criteria andDeductionfeeIsNull() {
            addCriterion("deductionfee is null");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeIsNotNull() {
            addCriterion("deductionfee is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeEqualTo(Float value) {
            addCriterion("deductionfee =", value, "deductionfee");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeNotEqualTo(Float value) {
            addCriterion("deductionfee <>", value, "deductionfee");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeGreaterThan(Float value) {
            addCriterion("deductionfee >", value, "deductionfee");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("deductionfee >=", value, "deductionfee");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeLessThan(Float value) {
            addCriterion("deductionfee <", value, "deductionfee");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeLessThanOrEqualTo(Float value) {
            addCriterion("deductionfee <=", value, "deductionfee");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeIn(List<Float> values) {
            addCriterion("deductionfee in", values, "deductionfee");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeNotIn(List<Float> values) {
            addCriterion("deductionfee not in", values, "deductionfee");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeBetween(Float value1, Float value2) {
            addCriterion("deductionfee between", value1, value2, "deductionfee");
            return (Criteria) this;
        }

        public Criteria andDeductionfeeNotBetween(Float value1, Float value2) {
            addCriterion("deductionfee not between", value1, value2, "deductionfee");
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
            addCriterion("freightFee is null");
            return (Criteria) this;
        }

        public Criteria andFreightfeeIsNotNull() {
            addCriterion("freightFee is not null");
            return (Criteria) this;
        }

        public Criteria andFreightfeeEqualTo(Float value) {
            addCriterion("freightFee =", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeNotEqualTo(Float value) {
            addCriterion("freightFee <>", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeGreaterThan(Float value) {
            addCriterion("freightFee >", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("freightFee >=", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeLessThan(Float value) {
            addCriterion("freightFee <", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeLessThanOrEqualTo(Float value) {
            addCriterion("freightFee <=", value, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeIn(List<Float> values) {
            addCriterion("freightFee in", values, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeNotIn(List<Float> values) {
            addCriterion("freightFee not in", values, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeBetween(Float value1, Float value2) {
            addCriterion("freightFee between", value1, value2, "freightfee");
            return (Criteria) this;
        }

        public Criteria andFreightfeeNotBetween(Float value1, Float value2) {
            addCriterion("freightFee not between", value1, value2, "freightfee");
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

        public Criteria andPaytimeIsNull() {
            addCriterion("paytime is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNotNull() {
            addCriterion("paytime is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeEqualTo(Date value) {
            addCriterion("paytime =", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotEqualTo(Date value) {
            addCriterion("paytime <>", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThan(Date value) {
            addCriterion("paytime >", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("paytime >=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThan(Date value) {
            addCriterion("paytime <", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThanOrEqualTo(Date value) {
            addCriterion("paytime <=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIn(List<Date> values) {
            addCriterion("paytime in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotIn(List<Date> values) {
            addCriterion("paytime not in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeBetween(Date value1, Date value2) {
            addCriterion("paytime between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotBetween(Date value1, Date value2) {
            addCriterion("paytime not between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("paytype is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("paytype is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(Short value) {
            addCriterion("paytype =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(Short value) {
            addCriterion("paytype <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(Short value) {
            addCriterion("paytype >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(Short value) {
            addCriterion("paytype >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(Short value) {
            addCriterion("paytype <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(Short value) {
            addCriterion("paytype <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<Short> values) {
            addCriterion("paytype in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<Short> values) {
            addCriterion("paytype not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(Short value1, Short value2) {
            addCriterion("paytype between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(Short value1, Short value2) {
            addCriterion("paytype not between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPayorderidIsNull() {
            addCriterion("payorderid is null");
            return (Criteria) this;
        }

        public Criteria andPayorderidIsNotNull() {
            addCriterion("payorderid is not null");
            return (Criteria) this;
        }

        public Criteria andPayorderidEqualTo(String value) {
            addCriterion("payorderid =", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidNotEqualTo(String value) {
            addCriterion("payorderid <>", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidGreaterThan(String value) {
            addCriterion("payorderid >", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidGreaterThanOrEqualTo(String value) {
            addCriterion("payorderid >=", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidLessThan(String value) {
            addCriterion("payorderid <", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidLessThanOrEqualTo(String value) {
            addCriterion("payorderid <=", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidLike(String value) {
            addCriterion("payorderid like", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidNotLike(String value) {
            addCriterion("payorderid not like", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidIn(List<String> values) {
            addCriterion("payorderid in", values, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidNotIn(List<String> values) {
            addCriterion("payorderid not in", values, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidBetween(String value1, String value2) {
            addCriterion("payorderid between", value1, value2, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidNotBetween(String value1, String value2) {
            addCriterion("payorderid not between", value1, value2, "payorderid");
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

        public Criteria andChannelidIsNull() {
            addCriterion("channelid is null");
            return (Criteria) this;
        }

        public Criteria andChannelidIsNotNull() {
            addCriterion("channelid is not null");
            return (Criteria) this;
        }

        public Criteria andChannelidEqualTo(Integer value) {
            addCriterion("channelid =", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotEqualTo(Integer value) {
            addCriterion("channelid <>", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidGreaterThan(Integer value) {
            addCriterion("channelid >", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("channelid >=", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLessThan(Integer value) {
            addCriterion("channelid <", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLessThanOrEqualTo(Integer value) {
            addCriterion("channelid <=", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidIn(List<Integer> values) {
            addCriterion("channelid in", values, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotIn(List<Integer> values) {
            addCriterion("channelid not in", values, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidBetween(Integer value1, Integer value2) {
            addCriterion("channelid between", value1, value2, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotBetween(Integer value1, Integer value2) {
            addCriterion("channelid not between", value1, value2, "channelid");
            return (Criteria) this;
        }

        public Criteria andOlduseridIsNull() {
            addCriterion("oldUserid is null");
            return (Criteria) this;
        }

        public Criteria andOlduseridIsNotNull() {
            addCriterion("oldUserid is not null");
            return (Criteria) this;
        }

        public Criteria andOlduseridEqualTo(Long value) {
            addCriterion("oldUserid =", value, "olduserid");
            return (Criteria) this;
        }

        public Criteria andOlduseridNotEqualTo(Long value) {
            addCriterion("oldUserid <>", value, "olduserid");
            return (Criteria) this;
        }

        public Criteria andOlduseridGreaterThan(Long value) {
            addCriterion("oldUserid >", value, "olduserid");
            return (Criteria) this;
        }

        public Criteria andOlduseridGreaterThanOrEqualTo(Long value) {
            addCriterion("oldUserid >=", value, "olduserid");
            return (Criteria) this;
        }

        public Criteria andOlduseridLessThan(Long value) {
            addCriterion("oldUserid <", value, "olduserid");
            return (Criteria) this;
        }

        public Criteria andOlduseridLessThanOrEqualTo(Long value) {
            addCriterion("oldUserid <=", value, "olduserid");
            return (Criteria) this;
        }

        public Criteria andOlduseridIn(List<Long> values) {
            addCriterion("oldUserid in", values, "olduserid");
            return (Criteria) this;
        }

        public Criteria andOlduseridNotIn(List<Long> values) {
            addCriterion("oldUserid not in", values, "olduserid");
            return (Criteria) this;
        }

        public Criteria andOlduseridBetween(Long value1, Long value2) {
            addCriterion("oldUserid between", value1, value2, "olduserid");
            return (Criteria) this;
        }

        public Criteria andOlduseridNotBetween(Long value1, Long value2) {
            addCriterion("oldUserid not between", value1, value2, "olduserid");
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