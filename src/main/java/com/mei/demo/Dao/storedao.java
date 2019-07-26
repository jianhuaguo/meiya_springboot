package com.mei.demo.Dao;
import com.mei.demo.Domain.Store;
import com.mei.demo.Domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface storedao {
    String TABLE_NAME="my_store";
    String INSERT_VALUE="storename,photo_url,phone,address,category_id,description";
    String SELECTVALUE="storename,photo_url,phone,address";
    //返回所有商家
//    @Results(id="storeMap",value={
//            @Result(id=true,column="id",property="id"),
//            @Result(column =" ",property = ""),
//    })

    @Select({"select * from ",TABLE_NAME})
    ArrayList<Store> SelectAll();

    @Select({"select * from ",TABLE_NAME, "where id=#{id}"})
    Store SelectById(int id);

    //通过名字获取
    @Select({"SELECT my_store.id, storename, photo_url, phone,address,`password`,salt,description,update_ip,my_store.create_time, my_store.update_time,my_store.`status`,category_id,my_category.name  FROM my_store LEFT JOIN my_category on my_store.category_id=my_category.id where storename like CONCAT('%',#{name},'%')"})
    ArrayList<Store> SelectByName(String name);

    @Delete({"Delete from ", TABLE_NAME," where id= #{id}"})
    int DeleteById(int id);

    @Update({"update ",TABLE_NAME," set storename= #{storename},phone=#{phone},address=#{address},description=#{description},photo_url=#{photo_url},category_id=#{category_id} where id= #{id}"})
    int updatestore(Store store);

    @Update({"update my_store set `status`= (case when `status`='0' then '1' else '0' end )  where id=#{id}"})
    int updatestatus(int id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_VALUE," ) values (#{storename},#{photo_url},#{phone},#{address},#{category_id},#{description})  "})
    int addStore(Store store);

//本月注册商家
    @Select("select count(*) from `my_store` where date_format(`create_time`, '%Y%m') = date_format(curdate() , '%Y%m')")
    int monthstore();

    @Select("SELECT count(*) from my_store where `status`=0")
    int freestore();

    @Select("SELECT count(*) from my_store where `status`=1")
    int unfreestore();

    @Select("select count(*) from my_store")
    int countstore();


}
