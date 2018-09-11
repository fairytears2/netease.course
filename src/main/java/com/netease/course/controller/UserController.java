package com.netease.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @RequestMapping(value="/login")
    public String login(HttpSession session) {   	
        //判断是否已经登录
        if (session.getAttribute("user") != null) {
        	System.out.println("login");
        	System.out.println(session.getAttribute("user"));
            return "redirect:/api/index";
        }else {
        	System.out.println("no");
        	return "redirect:/login.html";
        }    
    }

    
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/api/login";
    }
    
}
