package com.codehuu.seckill.controller;

import com.codehuu.seckill.pojo.User;
import com.codehuu.seckill.service.IGoodsService;
import com.codehuu.seckill.service.IUserService;
import com.codehuu.seckill.vo.GoodsVo;
import com.codehuu.seckill.vo.LoginVo;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IGoodsService goodsService;

    /**
     * User类的传入由WebConfig类完成
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/toList")
    public String toList(Model model, User user){
        //返回前端User
        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }
   @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user , @PathVariable Long goodsId){
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date start = goodsVo.getStartDate();
        Date now = new Date();
        Date end = goodsVo.getEndDate();
        //定义秒杀的状态以及距离秒杀开始的时间
        int secKillStatus = -1, remainSeconds = 0;
        //秒杀还未开始
        if (now.before(start)) {
            secKillStatus = 0;
            remainSeconds = (int) (start.getTime() - now.getTime()) / 1000;
        }else if(now.after(end)){//秒杀结束
            secKillStatus = 2;
            remainSeconds = -1;
        }else{//秒杀进行中
            secKillStatus = 1;
            remainSeconds = 0;
        }
        //返回前端User
        model.addAttribute("remainSeconds", remainSeconds);
        model.addAttribute("secKillStatus", secKillStatus);
        model.addAttribute("user",user);
        model.addAttribute("goods", goodsVo);
        return "goodsDetail";
    }

}
