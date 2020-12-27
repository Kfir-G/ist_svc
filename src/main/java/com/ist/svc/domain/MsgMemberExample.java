package com.ist.svc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MsgMemberExample() {
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

        public Criteria andMemberidIsNull() {
            addCriterion("memberid is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberid is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Long value) {
            addCriterion("memberid =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Long value) {
            addCriterion("memberid <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Long value) {
            addCriterion("memberid >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Long value) {
            addCriterion("memberid >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Long value) {
            addCriterion("memberid <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Long value) {
            addCriterion("memberid <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Long> values) {
            addCriterion("memberid in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Long> values) {
            addCriterion("memberid not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Long value1, Long value2) {
            addCriterion("memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Long value1, Long value2) {
            addCriterion("memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNull() {
            addCriterion("groupid is null");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNotNull() {
            addCriterion("groupid is not null");
            return (Criteria) this;
        }

        public Criteria andGroupidEqualTo(Long value) {
            addCriterion("groupid =", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotEqualTo(Long value) {
            addCriterion("groupid <>", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThan(Long value) {
            addCriterion("groupid >", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThanOrEqualTo(Long value) {
            addCriterion("groupid >=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThan(Long value) {
            addCriterion("groupid <", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThanOrEqualTo(Long value) {
            addCriterion("groupid <=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidIn(List<Long> values) {
            addCriterion("groupid in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotIn(List<Long> values) {
            addCriterion("groupid not in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidBetween(Long value1, Long value2) {
            addCriterion("groupid between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotBetween(Long value1, Long value2) {
            addCriterion("groupid not between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("seq is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("seq is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(Short value) {
            addCriterion("seq =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(Short value) {
            addCriterion("seq <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(Short value) {
            addCriterion("seq >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Short value) {
            addCriterion("seq >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(Short value) {
            addCriterion("seq <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(Short value) {
            addCriterion("seq <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<Short> values) {
            addCriterion("seq in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Short> values) {
            addCriterion("seq not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(Short value1, Short value2) {
            addCriterion("seq between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(Short value1, Short value2) {
            addCriterion("seq not between", value1, value2, "seq");
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

        public Criteria andTalkerIsNull() {
            addCriterion("talker is null");
            return (Criteria) this;
        }

        public Criteria andTalkerIsNotNull() {
            addCriterion("talker is not null");
            return (Criteria) this;
        }

        public Criteria andTalkerEqualTo(Long value) {
            addCriterion("talker =", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerNotEqualTo(Long value) {
            addCriterion("talker <>", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerGreaterThan(Long value) {
            addCriterion("talker >", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerGreaterThanOrEqualTo(Long value) {
            addCriterion("talker >=", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerLessThan(Long value) {
            addCriterion("talker <", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerLessThanOrEqualTo(Long value) {
            addCriterion("talker <=", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerIn(List<Long> values) {
            addCriterion("talker in", values, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerNotIn(List<Long> values) {
            addCriterion("talker not in", values, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerBetween(Long value1, Long value2) {
            addCriterion("talker between", value1, value2, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerNotBetween(Long value1, Long value2) {
            addCriterion("talker not between", value1, value2, "talker");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameIsNull() {
            addCriterion("groupnickname is null");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameIsNotNull() {
            addCriterion("groupnickname is not null");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameEqualTo(String value) {
            addCriterion("groupnickname =", value, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameNotEqualTo(String value) {
            addCriterion("groupnickname <>", value, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameGreaterThan(String value) {
            addCriterion("groupnickname >", value, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameGreaterThanOrEqualTo(String value) {
            addCriterion("groupnickname >=", value, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameLessThan(String value) {
            addCriterion("groupnickname <", value, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameLessThanOrEqualTo(String value) {
            addCriterion("groupnickname <=", value, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameLike(String value) {
            addCriterion("groupnickname like", value, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameNotLike(String value) {
            addCriterion("groupnickname not like", value, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameIn(List<String> values) {
            addCriterion("groupnickname in", values, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameNotIn(List<String> values) {
            addCriterion("groupnickname not in", values, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameBetween(String value1, String value2) {
            addCriterion("groupnickname between", value1, value2, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupnicknameNotBetween(String value1, String value2) {
            addCriterion("groupnickname not between", value1, value2, "groupnickname");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlIsNull() {
            addCriterion("groupavatarurl is null");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlIsNotNull() {
            addCriterion("groupavatarurl is not null");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlEqualTo(String value) {
            addCriterion("groupavatarurl =", value, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlNotEqualTo(String value) {
            addCriterion("groupavatarurl <>", value, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlGreaterThan(String value) {
            addCriterion("groupavatarurl >", value, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlGreaterThanOrEqualTo(String value) {
            addCriterion("groupavatarurl >=", value, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlLessThan(String value) {
            addCriterion("groupavatarurl <", value, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlLessThanOrEqualTo(String value) {
            addCriterion("groupavatarurl <=", value, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlLike(String value) {
            addCriterion("groupavatarurl like", value, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlNotLike(String value) {
            addCriterion("groupavatarurl not like", value, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlIn(List<String> values) {
            addCriterion("groupavatarurl in", values, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlNotIn(List<String> values) {
            addCriterion("groupavatarurl not in", values, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlBetween(String value1, String value2) {
            addCriterion("groupavatarurl between", value1, value2, "groupavatarurl");
            return (Criteria) this;
        }

        public Criteria andGroupavatarurlNotBetween(String value1, String value2) {
            addCriterion("groupavatarurl not between", value1, value2, "groupavatarurl");
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

        public Criteria andInviteuseridIsNull() {
            addCriterion("inviteuserId is null");
            return (Criteria) this;
        }

        public Criteria andInviteuseridIsNotNull() {
            addCriterion("inviteuserId is not null");
            return (Criteria) this;
        }

        public Criteria andInviteuseridEqualTo(Long value) {
            addCriterion("inviteuserId =", value, "inviteuserid");
            return (Criteria) this;
        }

        public Criteria andInviteuseridNotEqualTo(Long value) {
            addCriterion("inviteuserId <>", value, "inviteuserid");
            return (Criteria) this;
        }

        public Criteria andInviteuseridGreaterThan(Long value) {
            addCriterion("inviteuserId >", value, "inviteuserid");
            return (Criteria) this;
        }

        public Criteria andInviteuseridGreaterThanOrEqualTo(Long value) {
            addCriterion("inviteuserId >=", value, "inviteuserid");
            return (Criteria) this;
        }

        public Criteria andInviteuseridLessThan(Long value) {
            addCriterion("inviteuserId <", value, "inviteuserid");
            return (Criteria) this;
        }

        public Criteria andInviteuseridLessThanOrEqualTo(Long value) {
            addCriterion("inviteuserId <=", value, "inviteuserid");
            return (Criteria) this;
        }

        public Criteria andInviteuseridIn(List<Long> values) {
            addCriterion("inviteuserId in", values, "inviteuserid");
            return (Criteria) this;
        }

        public Criteria andInviteuseridNotIn(List<Long> values) {
            addCriterion("inviteuserId not in", values, "inviteuserid");
            return (Criteria) this;
        }

        public Criteria andInviteuseridBetween(Long value1, Long value2) {
            addCriterion("inviteuserId between", value1, value2, "inviteuserid");
            return (Criteria) this;
        }

        public Criteria andInviteuseridNotBetween(Long value1, Long value2) {
            addCriterion("inviteuserId not between", value1, value2, "inviteuserid");
            return (Criteria) this;
        }

        public Criteria andLocktimeIsNull() {
            addCriterion("Locktime is null");
            return (Criteria) this;
        }

        public Criteria andLocktimeIsNotNull() {
            addCriterion("Locktime is not null");
            return (Criteria) this;
        }

        public Criteria andLocktimeEqualTo(Date value) {
            addCriterion("Locktime =", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeNotEqualTo(Date value) {
            addCriterion("Locktime <>", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeGreaterThan(Date value) {
            addCriterion("Locktime >", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Locktime >=", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeLessThan(Date value) {
            addCriterion("Locktime <", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeLessThanOrEqualTo(Date value) {
            addCriterion("Locktime <=", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeIn(List<Date> values) {
            addCriterion("Locktime in", values, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeNotIn(List<Date> values) {
            addCriterion("Locktime not in", values, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeBetween(Date value1, Date value2) {
            addCriterion("Locktime between", value1, value2, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeNotBetween(Date value1, Date value2) {
            addCriterion("Locktime not between", value1, value2, "locktime");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("`role` is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("`role` is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Short value) {
            addCriterion("`role` =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Short value) {
            addCriterion("`role` <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Short value) {
            addCriterion("`role` >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Short value) {
            addCriterion("`role` >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Short value) {
            addCriterion("`role` <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Short value) {
            addCriterion("`role` <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Short> values) {
            addCriterion("`role` in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Short> values) {
            addCriterion("`role` not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Short value1, Short value2) {
            addCriterion("`role` between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Short value1, Short value2) {
            addCriterion("`role` not between", value1, value2, "role");
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