package com.mei.demo.controller;

import com.mei.demo.Domain.storesummary;
import com.mei.demo.Service.storesummaryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class storesummarycontroller {

    @Autowired
    private storesummaryservice storesummaryservice;

    //返回各个商家的某一日的日报
    @CrossOrigin
    @RequestMapping(value = "/storesummary/day")
    public  ArrayList<storesummary> orderday(@RequestBody Map map)
    {
        String orderday=(String)map.get("orderday");
        return storesummaryservice.orderday(orderday);
    }

    //返回某一个商家某一月的月报
    @CrossOrigin
    @RequestMapping(value = "/storesummary/month")
    public  ArrayList<storesummary> ordermonth(@RequestBody Map map)
    {
        String ordermonth=(String)map.get("ordermonth");
        return storesummaryservice.ordermonth(ordermonth);
    }

    //返回某一商家某一年的年报
    @CrossOrigin
    @RequestMapping(value = "/storesummary/year")
    public  ArrayList<storesummary> orderyear(@RequestBody Map map)
    {
        String orderyear=(String)map.get("orderyear");
        return storesummaryservice.orderyear(orderyear);
    }
}
