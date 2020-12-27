package com.ist.svc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdLimitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProdLimitExample() {
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

        public Criteria andProdlimitidIsNull() {
            addCriterion("prodlimitid is null");
            return (Criteria) this;
        }

        public Criteria andProdlimitidIsNotNull() {
            addCriterion("prodlimitid is not null");
            return (Criteria) this;
        }

        public Criteria andProdlimitidEqualTo(Integer value) {
            addCriterion("prodlimitid =", value, "prodlimitid");
            return (Criteria) this;
        }

        public Criteria andProdlimitidNotEqualTo(Integer value) {
            addCriterion("prodlimitid <>", value, "prodlimitid");
            return (Criteria) this;
        }

        public Criteria andProdlimitidGreaterThan(Integer value) {
            addCriterion("prodlimitid >", value, "prodlimitid");
            return (Criteria) this;
        }

        public Criteria andProdlimitidGreaterThanOrEqualTo(Integer value) {
            addCriterion("prodlimitid >=", value, "prodlimitid");
            return (Criteria) this;
        }

        public Criteria andProdlimitidLessThan(Integer value) {
            addCriterion("prodlimitid <", value, "prodlimitid");
            return (Criteria) this;
        }

        public Criteria andProdlimitidLessThanOrEqualTo(Integer value) {
            addCriterion("prodlimitid <=", value, "prodlimitid");
            return (Criteria) this;
        }

        public Criteria andProdlimitidIn(List<Integer> values) {
            addCriterion("prodlimitid in", values, "prodlimitid");
            return (Criteria) this;
        }

        public Criteria andProdlimitidNotIn(List<Integer> values) {
            addCriterion("prodlimitid not in", values, "prodlimitid");
            return (Criteria) this;
        }

        public Criteria andProdlimitidBetween(Integer value1, Integer value2) {
            addCriterion("prodlimitid between", value1, value2, "prodlimitid");
            return (Criteria) this;
        }

        public Criteria andProdlimitidNotBetween(Integer value1, Integer value2) {
            addCriterion("prodlimitid not between", value1, value2, "prodlimitid");
            return (Criteria) this;
        }

        public Criteria andTradetypeidIsNull() {
            addCriterion("tradetypeid is null");
            return (Criteria) this;
        }

        public Criteria andTradetypeidIsNotNull() {
            addCriterion("tradetypeid is not null");
            return (Criteria) this;
        }

        public Criteria andTradetypeidEqualTo(Short value) {
            addCriterion("tradetypeid =", value, "tradetypeid");
            return (Criteria) this;
        }

        public Criteria andTradetypeidNotEqualTo(Short value) {
            addCriterion("tradetypeid <>", value, "tradetypeid");
            return (Criteria) this;
        }

        public Criteria andTradetypeidGreaterThan(Short value) {
            addCriterion("tradetypeid >", value, "tradetypeid");
            return (Criteria) this;
        }

        public Criteria andTradetypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("tradetypeid >=", value, "tradetypeid");
            return (Criteria) this;
        }

        public Criteria andTradetypeidLessThan(Short value) {
            addCriterion("tradetypeid <", value, "tradetypeid");
            return (Criteria) this;
        }

        public Criteria andTradetypeidLessThanOrEqualTo(Short value) {
            addCriterion("tradetypeid <=", value, "tradetypeid");
            return (Criteria) this;
        }

        public Criteria andTradetypeidIn(List<Short> values) {
            addCriterion("tradetypeid in", values, "tradetypeid");
            return (Criteria) this;
        }

        public Criteria andTradetypeidNotIn(List<Short> values) {
            addCriterion("tradetypeid not in", values, "tradetypeid");
            return (Criteria) this;
        }

        public Criteria andTradetypeidBetween(Short value1, Short value2) {
            addCriterion("tradetypeid between", value1, value2, "tradetypeid");
            return (Criteria) this;
        }

        public Criteria andTradetypeidNotBetween(Short value1, Short value2) {
            addCriterion("tradetypeid not between", value1, value2, "tradetypeid");
            return (Criteria) this;
        }

        public Criteria andProdtypeidIsNull() {
            addCriterion("prodtypeid is null");
            return (Criteria) this;
        }

        public Criteria andProdtypeidIsNotNull() {
            addCriterion("prodtypeid is not null");
            return (Criteria) this;
        }

        public Criteria andProdtypeidEqualTo(Short value) {
            addCriterion("prodtypeid =", value, "prodtypeid");
            return (Criteria) this;
        }

        public Criteria andProdtypeidNotEqualTo(Short value) {
            addCriterion("prodtypeid <>", value, "prodtypeid");
            return (Criteria) this;
        }

        public Criteria andProdtypeidGreaterThan(Short value) {
            addCriterion("prodtypeid >", value, "prodtypeid");
            return (Criteria) this;
        }

        public Criteria andProdtypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("prodtypeid >=", value, "prodtypeid");
            return (Criteria) this;
        }

        public Criteria andProdtypeidLessThan(Short value) {
            addCriterion("prodtypeid <", value, "prodtypeid");
            return (Criteria) this;
        }

        public Criteria andProdtypeidLessThanOrEqualTo(Short value) {
            addCriterion("prodtypeid <=", value, "prodtypeid");
            return (Criteria) this;
        }

        public Criteria andProdtypeidIn(List<Short> values) {
            addCriterion("prodtypeid in", values, "prodtypeid");
            return (Criteria) this;
        }

        public Criteria andProdtypeidNotIn(List<Short> values) {
            addCriterion("prodtypeid not in", values, "prodtypeid");
            return (Criteria) this;
        }

        public Criteria andProdtypeidBetween(Short value1, Short value2) {
            addCriterion("prodtypeid between", value1, value2, "prodtypeid");
            return (Criteria) this;
        }

        public Criteria andProdtypeidNotBetween(Short value1, Short value2) {
            addCriterion("prodtypeid not between", value1, value2, "prodtypeid");
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

        public Criteria andSafekeepminIsNull() {
            addCriterion("safekeepmin is null");
            return (Criteria) this;
        }

        public Criteria andSafekeepminIsNotNull() {
            addCriterion("safekeepmin is not null");
            return (Criteria) this;
        }

        public Criteria andSafekeepminEqualTo(Short value) {
            addCriterion("safekeepmin =", value, "safekeepmin");
            return (Criteria) this;
        }

        public Criteria andSafekeepminNotEqualTo(Short value) {
            addCriterion("safekeepmin <>", value, "safekeepmin");
            return (Criteria) this;
        }

        public Criteria andSafekeepminGreaterThan(Short value) {
            addCriterion("safekeepmin >", value, "safekeepmin");
            return (Criteria) this;
        }

        public Criteria andSafekeepminGreaterThanOrEqualTo(Short value) {
            addCriterion("safekeepmin >=", value, "safekeepmin");
            return (Criteria) this;
        }

        public Criteria andSafekeepminLessThan(Short value) {
            addCriterion("safekeepmin <", value, "safekeepmin");
            return (Criteria) this;
        }

        public Criteria andSafekeepminLessThanOrEqualTo(Short value) {
            addCriterion("safekeepmin <=", value, "safekeepmin");
            return (Criteria) this;
        }

        public Criteria andSafekeepminIn(List<Short> values) {
            addCriterion("safekeepmin in", values, "safekeepmin");
            return (Criteria) this;
        }

        public Criteria andSafekeepminNotIn(List<Short> values) {
            addCriterion("safekeepmin not in", values, "safekeepmin");
            return (Criteria) this;
        }

        public Criteria andSafekeepminBetween(Short value1, Short value2) {
            addCriterion("safekeepmin between", value1, value2, "safekeepmin");
            return (Criteria) this;
        }

        public Criteria andSafekeepminNotBetween(Short value1, Short value2) {
            addCriterion("safekeepmin not between", value1, value2, "safekeepmin");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxIsNull() {
            addCriterion("safekeepmax is null");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxIsNotNull() {
            addCriterion("safekeepmax is not null");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxEqualTo(Short value) {
            addCriterion("safekeepmax =", value, "safekeepmax");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxNotEqualTo(Short value) {
            addCriterion("safekeepmax <>", value, "safekeepmax");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxGreaterThan(Short value) {
            addCriterion("safekeepmax >", value, "safekeepmax");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxGreaterThanOrEqualTo(Short value) {
            addCriterion("safekeepmax >=", value, "safekeepmax");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxLessThan(Short value) {
            addCriterion("safekeepmax <", value, "safekeepmax");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxLessThanOrEqualTo(Short value) {
            addCriterion("safekeepmax <=", value, "safekeepmax");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxIn(List<Short> values) {
            addCriterion("safekeepmax in", values, "safekeepmax");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxNotIn(List<Short> values) {
            addCriterion("safekeepmax not in", values, "safekeepmax");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxBetween(Short value1, Short value2) {
            addCriterion("safekeepmax between", value1, value2, "safekeepmax");
            return (Criteria) this;
        }

        public Criteria andSafekeepmaxNotBetween(Short value1, Short value2) {
            addCriterion("safekeepmax not between", value1, value2, "safekeepmax");
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

        public Criteria andSafekeeparriveIsNull() {
            addCriterion("safekeeparrive is null");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveIsNotNull() {
            addCriterion("safekeeparrive is not null");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveEqualTo(Short value) {
            addCriterion("safekeeparrive =", value, "safekeeparrive");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveNotEqualTo(Short value) {
            addCriterion("safekeeparrive <>", value, "safekeeparrive");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveGreaterThan(Short value) {
            addCriterion("safekeeparrive >", value, "safekeeparrive");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveGreaterThanOrEqualTo(Short value) {
            addCriterion("safekeeparrive >=", value, "safekeeparrive");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveLessThan(Short value) {
            addCriterion("safekeeparrive <", value, "safekeeparrive");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveLessThanOrEqualTo(Short value) {
            addCriterion("safekeeparrive <=", value, "safekeeparrive");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveIn(List<Short> values) {
            addCriterion("safekeeparrive in", values, "safekeeparrive");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveNotIn(List<Short> values) {
            addCriterion("safekeeparrive not in", values, "safekeeparrive");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveBetween(Short value1, Short value2) {
            addCriterion("safekeeparrive between", value1, value2, "safekeeparrive");
            return (Criteria) this;
        }

        public Criteria andSafekeeparriveNotBetween(Short value1, Short value2) {
            addCriterion("safekeeparrive not between", value1, value2, "safekeeparrive");
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

        public Criteria andCancelhoursIsNull() {
            addCriterion("cancelhours is null");
            return (Criteria) this;
        }

        public Criteria andCancelhoursIsNotNull() {
            addCriterion("cancelhours is not null");
            return (Criteria) this;
        }

        public Criteria andCancelhoursEqualTo(Float value) {
            addCriterion("cancelhours =", value, "cancelhours");
            return (Criteria) this;
        }

        public Criteria andCancelhoursNotEqualTo(Float value) {
            addCriterion("cancelhours <>", value, "cancelhours");
            return (Criteria) this;
        }

        public Criteria andCancelhoursGreaterThan(Float value) {
            addCriterion("cancelhours >", value, "cancelhours");
            return (Criteria) this;
        }

        public Criteria andCancelhoursGreaterThanOrEqualTo(Float value) {
            addCriterion("cancelhours >=", value, "cancelhours");
            return (Criteria) this;
        }

        public Criteria andCancelhoursLessThan(Float value) {
            addCriterion("cancelhours <", value, "cancelhours");
            return (Criteria) this;
        }

        public Criteria andCancelhoursLessThanOrEqualTo(Float value) {
            addCriterion("cancelhours <=", value, "cancelhours");
            return (Criteria) this;
        }

        public Criteria andCancelhoursIn(List<Float> values) {
            addCriterion("cancelhours in", values, "cancelhours");
            return (Criteria) this;
        }

        public Criteria andCancelhoursNotIn(List<Float> values) {
            addCriterion("cancelhours not in", values, "cancelhours");
            return (Criteria) this;
        }

        public Criteria andCancelhoursBetween(Float value1, Float value2) {
            addCriterion("cancelhours between", value1, value2, "cancelhours");
            return (Criteria) this;
        }

        public Criteria andCancelhoursNotBetween(Float value1, Float value2) {
            addCriterion("cancelhours not between", value1, value2, "cancelhours");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeIsNull() {
            addCriterion("overhourscanceltype is null");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeIsNotNull() {
            addCriterion("overhourscanceltype is not null");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeEqualTo(Short value) {
            addCriterion("overhourscanceltype =", value, "overhourscanceltype");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeNotEqualTo(Short value) {
            addCriterion("overhourscanceltype <>", value, "overhourscanceltype");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeGreaterThan(Short value) {
            addCriterion("overhourscanceltype >", value, "overhourscanceltype");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeGreaterThanOrEqualTo(Short value) {
            addCriterion("overhourscanceltype >=", value, "overhourscanceltype");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeLessThan(Short value) {
            addCriterion("overhourscanceltype <", value, "overhourscanceltype");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeLessThanOrEqualTo(Short value) {
            addCriterion("overhourscanceltype <=", value, "overhourscanceltype");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeIn(List<Short> values) {
            addCriterion("overhourscanceltype in", values, "overhourscanceltype");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeNotIn(List<Short> values) {
            addCriterion("overhourscanceltype not in", values, "overhourscanceltype");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeBetween(Short value1, Short value2) {
            addCriterion("overhourscanceltype between", value1, value2, "overhourscanceltype");
            return (Criteria) this;
        }

        public Criteria andOverhourscanceltypeNotBetween(Short value1, Short value2) {
            addCriterion("overhourscanceltype not between", value1, value2, "overhourscanceltype");
            return (Criteria) this;
        }

        public Criteria andCancelfeeIsNull() {
            addCriterion("cancelfee is null");
            return (Criteria) this;
        }

        public Criteria andCancelfeeIsNotNull() {
            addCriterion("cancelfee is not null");
            return (Criteria) this;
        }

        public Criteria andCancelfeeEqualTo(Float value) {
            addCriterion("cancelfee =", value, "cancelfee");
            return (Criteria) this;
        }

        public Criteria andCancelfeeNotEqualTo(Float value) {
            addCriterion("cancelfee <>", value, "cancelfee");
            return (Criteria) this;
        }

        public Criteria andCancelfeeGreaterThan(Float value) {
            addCriterion("cancelfee >", value, "cancelfee");
            return (Criteria) this;
        }

        public Criteria andCancelfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("cancelfee >=", value, "cancelfee");
            return (Criteria) this;
        }

        public Criteria andCancelfeeLessThan(Float value) {
            addCriterion("cancelfee <", value, "cancelfee");
            return (Criteria) this;
        }

        public Criteria andCancelfeeLessThanOrEqualTo(Float value) {
            addCriterion("cancelfee <=", value, "cancelfee");
            return (Criteria) this;
        }

        public Criteria andCancelfeeIn(List<Float> values) {
            addCriterion("cancelfee in", values, "cancelfee");
            return (Criteria) this;
        }

        public Criteria andCancelfeeNotIn(List<Float> values) {
            addCriterion("cancelfee not in", values, "cancelfee");
            return (Criteria) this;
        }

        public Criteria andCancelfeeBetween(Float value1, Float value2) {
            addCriterion("cancelfee between", value1, value2, "cancelfee");
            return (Criteria) this;
        }

        public Criteria andCancelfeeNotBetween(Float value1, Float value2) {
            addCriterion("cancelfee not between", value1, value2, "cancelfee");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeIsNull() {
            addCriterion("begincanceltype is null");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeIsNotNull() {
            addCriterion("begincanceltype is not null");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeEqualTo(Short value) {
            addCriterion("begincanceltype =", value, "begincanceltype");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeNotEqualTo(Short value) {
            addCriterion("begincanceltype <>", value, "begincanceltype");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeGreaterThan(Short value) {
            addCriterion("begincanceltype >", value, "begincanceltype");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeGreaterThanOrEqualTo(Short value) {
            addCriterion("begincanceltype >=", value, "begincanceltype");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeLessThan(Short value) {
            addCriterion("begincanceltype <", value, "begincanceltype");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeLessThanOrEqualTo(Short value) {
            addCriterion("begincanceltype <=", value, "begincanceltype");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeIn(List<Short> values) {
            addCriterion("begincanceltype in", values, "begincanceltype");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeNotIn(List<Short> values) {
            addCriterion("begincanceltype not in", values, "begincanceltype");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeBetween(Short value1, Short value2) {
            addCriterion("begincanceltype between", value1, value2, "begincanceltype");
            return (Criteria) this;
        }

        public Criteria andBegincanceltypeNotBetween(Short value1, Short value2) {
            addCriterion("begincanceltype not between", value1, value2, "begincanceltype");
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

        public Criteria andBegincancelfeeIsNull() {
            addCriterion("begincancelfee is null");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeIsNotNull() {
            addCriterion("begincancelfee is not null");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeEqualTo(Float value) {
            addCriterion("begincancelfee =", value, "begincancelfee");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeNotEqualTo(Float value) {
            addCriterion("begincancelfee <>", value, "begincancelfee");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeGreaterThan(Float value) {
            addCriterion("begincancelfee >", value, "begincancelfee");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("begincancelfee >=", value, "begincancelfee");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeLessThan(Float value) {
            addCriterion("begincancelfee <", value, "begincancelfee");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeLessThanOrEqualTo(Float value) {
            addCriterion("begincancelfee <=", value, "begincancelfee");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeIn(List<Float> values) {
            addCriterion("begincancelfee in", values, "begincancelfee");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeNotIn(List<Float> values) {
            addCriterion("begincancelfee not in", values, "begincancelfee");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeBetween(Float value1, Float value2) {
            addCriterion("begincancelfee between", value1, value2, "begincancelfee");
            return (Criteria) this;
        }

        public Criteria andBegincancelfeeNotBetween(Float value1, Float value2) {
            addCriterion("begincancelfee not between", value1, value2, "begincancelfee");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeIsNull() {
            addCriterion("endcancelfee is null");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeIsNotNull() {
            addCriterion("endcancelfee is not null");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeEqualTo(Float value) {
            addCriterion("endcancelfee =", value, "endcancelfee");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeNotEqualTo(Float value) {
            addCriterion("endcancelfee <>", value, "endcancelfee");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeGreaterThan(Float value) {
            addCriterion("endcancelfee >", value, "endcancelfee");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("endcancelfee >=", value, "endcancelfee");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeLessThan(Float value) {
            addCriterion("endcancelfee <", value, "endcancelfee");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeLessThanOrEqualTo(Float value) {
            addCriterion("endcancelfee <=", value, "endcancelfee");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeIn(List<Float> values) {
            addCriterion("endcancelfee in", values, "endcancelfee");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeNotIn(List<Float> values) {
            addCriterion("endcancelfee not in", values, "endcancelfee");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeBetween(Float value1, Float value2) {
            addCriterion("endcancelfee between", value1, value2, "endcancelfee");
            return (Criteria) this;
        }

        public Criteria andEndcancelfeeNotBetween(Float value1, Float value2) {
            addCriterion("endcancelfee not between", value1, value2, "endcancelfee");
            return (Criteria) this;
        }

        public Criteria andTransfertypeIsNull() {
            addCriterion("transfertype is null");
            return (Criteria) this;
        }

        public Criteria andTransfertypeIsNotNull() {
            addCriterion("transfertype is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertypeEqualTo(Short value) {
            addCriterion("transfertype =", value, "transfertype");
            return (Criteria) this;
        }

        public Criteria andTransfertypeNotEqualTo(Short value) {
            addCriterion("transfertype <>", value, "transfertype");
            return (Criteria) this;
        }

        public Criteria andTransfertypeGreaterThan(Short value) {
            addCriterion("transfertype >", value, "transfertype");
            return (Criteria) this;
        }

        public Criteria andTransfertypeGreaterThanOrEqualTo(Short value) {
            addCriterion("transfertype >=", value, "transfertype");
            return (Criteria) this;
        }

        public Criteria andTransfertypeLessThan(Short value) {
            addCriterion("transfertype <", value, "transfertype");
            return (Criteria) this;
        }

        public Criteria andTransfertypeLessThanOrEqualTo(Short value) {
            addCriterion("transfertype <=", value, "transfertype");
            return (Criteria) this;
        }

        public Criteria andTransfertypeIn(List<Short> values) {
            addCriterion("transfertype in", values, "transfertype");
            return (Criteria) this;
        }

        public Criteria andTransfertypeNotIn(List<Short> values) {
            addCriterion("transfertype not in", values, "transfertype");
            return (Criteria) this;
        }

        public Criteria andTransfertypeBetween(Short value1, Short value2) {
            addCriterion("transfertype between", value1, value2, "transfertype");
            return (Criteria) this;
        }

        public Criteria andTransfertypeNotBetween(Short value1, Short value2) {
            addCriterion("transfertype not between", value1, value2, "transfertype");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeIsNull() {
            addCriterion("transferfeetype is null");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeIsNotNull() {
            addCriterion("transferfeetype is not null");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeEqualTo(Short value) {
            addCriterion("transferfeetype =", value, "transferfeetype");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeNotEqualTo(Short value) {
            addCriterion("transferfeetype <>", value, "transferfeetype");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeGreaterThan(Short value) {
            addCriterion("transferfeetype >", value, "transferfeetype");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeGreaterThanOrEqualTo(Short value) {
            addCriterion("transferfeetype >=", value, "transferfeetype");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeLessThan(Short value) {
            addCriterion("transferfeetype <", value, "transferfeetype");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeLessThanOrEqualTo(Short value) {
            addCriterion("transferfeetype <=", value, "transferfeetype");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeIn(List<Short> values) {
            addCriterion("transferfeetype in", values, "transferfeetype");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeNotIn(List<Short> values) {
            addCriterion("transferfeetype not in", values, "transferfeetype");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeBetween(Short value1, Short value2) {
            addCriterion("transferfeetype between", value1, value2, "transferfeetype");
            return (Criteria) this;
        }

        public Criteria andTransferfeetypeNotBetween(Short value1, Short value2) {
            addCriterion("transferfeetype not between", value1, value2, "transferfeetype");
            return (Criteria) this;
        }

        public Criteria andTransferfeeIsNull() {
            addCriterion("transferfee is null");
            return (Criteria) this;
        }

        public Criteria andTransferfeeIsNotNull() {
            addCriterion("transferfee is not null");
            return (Criteria) this;
        }

        public Criteria andTransferfeeEqualTo(Float value) {
            addCriterion("transferfee =", value, "transferfee");
            return (Criteria) this;
        }

        public Criteria andTransferfeeNotEqualTo(Float value) {
            addCriterion("transferfee <>", value, "transferfee");
            return (Criteria) this;
        }

        public Criteria andTransferfeeGreaterThan(Float value) {
            addCriterion("transferfee >", value, "transferfee");
            return (Criteria) this;
        }

        public Criteria andTransferfeeGreaterThanOrEqualTo(Float value) {
            addCriterion("transferfee >=", value, "transferfee");
            return (Criteria) this;
        }

        public Criteria andTransferfeeLessThan(Float value) {
            addCriterion("transferfee <", value, "transferfee");
            return (Criteria) this;
        }

        public Criteria andTransferfeeLessThanOrEqualTo(Float value) {
            addCriterion("transferfee <=", value, "transferfee");
            return (Criteria) this;
        }

        public Criteria andTransferfeeIn(List<Float> values) {
            addCriterion("transferfee in", values, "transferfee");
            return (Criteria) this;
        }

        public Criteria andTransferfeeNotIn(List<Float> values) {
            addCriterion("transferfee not in", values, "transferfee");
            return (Criteria) this;
        }

        public Criteria andTransferfeeBetween(Float value1, Float value2) {
            addCriterion("transferfee between", value1, value2, "transferfee");
            return (Criteria) this;
        }

        public Criteria andTransferfeeNotBetween(Float value1, Float value2) {
            addCriterion("transferfee not between", value1, value2, "transferfee");
            return (Criteria) this;
        }

        public Criteria andTransfernumIsNull() {
            addCriterion("transfernum is null");
            return (Criteria) this;
        }

        public Criteria andTransfernumIsNotNull() {
            addCriterion("transfernum is not null");
            return (Criteria) this;
        }

        public Criteria andTransfernumEqualTo(Short value) {
            addCriterion("transfernum =", value, "transfernum");
            return (Criteria) this;
        }

        public Criteria andTransfernumNotEqualTo(Short value) {
            addCriterion("transfernum <>", value, "transfernum");
            return (Criteria) this;
        }

        public Criteria andTransfernumGreaterThan(Short value) {
            addCriterion("transfernum >", value, "transfernum");
            return (Criteria) this;
        }

        public Criteria andTransfernumGreaterThanOrEqualTo(Short value) {
            addCriterion("transfernum >=", value, "transfernum");
            return (Criteria) this;
        }

        public Criteria andTransfernumLessThan(Short value) {
            addCriterion("transfernum <", value, "transfernum");
            return (Criteria) this;
        }

        public Criteria andTransfernumLessThanOrEqualTo(Short value) {
            addCriterion("transfernum <=", value, "transfernum");
            return (Criteria) this;
        }

        public Criteria andTransfernumIn(List<Short> values) {
            addCriterion("transfernum in", values, "transfernum");
            return (Criteria) this;
        }

        public Criteria andTransfernumNotIn(List<Short> values) {
            addCriterion("transfernum not in", values, "transfernum");
            return (Criteria) this;
        }

        public Criteria andTransfernumBetween(Short value1, Short value2) {
            addCriterion("transfernum between", value1, value2, "transfernum");
            return (Criteria) this;
        }

        public Criteria andTransfernumNotBetween(Short value1, Short value2) {
            addCriterion("transfernum not between", value1, value2, "transfernum");
            return (Criteria) this;
        }

        public Criteria andTransferpriceIsNull() {
            addCriterion("transferprice is null");
            return (Criteria) this;
        }

        public Criteria andTransferpriceIsNotNull() {
            addCriterion("transferprice is not null");
            return (Criteria) this;
        }

        public Criteria andTransferpriceEqualTo(Float value) {
            addCriterion("transferprice =", value, "transferprice");
            return (Criteria) this;
        }

        public Criteria andTransferpriceNotEqualTo(Float value) {
            addCriterion("transferprice <>", value, "transferprice");
            return (Criteria) this;
        }

        public Criteria andTransferpriceGreaterThan(Float value) {
            addCriterion("transferprice >", value, "transferprice");
            return (Criteria) this;
        }

        public Criteria andTransferpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("transferprice >=", value, "transferprice");
            return (Criteria) this;
        }

        public Criteria andTransferpriceLessThan(Float value) {
            addCriterion("transferprice <", value, "transferprice");
            return (Criteria) this;
        }

        public Criteria andTransferpriceLessThanOrEqualTo(Float value) {
            addCriterion("transferprice <=", value, "transferprice");
            return (Criteria) this;
        }

        public Criteria andTransferpriceIn(List<Float> values) {
            addCriterion("transferprice in", values, "transferprice");
            return (Criteria) this;
        }

        public Criteria andTransferpriceNotIn(List<Float> values) {
            addCriterion("transferprice not in", values, "transferprice");
            return (Criteria) this;
        }

        public Criteria andTransferpriceBetween(Float value1, Float value2) {
            addCriterion("transferprice between", value1, value2, "transferprice");
            return (Criteria) this;
        }

        public Criteria andTransferpriceNotBetween(Float value1, Float value2) {
            addCriterion("transferprice not between", value1, value2, "transferprice");
            return (Criteria) this;
        }

        public Criteria andSharetypeIsNull() {
            addCriterion("sharetype is null");
            return (Criteria) this;
        }

        public Criteria andSharetypeIsNotNull() {
            addCriterion("sharetype is not null");
            return (Criteria) this;
        }

        public Criteria andSharetypeEqualTo(Short value) {
            addCriterion("sharetype =", value, "sharetype");
            return (Criteria) this;
        }

        public Criteria andSharetypeNotEqualTo(Short value) {
            addCriterion("sharetype <>", value, "sharetype");
            return (Criteria) this;
        }

        public Criteria andSharetypeGreaterThan(Short value) {
            addCriterion("sharetype >", value, "sharetype");
            return (Criteria) this;
        }

        public Criteria andSharetypeGreaterThanOrEqualTo(Short value) {
            addCriterion("sharetype >=", value, "sharetype");
            return (Criteria) this;
        }

        public Criteria andSharetypeLessThan(Short value) {
            addCriterion("sharetype <", value, "sharetype");
            return (Criteria) this;
        }

        public Criteria andSharetypeLessThanOrEqualTo(Short value) {
            addCriterion("sharetype <=", value, "sharetype");
            return (Criteria) this;
        }

        public Criteria andSharetypeIn(List<Short> values) {
            addCriterion("sharetype in", values, "sharetype");
            return (Criteria) this;
        }

        public Criteria andSharetypeNotIn(List<Short> values) {
            addCriterion("sharetype not in", values, "sharetype");
            return (Criteria) this;
        }

        public Criteria andSharetypeBetween(Short value1, Short value2) {
            addCriterion("sharetype between", value1, value2, "sharetype");
            return (Criteria) this;
        }

        public Criteria andSharetypeNotBetween(Short value1, Short value2) {
            addCriterion("sharetype not between", value1, value2, "sharetype");
            return (Criteria) this;
        }

        public Criteria andSharenumIsNull() {
            addCriterion("sharenum is null");
            return (Criteria) this;
        }

        public Criteria andSharenumIsNotNull() {
            addCriterion("sharenum is not null");
            return (Criteria) this;
        }

        public Criteria andSharenumEqualTo(Short value) {
            addCriterion("sharenum =", value, "sharenum");
            return (Criteria) this;
        }

        public Criteria andSharenumNotEqualTo(Short value) {
            addCriterion("sharenum <>", value, "sharenum");
            return (Criteria) this;
        }

        public Criteria andSharenumGreaterThan(Short value) {
            addCriterion("sharenum >", value, "sharenum");
            return (Criteria) this;
        }

        public Criteria andSharenumGreaterThanOrEqualTo(Short value) {
            addCriterion("sharenum >=", value, "sharenum");
            return (Criteria) this;
        }

        public Criteria andSharenumLessThan(Short value) {
            addCriterion("sharenum <", value, "sharenum");
            return (Criteria) this;
        }

        public Criteria andSharenumLessThanOrEqualTo(Short value) {
            addCriterion("sharenum <=", value, "sharenum");
            return (Criteria) this;
        }

        public Criteria andSharenumIn(List<Short> values) {
            addCriterion("sharenum in", values, "sharenum");
            return (Criteria) this;
        }

        public Criteria andSharenumNotIn(List<Short> values) {
            addCriterion("sharenum not in", values, "sharenum");
            return (Criteria) this;
        }

        public Criteria andSharenumBetween(Short value1, Short value2) {
            addCriterion("sharenum between", value1, value2, "sharenum");
            return (Criteria) this;
        }

        public Criteria andSharenumNotBetween(Short value1, Short value2) {
            addCriterion("sharenum not between", value1, value2, "sharenum");
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