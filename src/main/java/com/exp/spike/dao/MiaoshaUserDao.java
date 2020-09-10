package com.exp.spike.dao;

import com.exp.spike.domain.MiaoshaUser;
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
public interface MiaoshaUserDao {

    @Select("select * from miaosha_user where id = #{id}")
    MiaoshaUser getById(@Param("id") long id);

    @Select("select * from miaosha_user where nickname = #{nickname}")
    MiaoshaUser getByNickname(@Param("nickname") String nickname ) ;
}
