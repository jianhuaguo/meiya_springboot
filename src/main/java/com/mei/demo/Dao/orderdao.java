package com.mei.demo.Dao;


import com.mei.demo.Domain.Order;
import com.mei.demo.Domain.homepage4;
import com.mei.demo.Domain.OrderItem;
import com.mei.demo.Domain.comment;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface orderdao {

    //返回两个时间之间的每一天的订单数和金额
    @Select("select YEAR(payment_time) as year,MONTH(payment_time) as month,day(payment_time) as day,count(payment) as count,SUM(payment) as sum from my_order  WHERE date_format(payment_time,'%Y-%m')   = #{year_month}   GROUP BY  YEAR(payment_time),MONTH(payment_time),day(payment_time)")
    ArrayList<OrderItem> selectbydate(String year_month);

    @Select("select day(payment_time) as day,sum(payment) as sum,COUNT(payment) as count , min(payment_time) as tim from my_order where date_sub(curdate(), INTERVAL 30 DAY) <= date(payment_time) and store_id= #{shop_id} GROUP BY day(payment_time) order by tim")
    ArrayList<OrderItem> selectrecent(int shop_id);


    //返回今天订单总数
    @Select("SELECT count(*) FROM my_order where  CAST(my_order.payment_time as DATE)=CAST(NOW() as date)")
    int todaycount();

    //返回今天总金额
    @Select("SELECT IFNULL(sum(payment),0) FROM my_order where  CAST(my_order.payment_time as DATE)=CAST(NOW() as date)")
    double todaysum();

    //返回昨天总金额
    @Select("SELECT IFNULL(sum(payment),0) FROM my_order where  CAST(my_order.payment_time as DATE)=date_add(curdate(), interval -1 day)")
    double yesterdaysum();


    //返回昨日订单总数
    @Select("SELECT count(payment) FROM my_order where  CAST(my_order.payment_time as DATE)=date_add(curdate(), interval -1 day)")
    int yesterdaycount();


    //返回今日各个菜系销售额度最高的商家
    @Select("SELECT max(sumpay) as sumpay,max(storename) as storename,max(count) as countpay,(SELECT name FROM my_category where categoryid=my_category.id) as categoryname " +
            " from " +
            " (SELECT my_store.id as storeid,my_store.storename as storename,sum(my_order.payment) as sumpay,my_store.category_id as categoryid,count(payment) as count from my_order LEFT JOIN my_store on  my_order.store_id=my_store.id " +
            " WHERE  CAST(my_order.payment_time as DATE)=CAST(NOW() as date) " +
            " GROUP BY my_store.id) " +
            " as newtable " + " GROUP BY " +
            " categoryid " + " ORDER BY " + " max(sumpay) desc ")
    public ArrayList<homepage4> homepage4();

    //返回今日最受好评的前三名商家 同时最少订单要超过十单
    @Select("select " +
            " storename,avg(score) as score,count(score) as count FROM my_comment LEFT JOIN my_store on my_comment.sid=my_store.id  " +
            " where CAST(my_comment.create_time as DATE) =CAST(NOW() as date) " +
            " GROUP BY sid  " +
            " HAVING COUNT(score)>1 " +
            " order by avg(Score) desc LIMIT 0,3")
    public ArrayList<comment> bestcomment();


    //返回今日最受差评的前三名商家 同时最少订单要超过十单
    @Select("select  " +
            "storename,avg(score) as score,count(score) as count FROM my_comment LEFT JOIN my_store on my_comment.sid=my_store.id  " +
            "where CAST(my_comment.create_time as DATE) =CAST(NOW() as date) " +
            "GROUP BY sid  " +
            "HAVING COUNT(score)>1 " +
            "order by avg(Score) asc LIMIT 0,3")
    public ArrayList<comment> worstcomment();


    @Select("select * from my_order where  store_id =#{store_id}  or user_id =#{user_id}  or  if(( #{store_id} ='' and #{user_id} = '' ),'1','0') ")
    public ArrayList<Order> allorder(String store_id,String user_id);

}
