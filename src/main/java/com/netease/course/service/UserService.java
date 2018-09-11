package com.netease.course.service;

import com.netease.course.bean.User;

public interface UserService {

    User getUser(String username, String password);
}
