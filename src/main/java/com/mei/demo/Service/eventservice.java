package com.mei.demo.Service;

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
}
