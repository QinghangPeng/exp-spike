package com.exp.spike.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: MiaoshaGoods
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-22 21:59
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
public class MiaoshaGoods {

    private Long id;
    private Long goodsId;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;

}
