package com.exp.spike.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: OrdersDao
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-08-27 00:59
 * @Version: 1.0
 **/
@Mapper
public interface OrdersDao {

    @Select("select address from orders where oid = #{id}")
    String getById(@Param("id") String id);
}
