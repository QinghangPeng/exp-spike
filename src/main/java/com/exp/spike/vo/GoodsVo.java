package com.exp.spike.vo;

import com.exp.spike.domain.Goods;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: GoodsVo
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-22 22:07
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
public class GoodsVo extends Goods {

    private Double miaoshaPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;

}
