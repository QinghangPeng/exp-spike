package com.exp.spike.dao;

import com.exp.spike.domain.MiaoshaUser;
import com.exp.spike.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: OrdersDao
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-08-27 00:59
 * @Version: 1.0
 **/
@Mapper
public interface GoodsDao {

    @Select("select g.*,mg.stock_count,mg.miaosha_price,mg.start_date,mg.end_date " +
            "from miaosha_goods mg " +
            "left join goods g on mg.goods_id = g.id")
    List<GoodsVo> listGoodsVo();

}
