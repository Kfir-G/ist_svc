package com.ist.svc.domain;

import java.util.Date;
import java.util.List;

public class MsgWindow {
    private Long windowid;

    private Short type;

    private Integer shopid;

    private String shopname;

    private String shopavatarurl;

    private Long talker;

    private String nickname;

    private String avatarurl;

    private Date createtime;

    List<Msg> msgs;

    public Long getWindowid() {
        return windowid;
    }

    public void setWindowid(Long windowid) {
        this.windowid = windowid;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getShopavatarurl() {
        return shopavatarurl;
    }

    public void setShopavatarurl(String shopavatarurl) {
        this.shopavatarurl = shopavatarurl == null ? null : shopavatarurl.trim();
    }

    public Long getTalker() {
        return talker;
    }

    public void setTalker(Long talker) {
        this.talker = talker;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public List<Msg> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Msg> msgs) {
        this.msgs = msgs;
    }
}