package com.ist.svc.domain;

public class InfoProdType {
    private Short prodtype;

    private String name;

    public Short getProdtype() {
        return prodtype;
    }

    public void setProdtype(Short prodtype) {
        this.prodtype = prodtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}