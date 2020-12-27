package com.ist.svc.domain;

import java.util.Date;
import java.util.List;

public class MsgGroup {
    private Long groupid;

    private Short status;

    private Date createtime;

    private Date updatetime;

    private Long optuserid;

    private Short joingroup;

    private String groupName;

    private String avatarurl;

    private List<MsgMember> msgMembers;
    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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

    public Short getJoingroup() {
        return joingroup;
    }

    public void setJoingroup(Short joingroup) {
        this.joingroup = joingroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public List<MsgMember> getMsgMembers() {
        return msgMembers;
    }

    public void setMsgMembers(List<MsgMember> msgMembers) {
        this.msgMembers = msgMembers;
    }
}