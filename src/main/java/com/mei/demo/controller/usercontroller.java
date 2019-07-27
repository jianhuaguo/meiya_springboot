package com.mei.demo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mei.demo.Domain.Store;
import com.mei.demo.Domain.User;
import com.mei.demo.Service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class usercontroller {

    @Autowired
    private userservice userservice;

    @CrossOrigin
    @RequestMapping(value = "/user/show",method = RequestMethod.POST)
    public Map<String,Object> usershow(@RequestBody Map map)
    {
        int pageNum=(Integer)map.get("currentPage");
        String name=(String)map.get("searchname");
        //pagenum当前的页 1是写死的每页固定大小
        ArrayList<User> list=new ArrayList<User>();
        Page<Store> page=PageHelper.startPage(pageNum,5);
        //list=userservice.selectall();
        list=userservice.selectbyname(name);
        Map<String, Object> map_send= new HashMap<String, Object>();
        map_send.put("userdata",page);
        map_send.put("number",page.getTotal());
        return map_send;
    }

    @CrossOrigin
    @RequestMapping("/user/update")
    public int updatauser(@RequestBody User user)
    {
        return userservice.updateuser(user);
    }

    @CrossOrigin
    @RequestMapping(value = "/user/changestatus/{id}",method = RequestMethod.PUT)
    public int updatestatus(@PathVariable("id")int id)
    {
        return userservice.updatestatu(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/homepage3")
    public Map<String,Object> homepage3()
    {
        Map<String,Object> datemap=new HashMap<>();
        int todayuser=userservice.todayuser();
        int yesterdayuser=userservice.yesterdayuser();
        int monthuser=userservice.monthuser();
        int countuser=userservice.countuser();
        datemap.put("todayuser",todayuser);
        datemap.put("yesterdayuser",yesterdayuser);
        datemap.put("monthuser",monthuser);
        datemap.put("countuser",countuser);

        return datemap;
    }

    @CrossOrigin
    @RequestMapping(value = "/batchinsert")
    public int  batchinsert(@RequestBody Map map)
    {
        List<User> users=(List<User>) map.get("users");//强行类型转换

        //返回成功插入多少条数据
        return userservice.batchinsert(users);
    }
}
