 package com.netease.course.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.netease.course.bean.Product;
import com.netease.course.bean.User;
import com.netease.course.service.ProductService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
	@Autowired
    private ProductService productService;

    //展示页
    @RequestMapping(value="/index")
    public String index(@RequestParam(name = "type", required = false) String type,
                        @SessionAttribute(name = "user", required = false) User user,
                        Model model) {
        List<Product> productList = productService.getProductList(user, type);

        model.addAttribute("productList", productList);
        System.out.println("展示");
        return "index";
    }

    //查看页
    @RequestMapping(value="/show")
    public String show(@RequestParam("id") Integer productId,
                       @SessionAttribute(name = "user", required = false) User user,
                       Model model,HttpSession session) {
        Product product = productService.getProduct(user, productId);
        model.addAttribute("product", product);
        session.setAttribute("productid", productId);
        System.out.println("查看");
        return "show";
    }

    
    //发布页
    @RequestMapping(value="/public")
    public String publicPage(@SessionAttribute(name = "user") User user) {
        if (user == null || user.getUserType() == 0) {
            return "redirect:/";
        }
        System.out.println("发布");
        return "public";
    }

    //发布提交
    @RequestMapping(value = "/publicSubmit", method = RequestMethod.POST)
    public String publicSubmit(@Valid Product product,
                               BindingResult result,
                               @SessionAttribute(name = "user") User user,
                               Model model) {
    	System.out.println("发布提交");
        if (user == null || user.getUserType() == 0) {
            return "redirect:/";
        }
        //如果校验出错 或者 商品的种类已经超出1000种，那么就发布失败
        if (!result.hasErrors() && productService.getCount() <= 1000) {
            productService.publicProduct(product);
            model.addAttribute("product", product);
        }
        return "publicSubmit";
    }

    //编辑页
    @RequestMapping(value="/edit")
    public String edit(@SessionAttribute(name = "user") User user,
                       @RequestParam("id") Integer productId,
                       Model model) {
        if (user == null || user.getUserType() == 0) {
            return "redirect:/";
        }
        model.addAttribute("product", productService.getProduct(user, productId));

        return "edit";
    }

    //编辑提交
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String  editSubmit(@Valid Product product,
                              BindingResult result,
                              @SessionAttribute(name = "user") User user,
                              Model model){
        if (user == null || user.getUserType() == 0) {
            return "redirect:/";
        }
        //如果校验正确，就更新商品信息
        if (!result.hasErrors() && productService.updateProduct(product)) {
            model.addAttribute("product.id", product.getId());
            model.addAttribute("productId", product.getId());
        }
        return "editSubmit";
    }

//    @RequestMapping(value="/delete")
//    public String delete(@Valid Product product,
//            BindingResult result,
//            @SessionAttribute(name = "user") User user,
//            Model model) {
//        if (user == null || user.getUserType() == 0) {
//            return "redirect:/";
//        }
//        if (!result.hasErrors() && productService.deleteProdct(product.getId())) {
//            model.addAttribute("product.id", product.getId());
//            model.addAttribute("productId", product.getId());
//        }
//    	return "editSubmit";
//    }
}
