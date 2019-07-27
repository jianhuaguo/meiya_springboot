package com.mei.demo.Dao;

import com.mei.demo.Domain.license;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

@Mapper
public interface licensedao {

    @Select("select phone,my_store.id as store_id,my_store.storename as storename,license,realname,id_card,id_number,description,my_license.update_time " +
            "from my_license left join my_store on my_license.store_id=my_store.id where my_license.`status`=#{status}")
    public ArrayList<license> selectlicense(int status);


    @Update("update my_license set `status`=2 where store_id=#{id}")
    public int passlicense(int id);

    @Update("update my_license set `status`=3 where store_id=#{id}")
    public int unpasslicense(int id);
}
