package com.exp.spike.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Goods
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-22 21:57
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
public class Goods {

    private Long id;
    private String goodsName;
    private String goodsTtile;
    private String goodsImg;
    private String goodsDetail;
    private Double goodsPrice;
    private Integer goodsStock;

}
