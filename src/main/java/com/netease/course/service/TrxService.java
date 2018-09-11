package com.netease.course.service;



import java.util.List;

import com.netease.course.bean.Product;
import com.netease.course.bean.User;

public interface TrxService {

    List<Product> getBuyList(Integer userId);

    public void getSettleAccount(User user,Product product);
    
    boolean buy(User user, List<Product> productList, Long buyTime);
}
