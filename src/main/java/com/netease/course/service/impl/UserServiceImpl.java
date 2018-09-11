package com.netease.course.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.bean.User;
import com.netease.course.dao.UserMapper;
import com.netease.course.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
    UserMapper userMapper; 

    //验证用户名和密码
	@Override
	public User getUser(String username, String password) {
    	System.out.println("登陆实现");
        return userMapper.getUser(username, password);
    }
}
