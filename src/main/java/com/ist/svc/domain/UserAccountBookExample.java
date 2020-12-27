package com.ist.svc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAccountBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAccountBookExample() {
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

        public Criteria andTransidIsNull() {
            addCriterion("transid is null");
            return (Criteria) this;
        }

        public Criteria andTransidIsNotNull() {
            addCriterion("transid is not null");
            return (Criteria) this;
        }

        public Criteria andTransidEqualTo(Long value) {
            addCriterion("transid =", value, "transid");
            return (Criteria) this;
        }

        public Criteria andTransidNotEqualTo(Long value) {
            addCriterion("transid <>", value, "transid");
            return (Criteria) this;
        }

        public Criteria andTransidGreaterThan(Long value) {
            addCriterion("transid >", value, "transid");
            return (Criteria) this;
        }

        public Criteria andTransidGreaterThanOrEqualTo(Long value) {
            addCriterion("transid >=", value, "transid");
            return (Criteria) this;
        }

        public Criteria andTransidLessThan(Long value) {
            addCriterion("transid <", value, "transid");
            return (Criteria) this;
        }

        public Criteria andTransidLessThanOrEqualTo(Long value) {
            addCriterion("transid <=", value, "transid");
            return (Criteria) this;
        }

        public Criteria andTransidIn(List<Long> values) {
            addCriterion("transid in", values, "transid");
            return (Criteria) this;
        }

        public Criteria andTransidNotIn(List<Long> values) {
            addCriterion("transid not in", values, "transid");
            return (Criteria) this;
        }

        public Criteria andTransidBetween(Long value1, Long value2) {
            addCriterion("transid between", value1, value2, "transid");
            return (Criteria) this;
        }

        public Criteria andTransidNotBetween(Long value1, Long value2) {
            addCriterion("transid not between", value1, value2, "transid");
            return (Criteria) this;
        }

        public Criteria andSubaccountidIsNull() {
            addCriterion("subaccountid is null");
            return (Criteria) this;
        }

        public Criteria andSubaccountidIsNotNull() {
            addCriterion("subaccountid is not null");
            return (Criteria) this;
        }

        public Criteria andSubaccountidEqualTo(Long value) {
            addCriterion("subaccountid =", value, "subaccountid");
            return (Criteria) this;
        }

        public Criteria andSubaccountidNotEqualTo(Long value) {
            addCriterion("subaccountid <>", value, "subaccountid");
            return (Criteria) this;
        }

        public Criteria andSubaccountidGreaterThan(Long value) {
            addCriterion("subaccountid >", value, "subaccountid");
            return (Criteria) this;
        }

        public Criteria andSubaccountidGreaterThanOrEqualTo(Long value) {
            addCriterion("subaccountid >=", value, "subaccountid");
            return (Criteria) this;
        }

        public Criteria andSubaccountidLessThan(Long value) {
            addCriterion("subaccountid <", value, "subaccountid");
            return (Criteria) this;
        }

        public Criteria andSubaccountidLessThanOrEqualTo(Long value) {
            addCriterion("subaccountid <=", value, "subaccountid");
            return (Criteria) this;
        }

        public Criteria andSubaccountidIn(List<Long> values) {
            addCriterion("subaccountid in", values, "subaccountid");
            return (Criteria) this;
        }

        public Criteria andSubaccountidNotIn(List<Long> values) {
            addCriterion("subaccountid not in", values, "subaccountid");
            return (Criteria) this;
        }

        public Criteria andSubaccountidBetween(Long value1, Long value2) {
            addCriterion("subaccountid between", value1, value2, "subaccountid");
            return (Criteria) this;
        }

        public Criteria andSubaccountidNotBetween(Long value1, Long value2) {
            addCriterion("subaccountid not between", value1, value2, "subaccountid");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNull() {
            addCriterion("accountid is null");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNotNull() {
            addCriterion("accountid is not null");
            return (Criteria) this;
        }

        public Criteria andAccountidEqualTo(Long value) {
            addCriterion("accountid =", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotEqualTo(Long value) {
            addCriterion("accountid <>", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThan(Long value) {
            addCriterion("accountid >", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThanOrEqualTo(Long value) {
            addCriterion("accountid >=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThan(Long value) {
            addCriterion("accountid <", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThanOrEqualTo(Long value) {
            addCriterion("accountid <=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidIn(List<Long> values) {
            addCriterion("accountid in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotIn(List<Long> values) {
            addCriterion("accountid not in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidBetween(Long value1, Long value2) {
            addCriterion("accountid between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotBetween(Long value1, Long value2) {
            addCriterion("accountid not between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccttypeIsNull() {
            addCriterion("accttype is null");
            return (Criteria) this;
        }

        public Criteria andAccttypeIsNotNull() {
            addCriterion("accttype is not null");
            return (Criteria) this;
        }

        public Criteria andAccttypeEqualTo(Short value) {
            addCriterion("accttype =", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeNotEqualTo(Short value) {
            addCriterion("accttype <>", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeGreaterThan(Short value) {
            addCriterion("accttype >", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeGreaterThanOrEqualTo(Short value) {
            addCriterion("accttype >=", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeLessThan(Short value) {
            addCriterion("accttype <", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeLessThanOrEqualTo(Short value) {
            addCriterion("accttype <=", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeIn(List<Short> values) {
            addCriterion("accttype in", values, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeNotIn(List<Short> values) {
            addCriterion("accttype not in", values, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeBetween(Short value1, Short value2) {
            addCriterion("accttype between", value1, value2, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeNotBetween(Short value1, Short value2) {
            addCriterion("accttype not between", value1, value2, "accttype");
            return (Criteria) this;
        }

        public Criteria andDirectIsNull() {
            addCriterion("direct is null");
            return (Criteria) this;
        }

        public Criteria andDirectIsNotNull() {
            addCriterion("direct is not null");
            return (Criteria) this;
        }

        public Criteria andDirectEqualTo(Short value) {
            addCriterion("direct =", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectNotEqualTo(Short value) {
            addCriterion("direct <>", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectGreaterThan(Short value) {
            addCriterion("direct >", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectGreaterThanOrEqualTo(Short value) {
            addCriterion("direct >=", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectLessThan(Short value) {
            addCriterion("direct <", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectLessThanOrEqualTo(Short value) {
            addCriterion("direct <=", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectIn(List<Short> values) {
            addCriterion("direct in", values, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectNotIn(List<Short> values) {
            addCriterion("direct not in", values, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectBetween(Short value1, Short value2) {
            addCriterion("direct between", value1, value2, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectNotBetween(Short value1, Short value2) {
            addCriterion("direct not between", value1, value2, "direct");
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderid like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderid not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
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

        public Criteria andOtherorderIsNull() {
            addCriterion("otherorder is null");
            return (Criteria) this;
        }

        public Criteria andOtherorderIsNotNull() {
            addCriterion("otherorder is not null");
            return (Criteria) this;
        }

        public Criteria andOtherorderEqualTo(String value) {
            addCriterion("otherorder =", value, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderNotEqualTo(String value) {
            addCriterion("otherorder <>", value, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderGreaterThan(String value) {
            addCriterion("otherorder >", value, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderGreaterThanOrEqualTo(String value) {
            addCriterion("otherorder >=", value, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderLessThan(String value) {
            addCriterion("otherorder <", value, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderLessThanOrEqualTo(String value) {
            addCriterion("otherorder <=", value, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderLike(String value) {
            addCriterion("otherorder like", value, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderNotLike(String value) {
            addCriterion("otherorder not like", value, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderIn(List<String> values) {
            addCriterion("otherorder in", values, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderNotIn(List<String> values) {
            addCriterion("otherorder not in", values, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderBetween(String value1, String value2) {
            addCriterion("otherorder between", value1, value2, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtherorderNotBetween(String value1, String value2) {
            addCriterion("otherorder not between", value1, value2, "otherorder");
            return (Criteria) this;
        }

        public Criteria andOtheracctIsNull() {
            addCriterion("otheracct is null");
            return (Criteria) this;
        }

        public Criteria andOtheracctIsNotNull() {
            addCriterion("otheracct is not null");
            return (Criteria) this;
        }

        public Criteria andOtheracctEqualTo(String value) {
            addCriterion("otheracct =", value, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctNotEqualTo(String value) {
            addCriterion("otheracct <>", value, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctGreaterThan(String value) {
            addCriterion("otheracct >", value, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctGreaterThanOrEqualTo(String value) {
            addCriterion("otheracct >=", value, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctLessThan(String value) {
            addCriterion("otheracct <", value, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctLessThanOrEqualTo(String value) {
            addCriterion("otheracct <=", value, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctLike(String value) {
            addCriterion("otheracct like", value, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctNotLike(String value) {
            addCriterion("otheracct not like", value, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctIn(List<String> values) {
            addCriterion("otheracct in", values, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctNotIn(List<String> values) {
            addCriterion("otheracct not in", values, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctBetween(String value1, String value2) {
            addCriterion("otheracct between", value1, value2, "otheracct");
            return (Criteria) this;
        }

        public Criteria andOtheracctNotBetween(String value1, String value2) {
            addCriterion("otheracct not between", value1, value2, "otheracct");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Float value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Float value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Float value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Float value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Float value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Float> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Float> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Float value1, Float value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Float value1, Float value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Float value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Float value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Float value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Float value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Float value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Float value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Float> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Float> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Float value1, Float value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Float value1, Float value2) {
            addCriterion("balance not between", value1, value2, "balance");
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

        public Criteria andOptuseridIsNull() {
            addCriterion("optuserid is null");
            return (Criteria) this;
        }

        public Criteria andOptuseridIsNotNull() {
            addCriterion("optuserid is not null");
            return (Criteria) this;
        }

        public Criteria andOptuseridEqualTo(Long value) {
            addCriterion("optuserid =", value, "optuserid");
            return (Criteria) this;
        }

        public Criteria andOptuseridNotEqualTo(Long value) {
            addCriterion("optuserid <>", value, "optuserid");
            return (Criteria) this;
        }

        public Criteria andOptuseridGreaterThan(Long value) {
            addCriterion("optuserid >", value, "optuserid");
            return (Criteria) this;
        }

        public Criteria andOptuseridGreaterThanOrEqualTo(Long value) {
            addCriterion("optuserid >=", value, "optuserid");
            return (Criteria) this;
        }

        public Criteria andOptuseridLessThan(Long value) {
            addCriterion("optuserid <", value, "optuserid");
            return (Criteria) this;
        }

        public Criteria andOptuseridLessThanOrEqualTo(Long value) {
            addCriterion("optuserid <=", value, "optuserid");
            return (Criteria) this;
        }

        public Criteria andOptuseridIn(List<Long> values) {
            addCriterion("optuserid in", values, "optuserid");
            return (Criteria) this;
        }

        public Criteria andOptuseridNotIn(List<Long> values) {
            addCriterion("optuserid not in", values, "optuserid");
            return (Criteria) this;
        }

        public Criteria andOptuseridBetween(Long value1, Long value2) {
            addCriterion("optuserid between", value1, value2, "optuserid");
            return (Criteria) this;
        }

        public Criteria andOptuseridNotBetween(Long value1, Long value2) {
            addCriterion("optuserid not between", value1, value2, "optuserid");
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