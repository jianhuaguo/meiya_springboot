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

    @CrossOrigin
    @RequestMapping(value = "/storesummary/day")
    public  ArrayList<storesummary> orderday(@RequestBody Map map)
    {
        String orderday=(String)map.get("orderday");
        return storesummaryservice.orderday(orderday);
    }

    @CrossOrigin
    @RequestMapping(value = "/storesummary/month")
    public  ArrayList<storesummary> ordermonth(@RequestBody Map map)
    {
        String ordermonth=(String)map.get("ordermonth");
        return storesummaryservice.ordermonth(ordermonth);
    }

    @CrossOrigin
    @RequestMapping(value = "/storesummary/year")
    public  ArrayList<storesummary> orderyear(@RequestBody Map map)
    {
        String orderyear=(String)map.get("orderyear");
        return storesummaryservice.orderyear(orderyear);
    }
}
