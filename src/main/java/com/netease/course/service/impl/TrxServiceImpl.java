package com.netease.course.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.bean.Product;
import com.netease.course.bean.User;
import com.netease.course.dao.ProductMapper;
import com.netease.course.dao.TrxMapper;
import com.netease.course.service.TrxService;

import java.util.List;

@Service
public class TrxServiceImpl implements TrxService {

	@Autowired
    private TrxMapper trxMapper;
	@Autowired
    private ProductMapper productMapper;

    //获取已购买的商品列表
	@Override
    public List<Product> getBuyList(Integer userId) {
        List<Product> productList = trxMapper.getBuyList(userId);
        return productList;
    }

    //购买购物车里的商品,(待设置事务回滚)
	@Override
    public boolean buy(User user, List<Product> productList, Long buyTime) {
        boolean isBuy = false;

        for (Product product: productList) {
            int buyNum = product.getBuyNum();
            product = productMapper.getProduct(product.getId());

            String buyPrice = product.getPrice();
            product.setBuyNum(buyNum);
            product.setBuyPrice(buyPrice);
            isBuy = trxMapper.buy(product, buyTime);
            if (!isBuy) {
                throw new RuntimeException();
            }
        }

        return isBuy;
    }

	@Override
	public List<Product> getSettleList(Integer userId) {
		List<Product> productList = trxMapper.getSettleList(userId);
		return productList;
	}

	@Override
	public boolean setSettle(User user, Product product) {
		boolean isSet = false;
		if(product !=null) {
		isSet = trxMapper.setSettleAccount(user.getId(), product);
		}
		return isSet;
	}



}
