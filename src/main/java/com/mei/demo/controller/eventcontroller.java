package com.mei.demo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mei.demo.Domain.Store;
import com.mei.demo.Domain.event;
import com.mei.demo.Service.eventservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class eventcontroller {

    @Autowired
    private eventservice eventservice;


    @CrossOrigin
    @RequestMapping(value = "seckill/selectall",method = RequestMethod.POST)
    public Map<String,Object> selectallevent(@RequestBody Map map)
    {

        String name=(String)map.get("searchname");
        int pageNum=(Integer)map.get("currentPage");
        int pagesize=(Integer)map.get("pagesize");
        Page<event> page= PageHelper.startPage(pageNum,pagesize);
        ArrayList<event> eventdata=eventservice.selectallevent(name);

        Map<String, Object> map_send= new HashMap<String, Object>();
        map_send.put("eventsdata",page);
        map_send.put("number",page.getTotal());

        return map_send;
    }

    @CrossOrigin
    @RequestMapping(value = "/seckill/add",method = RequestMethod.POST)
    public int addedstore(@RequestBody event event)
    {
        event newevent=event;

        int suc=eventservice.addevent(newevent);

        return suc;
    }

    @CrossOrigin
    @RequestMapping(value="/event/edited",method = RequestMethod.POST)
    public int editedevent(@RequestBody event event)
    {

        event newevent=event;

        int statu=eventservice.updateevent(event);

        return statu;
    }
}
