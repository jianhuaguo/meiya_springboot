package com.mei.demo.Service;

import com.mei.demo.Domain.storesummary;
import com.mei.demo.Dao.storesummarydao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class storesummaryservice {

    @Autowired
    private  storesummarydao storesummarydao;

    public  ArrayList<storesummary> orderday(String orderday)
    {
        return storesummarydao.orderday(orderday);
    }

    public ArrayList<storesummary> ordermonth(String ordermonth)
    {
        return storesummarydao.ordermonth(ordermonth);
    }

    public  ArrayList<storesummary> orderyear(String orderyear)
    {
        return storesummarydao.orderyear(orderyear);
    }

}
