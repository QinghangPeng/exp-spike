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

    public String toDetail(Model model, MiaoshaUser user, Long goodsId) {
        model.addAttribute("user",user);
        GoodsVo goods = getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods",goods);

        //
        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        //秒杀状态
        int miaoshaStatus = 0;
        //秒杀剩余时间
        int remainSeconds = 0;
        if (now < startAt) {
            //秒杀还未开始,倒计时
            miaoshaStatus = 0;
            remainSeconds = (int) (startAt - now) / 1000;
        } else if (now > endAt) {
            //秒杀已结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        } else {
            //秒杀进行中
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus",miaoshaStatus);
        model.addAttribute("remainSeconds",remainSeconds);
        return "goods_detail";
    }

    public List<GoodsVo> listGoodsVo() {
        return goodsDao.listGoodsVo();
    }

    public GoodsVo getGoodsVoByGoodsId(Long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }


}
