package com.exp.spike.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: OrderInfo
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-22 22:00
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
public class OrderInfo {

    private Long id;
    private Long userId;
    private Long goodsId;
    private Long deliveryAddrId;
    private String goodsName;
    private Integer goodsCount;
    private Double goodsPrice;
    private Integer orderChannel;
    private Integer status;
    private Date createDate;
    private Date payDate;

}
