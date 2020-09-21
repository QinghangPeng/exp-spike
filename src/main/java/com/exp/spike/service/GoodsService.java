package com.exp.spike.service;

import com.exp.spike.domain.MiaoshaUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;

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

    public String toList(Model model, MiaoshaUser user) {
        model.addAttribute("user",user);
        return "goods_list";
    }

}
