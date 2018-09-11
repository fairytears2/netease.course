package com.netease.course.controller;




import com.netease.course.bean.Product;
import com.netease.course.bean.User;
import com.netease.course.service.ProductService;
import com.netease.course.service.TrxService;
import com.netease.course.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class AjaxController {

	@Autowired
    private UserService userService;
	@Autowired
    private TrxService trxService;
	@Autowired
    private ProductService productService;

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session,
                       @RequestParam("userName") String username,
                       @RequestParam("password") String password,
                       Model model) {
        User user = userService.getUser(username, password);
        //验证用户名和密码正确
        if (user != null) {//登录成功
            model.addAttribute("code", 200);
            model.addAttribute("message", "登录成功");
            model.addAttribute("result", true);
            session.setAttribute("user", user);
        } else {
            model.addAttribute("code", 400);//失败的code自定义，前端对此无限制
            model.addAttribute("message", "用户名或密码错误");
            model.addAttribute("result", false);
        }
        System.out.println(user.getUsername());
        System.out.println(user.getUserType());
        return "redirect:/api/index";
    }
   
    
    //上传图片
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Model upload(HttpServletRequest request,
                        @RequestPart("file") MultipartFile img,
                        Model model) throws IOException {
        if (!img.isEmpty()) {
            //为上传的文件重命名
            String fileName = img.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf('.'));
            fileName = new Date().getTime() + suffix;
            //获取webapp部署的目录，函数的参数 是根目录下的子目录路径
            String localPath = request.getSession().getServletContext().getRealPath("image/")
                    + fileName;
            File image = new File(localPath);
            if (!image.getParentFile().exists()) {
                image.getParentFile().mkdirs();
            }
            img.transferTo(image);
            //声明图片的相对路径
            String imgUrl = "image/" + fileName;
            model.addAttribute("code", 200);
            model.addAttribute("message", "图片上传成功");
            model.addAttribute("result", imgUrl);
        } else {
            model.addAttribute("code", 400);
            model.addAttribute("message", "图片上传失败");
        }
        return model;
    }

    //删除
    @RequestMapping(value = "/delete")
    public String deleteProduct(@SessionAttribute(name = "user") User user,
                               @RequestParam("id") Integer id,
                               Model model) {
        if (user.getUserType() == 0 || !productService.deleteProdct(id)) {
            model.addAttribute("code", 400);
            model.addAttribute("message", "删除失败");
            model.addAttribute("result", false);
        } else {
            model.addAttribute("code", 200);
            model.addAttribute("message", "删除成功");
            model.addAttribute("result", true);
        }
        return "redirect:/api/index";
    }


    //购买
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public Model buy(@SessionAttribute(name = "user") User user,
                     @RequestBody List<Product> productList,
                     Model model) {
        //如果购买成功
        if (trxService.buy(user,productList, new Date().getTime())) {
            model.addAttribute("code", 200);
            model.addAttribute("message", "购买成功");
            model.addAttribute("result", true);
        } else {
            model.addAttribute("code", 400);
            model.addAttribute("message", "购买失败");
            model.addAttribute("result", false);
        }

        return model;
    }
}