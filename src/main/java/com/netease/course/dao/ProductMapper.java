package com.netease.course.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.netease.course.bean.Product;
import com.netease.course.utils.ConvertBlobTypeHandler;


import java.util.List;

public interface ProductMapper {
 
	@Results(id="content", value = {
			@Result(property = "id", column = "id" ),
			@Result(property = "price", column = "price" ),
			@Result(property="title",column = "title"),
			@Result(property = "num", column = "num" ),
			@Result(property = "image", column = "icon" ),
			@Result(property = "summary", column = "abstract" ),
			@Result(property = "detail", column = "text" ,typeHandler=ConvertBlobTypeHandler.class),
			@Result(property = "trxCount", column = "trxCount" ),
		})
	@Select("SELECT c.*, (SELECT COUNT(*) FROM trx t WHERE t.contentId=c.id) AS trxCount FROM content c")
    List<Product> getProductList();

	@ResultMap("content")
	@Select("SELECT c.*, (SELECT COUNT(*) FROM trx t WHERE t.contentId=c.id) AS trxCount FROM content c WHERE c.id=#{id}")
    Product getProduct(@Param("id") Integer id);

	@ResultMap("content")
    @Insert("INSERT INTO content(price, title, num, icon, abstract, text) " +
            "VALUE (#{price}, #{title}, #{num}, #{image}, #{summary}, #{detail})")
    @Options(useGeneratedKeys = true)
    void publicProduct(Product product);

	@Select("SELECT COUNT(*) FROM content")
    int getCount();

	
	@ResultMap("content")
    @Insert("UPDATE content SET price=#{price}, title=#{title}, " +
            "icon=#{image}, abstract= #{summary}, text=#{detail} " +
            "WHERE id=#{id}")
    boolean updateProduct(Product product);
 
    //如果已经发生过交易，则不能删除
	@ResultMap("content")
    @Delete("DELETE FROM content WHERE id=#{id} " +
            "AND NOT EXISTS(SELECT * FROM trx WHERE contentId=#{id})")
    boolean deleteProduct(@Param("id") Integer id);
}
