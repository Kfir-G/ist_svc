package com.ist.svc.domain;

import java.util.Date;

public class MsgMember {
    private Long memberid;

    private Long groupid;

    private Short seq;

    private Short status;

    private Long talker;

    private String groupnickname;

    private String groupavatarurl;

    private Date createtime;

    private Date updatetime;

    private Long optuserid;

    private Long inviteuserid;

    private Date locktime;

    private Short role;

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public Short getSeq() {
        return seq;
    }

    public void setSeq(Short seq) {
        this.seq = seq;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getTalker() {
        return talker;
    }

    public void setTalker(Long talker) {
        this.talker = talker;
    }

    public String getGroupnickname() {
        return groupnickname;
    }

    public void setGroupnickname(String groupnickname) {
        this.groupnickname = groupnickname == null ? null : groupnickname.trim();
    }

    public String getGroupavatarurl() {
        return groupavatarurl;
    }

    public void setGroupavatarurl(String groupavatarurl) {
        this.groupavatarurl = groupavatarurl == null ? null : groupavatarurl.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getOptuserid() {
        return optuserid;
    }

    public void setOptuserid(Long optuserid) {
        this.optuserid = optuserid;
    }

    public Long getInviteuserid() {
        return inviteuserid;
    }

    public void setInviteuserid(Long inviteuserid) {
        this.inviteuserid = inviteuserid;
    }

    public Date getLocktime() {
        return locktime;
    }

    public void setLocktime(Date locktime) {
        this.locktime = locktime;
    }

    public Short getRole() {
        return role;
    }

    public void setRole(Short role) {
        this.role = role;
    }
}