package com.mei.demo.Service;

import com.mei.demo.Domain.eventsummary;
import com.mei.demo.Domain.seckillexamine;
import com.mei.demo.Domain.event;
import com.mei.demo.Dao.eventdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class eventservice {

    @Autowired
    private eventdao eventdao;

    public ArrayList<event> selectallevent(String name)
    {
        return eventdao.selectallevent(name);
    }

    public int addevent(event event)
    {
        return eventdao.addevent(event);
    }

    public int updateevent(event event)
    {
        return eventdao.updateevent(event);
    }

    public int deleteevent(int id)
    {
        return eventdao.delectevent(id);
    }

    public int updateeventstatus(int status,int id)
    {
        return eventdao.updateeventstatus(status,id);
    }

    public ArrayList<event> selectfutureevent()
    {
        return eventdao.selectfutureevent();
    }

    public ArrayList<event> selecteventbyid(int id)
    {
        return eventdao.selecteventbyid(id);
    }

    //返回某一场秒杀的产品
    public ArrayList<seckillexamine> selectsecfood(int id)
    {
        return eventdao.selectsecfood(id);
    }

    public int updatesecfoodstatus(int id)
    {
        return eventdao.updatestatus(id);
    }

    public ArrayList<eventsummary> eventsumma()
    {
        return eventdao.eventsummary();
    }
}
