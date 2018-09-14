package com.netease.course.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.course.bean.Product;

import java.util.List;

public interface TrxMapper {

	@Results(id="trx", value = {
			@Result(property = "id", column = "id" ),
			@Result(property = "buyprice", column = "price" ),
			@Result(property="title",column = "title"),
			@Result(property = "num", column = "num" ),
			@Result(property = "image", column = "icon" ),
			@Result(property = "buytime", column = "time" ),
			@Result(property = "addsettle", column = "isbuy")
		})
	@Select("SELECT c.id, c.title, c.icon, t.num, t.time, t.price  FROM content c INNER JOIN trx t ON c.id=t.contentId WHERE t.personId=#{id} AND NOT EXISTS(select isbuy from trx)")
    List<Product> getBuyList(@Param("id") Integer userId);
    
	@Results( value = {
			@Result(property = "id", column = "id" ),
			@Result(property = "buyprice", column = "price" ),
			@Result(property="title",column = "title"),
			@Result(property = "num", column = "num" ),
			@Result(property = "image", column = "icon" ),
			@Result(property = "buytime", column = "time" ),
			@Result(property = "addsettle", column = "isbuy")
		})
	@Select("SELECT c.id, c.title, c.icon, t.num, t.time, t.price  FROM content c INNER JOIN trx t ON c.id=t.contentId WHERE t.personId=#{id} AND EXISTS(select isbuy from trx)")
	List<Product> getSettleList(@Param("id") Integer userId);
	
	@ResultMap("trx")
	@Insert("INSERT INTO trx(contentId, personId, num, price) " +
            "VALUE (#{product.id}, #{id}, #{product.buyNum}, #{product.buyPrice} )")
    boolean setSettleAccount(@Param("id") Integer id, @Param("product") Product product);

	
	@ResultMap("trx")
    @Update("update trx set isbuy = #{product.buy},time = #{buytime} where contentId = #{product.id}")
    boolean buy( @Param("product") Product product,@Param("buyTime") Long buyTime);
}
