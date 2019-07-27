package com.mei.demo.Dao;

import com.mei.demo.Domain.event;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface eventdao {


    //这个如果活动失效了 可以设置只选前一百或者前两百个活动
    @Select("select * from my_events where name like CONCAT('%',#{name},'%')")
    public  ArrayList<event> selectallevent(String name);

    //更新订单
    @Update("update my_events set name= #{name},start_time=#{start_time},end_time=#{end_time},description=#{description} where id= #{id}")
    int updateevent(event event);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into  my_events (name,start_time,end_time,description,`STATUS` ) values (#{name},#{start_time},#{end_time},#{description},1 )")
    int addevent(event event);
}
