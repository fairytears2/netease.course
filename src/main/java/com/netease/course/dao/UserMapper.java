package com.netease.course.dao;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.netease.course.bean.User;


public interface UserMapper {

	@Results(value = {
			@Result(property = "id", column = "id" ),
			@Result(property = "username", column = "userName" ),
			@Result(property="password",column = "password"),
			@Result(property = "nickname", column = "nickName" ),
			@Result(property = "userType", column = "userType" )
		})
	@Select("SELECT * FROM person WHERE userName=#{username} AND password=#{password}")
    User getUser(@Param("username")String username,@Param("password")String password);
}
