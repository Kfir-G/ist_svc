package com.ist.svc.controller.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author: sunhaitao
 */
@Data
public class ProdQueryData {
    private String prodInfoId;
    private String name;
    private String descr;
    private String topImgs;
    private String headImg;
    private Long total;
    private List<ProdInfo> prodInfos;
}
