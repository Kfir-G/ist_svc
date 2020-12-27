package com.ist.svc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProdExample() {
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

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Short value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Short value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Short value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Short value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Short value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Short value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Short> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Short> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Short value1, Short value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Short value1, Short value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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

        public Criteria andProvinceidIsNull() {
            addCriterion("provinceid is null");
            return (Criteria) this;
        }

        public Criteria andProvinceidIsNotNull() {
            addCriterion("provinceid is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceidEqualTo(Short value) {
            addCriterion("provinceid =", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidNotEqualTo(Short value) {
            addCriterion("provinceid <>", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidGreaterThan(Short value) {
            addCriterion("provinceid >", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidGreaterThanOrEqualTo(Short value) {
            addCriterion("provinceid >=", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidLessThan(Short value) {
            addCriterion("provinceid <", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidLessThanOrEqualTo(Short value) {
            addCriterion("provinceid <=", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidIn(List<Short> values) {
            addCriterion("provinceid in", values, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidNotIn(List<Short> values) {
            addCriterion("provinceid not in", values, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidBetween(Short value1, Short value2) {
            addCriterion("provinceid between", value1, value2, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidNotBetween(Short value1, Short value2) {
            addCriterion("provinceid not between", value1, value2, "provinceid");
            return (Criteria) this;
        }

        public Criteria andCityidIsNull() {
            addCriterion("cityid is null");
            return (Criteria) this;
        }

        public Criteria andCityidIsNotNull() {
            addCriterion("cityid is not null");
            return (Criteria) this;
        }

        public Criteria andCityidEqualTo(Short value) {
            addCriterion("cityid =", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotEqualTo(Short value) {
            addCriterion("cityid <>", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThan(Short value) {
            addCriterion("cityid >", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThanOrEqualTo(Short value) {
            addCriterion("cityid >=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThan(Short value) {
            addCriterion("cityid <", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThanOrEqualTo(Short value) {
            addCriterion("cityid <=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidIn(List<Short> values) {
            addCriterion("cityid in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotIn(List<Short> values) {
            addCriterion("cityid not in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidBetween(Short value1, Short value2) {
            addCriterion("cityid between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotBetween(Short value1, Short value2) {
            addCriterion("cityid not between", value1, value2, "cityid");
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

        public Criteria andProdnameIsNull() {
            addCriterion("prodname is null");
            return (Criteria) this;
        }

        public Criteria andProdnameIsNotNull() {
            addCriterion("prodname is not null");
            return (Criteria) this;
        }

        public Criteria andProdnameEqualTo(String value) {
            addCriterion("prodname =", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotEqualTo(String value) {
            addCriterion("prodname <>", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameGreaterThan(String value) {
            addCriterion("prodname >", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameGreaterThanOrEqualTo(String value) {
            addCriterion("prodname >=", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameLessThan(String value) {
            addCriterion("prodname <", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameLessThanOrEqualTo(String value) {
            addCriterion("prodname <=", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameLike(String value) {
            addCriterion("prodname like", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotLike(String value) {
            addCriterion("prodname not like", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameIn(List<String> values) {
            addCriterion("prodname in", values, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotIn(List<String> values) {
            addCriterion("prodname not in", values, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameBetween(String value1, String value2) {
            addCriterion("prodname between", value1, value2, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotBetween(String value1, String value2) {
            addCriterion("prodname not between", value1, value2, "prodname");
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

        public Criteria andTopimgsIsNull() {
            addCriterion("topimgs is null");
            return (Criteria) this;
        }

        public Criteria andTopimgsIsNotNull() {
            addCriterion("topimgs is not null");
            return (Criteria) this;
        }

        public Criteria andTopimgsEqualTo(String value) {
            addCriterion("topimgs =", value, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsNotEqualTo(String value) {
            addCriterion("topimgs <>", value, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsGreaterThan(String value) {
            addCriterion("topimgs >", value, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsGreaterThanOrEqualTo(String value) {
            addCriterion("topimgs >=", value, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsLessThan(String value) {
            addCriterion("topimgs <", value, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsLessThanOrEqualTo(String value) {
            addCriterion("topimgs <=", value, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsLike(String value) {
            addCriterion("topimgs like", value, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsNotLike(String value) {
            addCriterion("topimgs not like", value, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsIn(List<String> values) {
            addCriterion("topimgs in", values, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsNotIn(List<String> values) {
            addCriterion("topimgs not in", values, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsBetween(String value1, String value2) {
            addCriterion("topimgs between", value1, value2, "topimgs");
            return (Criteria) this;
        }

        public Criteria andTopimgsNotBetween(String value1, String value2) {
            addCriterion("topimgs not between", value1, value2, "topimgs");
            return (Criteria) this;
        }

        public Criteria andVideoIsNull() {
            addCriterion("video is null");
            return (Criteria) this;
        }

        public Criteria andVideoIsNotNull() {
            addCriterion("video is not null");
            return (Criteria) this;
        }

        public Criteria andVideoEqualTo(String value) {
            addCriterion("video =", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotEqualTo(String value) {
            addCriterion("video <>", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoGreaterThan(String value) {
            addCriterion("video >", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoGreaterThanOrEqualTo(String value) {
            addCriterion("video >=", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoLessThan(String value) {
            addCriterion("video <", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoLessThanOrEqualTo(String value) {
            addCriterion("video <=", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoLike(String value) {
            addCriterion("video like", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotLike(String value) {
            addCriterion("video not like", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoIn(List<String> values) {
            addCriterion("video in", values, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotIn(List<String> values) {
            addCriterion("video not in", values, "video");
            return (Criteria) this;
        }

        public Criteria andVideoBetween(String value1, String value2) {
            addCriterion("video between", value1, value2, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotBetween(String value1, String value2) {
            addCriterion("video not between", value1, value2, "video");
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

        public Criteria andParameterjsonIsNull() {
            addCriterion("parameterjson is null");
            return (Criteria) this;
        }

        public Criteria andParameterjsonIsNotNull() {
            addCriterion("parameterjson is not null");
            return (Criteria) this;
        }

        public Criteria andParameterjsonEqualTo(String value) {
            addCriterion("parameterjson =", value, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonNotEqualTo(String value) {
            addCriterion("parameterjson <>", value, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonGreaterThan(String value) {
            addCriterion("parameterjson >", value, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonGreaterThanOrEqualTo(String value) {
            addCriterion("parameterjson >=", value, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonLessThan(String value) {
            addCriterion("parameterjson <", value, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonLessThanOrEqualTo(String value) {
            addCriterion("parameterjson <=", value, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonLike(String value) {
            addCriterion("parameterjson like", value, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonNotLike(String value) {
            addCriterion("parameterjson not like", value, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonIn(List<String> values) {
            addCriterion("parameterjson in", values, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonNotIn(List<String> values) {
            addCriterion("parameterjson not in", values, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonBetween(String value1, String value2) {
            addCriterion("parameterjson between", value1, value2, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andParameterjsonNotBetween(String value1, String value2) {
            addCriterion("parameterjson not between", value1, value2, "parameterjson");
            return (Criteria) this;
        }

        public Criteria andMatterIsNull() {
            addCriterion("matter is null");
            return (Criteria) this;
        }

        public Criteria andMatterIsNotNull() {
            addCriterion("matter is not null");
            return (Criteria) this;
        }

        public Criteria andMatterEqualTo(String value) {
            addCriterion("matter =", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterNotEqualTo(String value) {
            addCriterion("matter <>", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterGreaterThan(String value) {
            addCriterion("matter >", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterGreaterThanOrEqualTo(String value) {
            addCriterion("matter >=", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterLessThan(String value) {
            addCriterion("matter <", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterLessThanOrEqualTo(String value) {
            addCriterion("matter <=", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterLike(String value) {
            addCriterion("matter like", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterNotLike(String value) {
            addCriterion("matter not like", value, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterIn(List<String> values) {
            addCriterion("matter in", values, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterNotIn(List<String> values) {
            addCriterion("matter not in", values, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterBetween(String value1, String value2) {
            addCriterion("matter between", value1, value2, "matter");
            return (Criteria) this;
        }

        public Criteria andMatterNotBetween(String value1, String value2) {
            addCriterion("matter not between", value1, value2, "matter");
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

        public Criteria andBuylimitIsNull() {
            addCriterion("buylimit is null");
            return (Criteria) this;
        }

        public Criteria andBuylimitIsNotNull() {
            addCriterion("buylimit is not null");
            return (Criteria) this;
        }

        public Criteria andBuylimitEqualTo(Short value) {
            addCriterion("buylimit =", value, "buylimit");
            return (Criteria) this;
        }

        public Criteria andBuylimitNotEqualTo(Short value) {
            addCriterion("buylimit <>", value, "buylimit");
            return (Criteria) this;
        }

        public Criteria andBuylimitGreaterThan(Short value) {
            addCriterion("buylimit >", value, "buylimit");
            return (Criteria) this;
        }

        public Criteria andBuylimitGreaterThanOrEqualTo(Short value) {
            addCriterion("buylimit >=", value, "buylimit");
            return (Criteria) this;
        }

        public Criteria andBuylimitLessThan(Short value) {
            addCriterion("buylimit <", value, "buylimit");
            return (Criteria) this;
        }

        public Criteria andBuylimitLessThanOrEqualTo(Short value) {
            addCriterion("buylimit <=", value, "buylimit");
            return (Criteria) this;
        }

        public Criteria andBuylimitIn(List<Short> values) {
            addCriterion("buylimit in", values, "buylimit");
            return (Criteria) this;
        }

        public Criteria andBuylimitNotIn(List<Short> values) {
            addCriterion("buylimit not in", values, "buylimit");
            return (Criteria) this;
        }

        public Criteria andBuylimitBetween(Short value1, Short value2) {
            addCriterion("buylimit between", value1, value2, "buylimit");
            return (Criteria) this;
        }

        public Criteria andBuylimitNotBetween(Short value1, Short value2) {
            addCriterion("buylimit not between", value1, value2, "buylimit");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysIsNull() {
            addCriterion("buylimitdays is null");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysIsNotNull() {
            addCriterion("buylimitdays is not null");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysEqualTo(Short value) {
            addCriterion("buylimitdays =", value, "buylimitdays");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysNotEqualTo(Short value) {
            addCriterion("buylimitdays <>", value, "buylimitdays");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysGreaterThan(Short value) {
            addCriterion("buylimitdays >", value, "buylimitdays");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysGreaterThanOrEqualTo(Short value) {
            addCriterion("buylimitdays >=", value, "buylimitdays");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysLessThan(Short value) {
            addCriterion("buylimitdays <", value, "buylimitdays");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysLessThanOrEqualTo(Short value) {
            addCriterion("buylimitdays <=", value, "buylimitdays");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysIn(List<Short> values) {
            addCriterion("buylimitdays in", values, "buylimitdays");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysNotIn(List<Short> values) {
            addCriterion("buylimitdays not in", values, "buylimitdays");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysBetween(Short value1, Short value2) {
            addCriterion("buylimitdays between", value1, value2, "buylimitdays");
            return (Criteria) this;
        }

        public Criteria andBuylimitdaysNotBetween(Short value1, Short value2) {
            addCriterion("buylimitdays not between", value1, value2, "buylimitdays");
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

        public Criteria andOfflinetimeIsNull() {
            addCriterion("offlinetime is null");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeIsNotNull() {
            addCriterion("offlinetime is not null");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeEqualTo(Date value) {
            addCriterion("offlinetime =", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeNotEqualTo(Date value) {
            addCriterion("offlinetime <>", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeGreaterThan(Date value) {
            addCriterion("offlinetime >", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("offlinetime >=", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeLessThan(Date value) {
            addCriterion("offlinetime <", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeLessThanOrEqualTo(Date value) {
            addCriterion("offlinetime <=", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeIn(List<Date> values) {
            addCriterion("offlinetime in", values, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeNotIn(List<Date> values) {
            addCriterion("offlinetime not in", values, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeBetween(Date value1, Date value2) {
            addCriterion("offlinetime between", value1, value2, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeNotBetween(Date value1, Date value2) {
            addCriterion("offlinetime not between", value1, value2, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeIsNull() {
            addCriterion("salestarttime is null");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeIsNotNull() {
            addCriterion("salestarttime is not null");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeEqualTo(Date value) {
            addCriterion("salestarttime =", value, "salestarttime");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeNotEqualTo(Date value) {
            addCriterion("salestarttime <>", value, "salestarttime");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeGreaterThan(Date value) {
            addCriterion("salestarttime >", value, "salestarttime");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("salestarttime >=", value, "salestarttime");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeLessThan(Date value) {
            addCriterion("salestarttime <", value, "salestarttime");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeLessThanOrEqualTo(Date value) {
            addCriterion("salestarttime <=", value, "salestarttime");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeIn(List<Date> values) {
            addCriterion("salestarttime in", values, "salestarttime");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeNotIn(List<Date> values) {
            addCriterion("salestarttime not in", values, "salestarttime");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeBetween(Date value1, Date value2) {
            addCriterion("salestarttime between", value1, value2, "salestarttime");
            return (Criteria) this;
        }

        public Criteria andSalestarttimeNotBetween(Date value1, Date value2) {
            addCriterion("salestarttime not between", value1, value2, "salestarttime");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeIsNull() {
            addCriterion("saleendtime is null");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeIsNotNull() {
            addCriterion("saleendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeEqualTo(Date value) {
            addCriterion("saleendtime =", value, "saleendtime");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeNotEqualTo(Date value) {
            addCriterion("saleendtime <>", value, "saleendtime");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeGreaterThan(Date value) {
            addCriterion("saleendtime >", value, "saleendtime");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("saleendtime >=", value, "saleendtime");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeLessThan(Date value) {
            addCriterion("saleendtime <", value, "saleendtime");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeLessThanOrEqualTo(Date value) {
            addCriterion("saleendtime <=", value, "saleendtime");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeIn(List<Date> values) {
            addCriterion("saleendtime in", values, "saleendtime");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeNotIn(List<Date> values) {
            addCriterion("saleendtime not in", values, "saleendtime");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeBetween(Date value1, Date value2) {
            addCriterion("saleendtime between", value1, value2, "saleendtime");
            return (Criteria) this;
        }

        public Criteria andSaleendtimeNotBetween(Date value1, Date value2) {
            addCriterion("saleendtime not between", value1, value2, "saleendtime");
            return (Criteria) this;
        }

        public Criteria andIsprecardIsNull() {
            addCriterion("isprecard is null");
            return (Criteria) this;
        }

        public Criteria andIsprecardIsNotNull() {
            addCriterion("isprecard is not null");
            return (Criteria) this;
        }

        public Criteria andIsprecardEqualTo(Short value) {
            addCriterion("isprecard =", value, "isprecard");
            return (Criteria) this;
        }

        public Criteria andIsprecardNotEqualTo(Short value) {
            addCriterion("isprecard <>", value, "isprecard");
            return (Criteria) this;
        }

        public Criteria andIsprecardGreaterThan(Short value) {
            addCriterion("isprecard >", value, "isprecard");
            return (Criteria) this;
        }

        public Criteria andIsprecardGreaterThanOrEqualTo(Short value) {
            addCriterion("isprecard >=", value, "isprecard");
            return (Criteria) this;
        }

        public Criteria andIsprecardLessThan(Short value) {
            addCriterion("isprecard <", value, "isprecard");
            return (Criteria) this;
        }

        public Criteria andIsprecardLessThanOrEqualTo(Short value) {
            addCriterion("isprecard <=", value, "isprecard");
            return (Criteria) this;
        }

        public Criteria andIsprecardIn(List<Short> values) {
            addCriterion("isprecard in", values, "isprecard");
            return (Criteria) this;
        }

        public Criteria andIsprecardNotIn(List<Short> values) {
            addCriterion("isprecard not in", values, "isprecard");
            return (Criteria) this;
        }

        public Criteria andIsprecardBetween(Short value1, Short value2) {
            addCriterion("isprecard between", value1, value2, "isprecard");
            return (Criteria) this;
        }

        public Criteria andIsprecardNotBetween(Short value1, Short value2) {
            addCriterion("isprecard not between", value1, value2, "isprecard");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeIsNull() {
            addCriterion("hascanceltype is null");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeIsNotNull() {
            addCriterion("hascanceltype is not null");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeEqualTo(Short value) {
            addCriterion("hascanceltype =", value, "hascanceltype");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeNotEqualTo(Short value) {
            addCriterion("hascanceltype <>", value, "hascanceltype");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeGreaterThan(Short value) {
            addCriterion("hascanceltype >", value, "hascanceltype");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeGreaterThanOrEqualTo(Short value) {
            addCriterion("hascanceltype >=", value, "hascanceltype");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeLessThan(Short value) {
            addCriterion("hascanceltype <", value, "hascanceltype");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeLessThanOrEqualTo(Short value) {
            addCriterion("hascanceltype <=", value, "hascanceltype");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeIn(List<Short> values) {
            addCriterion("hascanceltype in", values, "hascanceltype");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeNotIn(List<Short> values) {
            addCriterion("hascanceltype not in", values, "hascanceltype");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeBetween(Short value1, Short value2) {
            addCriterion("hascanceltype between", value1, value2, "hascanceltype");
            return (Criteria) this;
        }

        public Criteria andHascanceltypeNotBetween(Short value1, Short value2) {
            addCriterion("hascanceltype not between", value1, value2, "hascanceltype");
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