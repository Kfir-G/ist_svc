package com.ist.svc.controller.model;

import lombok.Data;

/**
 * @Author: sunhaitao
 */
@Data
public class ProdDataByKey {
    private String prodInfoId;
    private String name;
    private String descr;
    private String topImgs;
    private String headImg;
    private Long minPrice;
    private Long maxPrice;
    private Long sales;
}
