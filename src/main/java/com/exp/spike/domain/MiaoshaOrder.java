package com.exp.spike.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: MiaoshaOrder
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-22 22:04
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
public class MiaoshaOrder {

    private Long id;
    private Long userId;
    private Long orderId;
    private Long goodsId;

}
