package com.netease.course.controller;

import com.netease.course.bean.Product;
import com.netease.course.bean.User;
import com.netease.course.service.TrxService;
import com.sun.org.apache.xpath.internal.operations.Mod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

import java.util.List;

@Controller
public class TrxController {

	@Autowired
    private TrxService trxService;

    
    //账务页
    @RequestMapping(value="/account")
    public String getAccount(@SessionAttribute(name = "user", required = false) User user,
                             Model model) {
    	System.out.println("账务页");
        if (user == null || user.getUserType() == 1){
            return "redirect:/";
        }
        List<Product> buyList = trxService.getBuyList(user.getId());
        model.addAttribute("buyList", buyList);
        return "account";
    }

    //购物车
    @RequestMapping(value="/settleAccount")
    public String settleAccount(@SessionAttribute(name = "user") User user){
    	System.out.println("购物车");
        if (user == null || user.getUserType() == 1){
            return "redirect:/";
        }else {
        	
        	return "settleAccount";
        }
        
    }
}
