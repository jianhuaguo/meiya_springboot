package com.mei.demo.Service;

import com.mei.demo.Domain.Order;
import com.mei.demo.Domain.comment;
import com.mei.demo.Domain.homepage4;
import org.springframework.beans.factory.annotation.Autowired;
import com.mei.demo.Domain.OrderItem;
import org.springframework.stereotype.Service;
import com.mei.demo.Dao.orderdao;

import java.util.ArrayList;
import java.util.Date;

@Service
public class orderservice {

    @Autowired
    private orderdao orderdao;

    public ArrayList<OrderItem> selectbydate(String year_month)
    {
        return orderdao.selectbydate(year_month);
    }
    //返回最近三十天某商家的订单数和订单金额的对象
    public  ArrayList<OrderItem> selectrecent(int shopid)
    {
        return orderdao.selectrecent(shopid);
    }

    public double todaysum()
    {
        return orderdao.todaysum();
    }
    public double yesterdaysum()
    {
        return orderdao.yesterdaysum();
    }
    public int todaycount()
    {
        return orderdao.todaycount();
    }
    public int yesterdaycount()
    {
        return orderdao.yesterdaycount();
    }

    public ArrayList<homepage4> homepage4()
    {
        return orderdao.homepage4();
    }

    public ArrayList<comment> bestcomment()
    {
        return orderdao.bestcomment();
    }

    public ArrayList<comment> worsecomment()
    {
        return orderdao.worstcomment();
    }

    public ArrayList<Order> allorder(String store_id,String user_id)
    {
       return orderdao.allorder(store_id, user_id);
    }
}
