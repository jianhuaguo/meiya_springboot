package com.mei.demo.controller;

import com.mei.demo.Algorithm.LeastSquare;
import com.mei.demo.Domain.OrderItem;
import com.mei.demo.Domain.homepage4;
import com.mei.demo.Domain.comment;
import com.mei.demo.Service.orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus.Series;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ordercontroller {

    @Autowired
    private orderservice orderservice;

    //返回某一个月的运营情况
//    具体包括每天的订单总数和销售总额
    @CrossOrigin
    @RequestMapping(value = "/order/chart")
    //默认为当前月 等八月份可改成八月份
    public Map<String,Object> orderchart(Model model, @RequestParam(value = "year_month", defaultValue = "2019-07")String year_month)
    {
        Map<String ,Object> dataMap = new HashMap<>();
        ArrayList<OrderItem> orderItems=new ArrayList<OrderItem>();


        orderItems=orderservice.selectbydate(year_month);



        //传三个数组过去就行了
        int allcount=0;
        double allsum=0;
        double [] sum=new double[31];
        int [] count =new int[31];
        int []data=new int[31];
        for(int i=0;i<31;i++)
            data[i]=i+1;
        for(OrderItem item : orderItems)
        {
            sum[item.getDay()]=item.getSum();
            count[item.getDay()]=item.getCount();
            allcount+=item.getCount();
            allsum+=item.getSum();
        }

        dataMap.put("sum",sum);
        dataMap.put("data",data);
        dataMap.put("count",count);
        dataMap.put("allsum",allsum);
        dataMap.put("allcount",allcount);

//        model.addAttribute("data",data);
//        model.addAttribute("sum",sum);
//        model.addAttribute("count",count);
//        model.addAttribute("allcount",allcount);
//        model.addAttribute("allsum",allsum);
//        Date date = new SimpleDateFormat("yyyy-MM").parse(year_month);
//        String now = new SimpleDateFormat("yyyy年MM月").format(date);
//
//        model.addAttribute("year_month",now);
        return dataMap;
    }

    //对于得到的商家id 返回未来三天关于订单数和订单额度的预测
    @CrossOrigin
    @RequestMapping("/predicted")
    public Map<String,Object> predicted(Model model,@RequestParam(value = "shopid", defaultValue = "1")int shopid)
    {
        Map<String ,Object> dataMap = new HashMap<>();
        ArrayList<OrderItem> orderItems=new ArrayList<OrderItem>();

        orderItems=orderservice.selectrecent(shopid);//最多只取三十天 可能不够三十天的数据
        double [] sum=new double[30];
        double [] count =new double[30];
        double []data=new double[30];
        for(int i=0;i<30;i++)
            data[i]=i+1;
        int j=0;

        int da=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);//取今天是第几天

        int start=(da+31)%30;//开始的日子 忽略了大小月的问题
        for(OrderItem item : orderItems)
        {
            sum[(item.getDay()+31-start)%30]=item.getSum();
            count[(item.getDay()+31-start)%30]=item.getCount();//得到第一个数值，判断下一天有没有数字

//            if(da!=item.getDay())//下一个有数值的不是这天 这天为零 取下一天
//                j++;
//
//            da=item.getDay();
//            if(item.getMonth()==4||item.getMonth()==6||item.getMonth()==9||item.getMonth()==11)
//                da=(da+1)%30;
//            else
//                da=(da+1)%31;
         }

        System.out.println();

        LeastSquare leastSquare=new LeastSquare();
        leastSquare.generateFormula(data,sum,3);//输入日期和
        double[] sum1=new double[3];
        double[] count1=new double[3];
        for(int i=0;i<3;i++)
            sum1[i]=(double)Math.round(leastSquare.calculate(30+i)*100)/100;




        LeastSquare leastSquare1=new LeastSquare();
        leastSquare1.generateFormula(data,count,3);
        for(int i=0;i<3;i++)
            count1[i]=(double)Math.round(leastSquare1.calculate(30+i)*100)/100;

//        model.addAttribute("sum",sum1);
//        model.addAttribute("count",count1);

        dataMap.put("sum",sum1);
        dataMap.put("count",count1);
        return dataMap;
    }

    //主页的第一部分 包括今日销售单数 销售额
//    昨日的销售单数和销售额
    @CrossOrigin()
    @RequestMapping("/homepage1")
    public Map<String,Object> homepage1()
    {
        Map<String ,Object> dataMap = new HashMap<>();
        int todaycount=orderservice.todaycount();
        double todaysum=orderservice.todaysum();
        int yesterdaycount=orderservice.yesterdaycount();
        double yesterdaysum=orderservice.yesterdaysum();

        dataMap.put("todaycount",todaycount);
        dataMap.put("todaysum",todaysum);
        dataMap.put("yesterdaycount",yesterdaycount);
        dataMap.put("yesterdaysum",yesterdaysum);
        return dataMap;
    }

//返回今日各个菜系销售额度最高的商家
    @CrossOrigin
    @RequestMapping(value = "/homepage4")
    public ArrayList<homepage4> homepage4()
    {
        return orderservice.homepage4();
    }

    //返回今日评分最高的前三名商家 参加评比的条件是这一天大于10
    @CrossOrigin
    @RequestMapping(value = "homepage5")
    public ArrayList<comment> homepage5(){
        return orderservice.bestcomment();
    }

    //返回今日评分最低的前三名商家 参加评比的条件是这一天大于10
    @CrossOrigin
    @RequestMapping(value = "homepage6")
    public ArrayList<comment> homepage6(){
        return orderservice.worsecomment();
    }
}
