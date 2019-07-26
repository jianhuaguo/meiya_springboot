package com.mei.demo.Dao;

import com.mei.demo.Domain.storesummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;


@Mapper
public interface storesummarydao {

    //返回指定天数所有商家的日报
    @Select("select max(store_id) as store_id,max(my_store.storename) as storename,max(phone) as storephone,count(*) as ordercount,sum(payment) as ordersum,count(user_id) as usercount "
            +
            " from my_order LEFT JOIN my_store on my_order.store_id=my_store.id " +
            " WHERE  CAST(my_order.payment_time as DATE)= #{orderday} " +
            " GROUP BY store_id ")
    public  ArrayList<storesummary> orderday(String orderday);



    //返回指定月份所有商家的月报
    @Select(" select max(store_id) as store_id,max(my_store.storename) as storename,max(phone) as storephone,count(*) as ordercount,sum(payment) as ordersum,count(user_id) as usercount " +
            " from my_order LEFT JOIN my_store on my_order.store_id=my_store.id " +
            " WHERE date_format(payment_time,'%Y-%m')   = #{ordermonth} " +
            " GROUP BY store_id")
    public  ArrayList<storesummary> ordermonth(String ordermonth);

    //返回指定年份所有商家的年报
    @Select(" select max(store_id) as store_id,max(my_store.storename) as storename,max(phone) as storephone,count(*) as ordercount,sum(payment) as ordersum,count(user_id) as usercount " +
            " from my_order LEFT JOIN my_store on my_order.store_id=my_store.id " +
            " WHERE date_format(payment_time,'%Y')   = #{orderyear} " +
            " GROUP BY store_id")
    public  ArrayList<storesummary> orderyear(String orderyear);


}
