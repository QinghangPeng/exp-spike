package com.exp.spike.service;

import com.exp.spike.dao.GoodsDao;
import com.exp.spike.domain.MiaoshaUser;
import com.exp.spike.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: GoodsService
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-17 01:08
 * @Version: 1.0
 **/
@Service
@Slf4j
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;

    public String toList(Model model, MiaoshaUser user) {
        model.addAttribute("user",user);
        //查询商品列表
        List<GoodsVo> goodsList = listGoodsVo();
        model.addAttribute("goodsList",goodsList);
        return "goods_list";
    }

    public List<GoodsVo> listGoodsVo() {
        return goodsDao.listGoodsVo();
    }

}
