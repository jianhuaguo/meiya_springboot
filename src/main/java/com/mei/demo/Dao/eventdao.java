package com.mei.demo.Dao;

import com.mei.demo.Domain.event;
import com.mei.demo.Domain.seckillexamine;

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

    @Delete("delete from my_events where id= #{id}")
    int delectevent(int id);


    @Update("UPDATE my_events SET `status`= #{status} where id= #{id}")
    int updateeventstatus (int status,int id);


    //还没到结束时间的才可以审核
    @Select("select * from my_events where now()<end_time")
    public ArrayList<event> selectfutureevent();


    @Select("select * from my_events where id= #{id}")
    public ArrayList<event> selecteventbyid(int id);


    @Select("SELECT my_seckill.id as seckillid,my_foods.photo_url as photo, seckill_price,my_foods.name " +
            " from  my_seckill left join my_foods on my_foods.id=my_seckill.goods_id WHERE my_seckill.`status`=0 and events_id=#{id}")
    public ArrayList<seckillexamine> selectsecfood(int id);


    @Update("update my_seckill set `status`=1 where id= #{id}")
    public int updatestatus(int id);

}
