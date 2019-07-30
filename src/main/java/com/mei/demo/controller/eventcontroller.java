package com.mei.demo.controller;

import com.mei.demo.Domain.seckillexamine;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mei.demo.Domain.Store;
import com.mei.demo.Domain.event;
import com.mei.demo.Service.eventservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class eventcontroller {

    @Autowired
    private eventservice eventservice;


    //获得所有秒杀活动 加上关键词搜索功能
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

    //添加秒杀活动
    @CrossOrigin
    @RequestMapping(value = "/seckill/add",method = RequestMethod.POST)
    public int addedstore(@RequestBody event event)
    {
        event newevent=event;

        int suc=eventservice.addevent(newevent);

        return suc;
    }

    //编辑秒杀活动 主要是题目 开始时间 结束时间和具体描述
    @CrossOrigin
    @RequestMapping(value="/event/edited",method = RequestMethod.POST)
    public int editedevent(@RequestBody event event)
    {

        event newevent=event;

        int statu=eventservice.updateevent(event);

        return statu;
    }

    //删除一个活动
    @CrossOrigin
    @RequestMapping(value = "/event/delete",method = RequestMethod.POST)
    public int deleteevent(@RequestBody Map  map)
    {
        int id=(Integer)map.get("id");
        return eventservice.deleteevent(id);
    }

    //上线或者下线一个秒杀活动
    @CrossOrigin
    @RequestMapping(value = "/event/changestatus",method = RequestMethod.POST)
    public int updatestatus(@RequestBody Map map)
    {
        int id=(Integer)map.get("id");
        int status=(Integer)map.get("status");
        return eventservice.updateeventstatus(status,id);
    }

    //选择结束时间还没到的秒杀活动 对秒杀活动进行审核
    @CrossOrigin
    @RequestMapping(value = "/event/future",method=RequestMethod.GET)
    public ArrayList<event> selectfuture()
    {
        ArrayList<event> list=new ArrayList<event>();
         list=eventservice.selectfutureevent();
        return list;
    }

    //返回选择了活动id的秒杀活动
    @CrossOrigin
    @RequestMapping(value="/event/selectid",method = RequestMethod.POST)
    public ArrayList<event> selectid(@RequestBody Map map)
    {
        ArrayList<event> event=new ArrayList<event>();
        int id=(Integer)map.get("id");
        event=eventservice.selecteventbyid(id);
        return event;
    }

    //返回参加某一场秒杀活动的所有食物
    @CrossOrigin
    @RequestMapping(value = "/event/foods",method = RequestMethod.POST)
    public ArrayList<seckillexamine> selectfood(@RequestBody Map map)
    {
        int id=(Integer)map.get("id");
        ArrayList<seckillexamine> secfoods=new ArrayList<seckillexamine>();
        secfoods=eventservice.selectsecfood(id);

        return  secfoods;

    }


    //审核参加秒杀活动的食物
    @CrossOrigin
    @RequestMapping(value = "/events/updatefoodstatus",method = RequestMethod.POST)
    public int updatefoodstatus(@RequestBody Map map)
    {
        int id=(Integer)map.get("id");
        return eventservice.updatesecfoodstatus(id);

    }
}
