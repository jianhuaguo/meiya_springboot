package com.mei.demo.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mei.demo.Domain.Store;
import com.mei.demo.Service.impl.storeservice;
import com.mei.demo.Service.storeservice_in;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class storecontroller {

    @Autowired
    private storeservice storeservice;

    /*
    返回商家列表
    包括了分页功能和搜索框功能
     */
    @CrossOrigin
    @RequestMapping(value = "/store/show",method = RequestMethod.POST)
    public Map<String,Object> storeinfo(@RequestBody Map map) throws Exception
//   public String storeinfo(HttpSession session, ModelMap model,  @RequestParam(value = "pn", defaultValue = "1") Integer pageNum)
    {
        String name=(String)map.get("searchname");
        int pageNum=(Integer)map.get("currentPage");
        //pagenum当前的页 5是写死的每页固定大小
        ArrayList<Store> list=new ArrayList<Store>();
        Page<Store> page=PageHelper.startPage(pageNum,5);

        list=storeservice.selectbyname(name);


        Map<String, Object> map_send= new HashMap<String, Object>();
        map_send.put("storedata",page);
        map_send.put("number",page.getTotal());
        map_send.put("name",name);
        return map_send;

    }
    //添加用户 跳转到详情
    @RequestMapping(value = "/store/add")
    public String addstore()
    {
        return "storeadd";
    }

    @RequestMapping(value = "/store/edit/id={id}")
    public String editstore(@PathVariable("id")int id,Model model)
    {
        Store store=storeservice.selectbyid(id);

        model.addAttribute("store",store);

        return "storedetail";
    }
    @RequestMapping(value = "/store/delete/id={id}")
    public String deletestore(@PathVariable("id")int id,Model model)
    {
        storeservice.delete(id);

        ArrayList<Store> list=new ArrayList<Store>();
        PageHelper.startPage(1,1);
        list=storeservice.selectAll();
        PageInfo pageInfo=new PageInfo<>(list,1);
        model.addAttribute("storelist",pageInfo);


        return "storeshow";
    }

    //添加商家
    @CrossOrigin
    @RequestMapping(value = "/store/added",method = RequestMethod.POST)
    public int addedstore(@RequestBody Store store)
    {
        Store newstore=store;

        int suc=storeservice.insertstore(newstore);


        return suc;
    }


    //更新完跳转到所有商家的页面
    @CrossOrigin
    @RequestMapping(value="/store/edited",method = RequestMethod.POST)
    public int editedstore(@RequestBody Store store)
    {

        Store newstore=store;

        int statu=storeservice.update(newstore);

       // ArrayList<Store> list=new ArrayList<Store>();
        //PageHelper.startPage(1,1);
        //list=storeservice.selectAll();
//        PageInfo pageInfo=new PageInfo<>(list,1);
       // model.addAttribute("storelist",pageInfo);

        return statu;
    }

    //更新某一个商家的状态 包括冻结和解冻
    @CrossOrigin
    @RequestMapping(value="/store/changestatus/{id}",method = RequestMethod.PUT)
    public int changestore(@PathVariable("id")int id)
    {
        return  storeservice.updatestatus(id);
    }


    //统计商家的大概情况 包括注册商家 运营商家和这个月注册的商家
    @CrossOrigin
    @RequestMapping(value = "/homepage2")
    public Map<String,Object> homepage2()
    {
        Map dateMap2=new HashMap();
        int monthstore=storeservice.monthstore();
        int freestore=storeservice.freestore();
        int unfreestore=storeservice.unfreestore();
        int countstore=storeservice.countstore();

        dateMap2.put("monthstore",monthstore);
        dateMap2.put("freestore",freestore);
        dateMap2.put("unfreestore",unfreestore);
        dateMap2.put("countstore",countstore);

        return dateMap2;
    }

    //在预测之前 对输入的商家id先进行判断 看数据库中是否有这个商家
    @CrossOrigin
    @RequestMapping(value = "/predicted/selectbyid",method = RequestMethod.POST)
    public int selectcountbyid(@RequestBody Map map)
    {
        int id=Integer.parseInt((String)map.get("id"));
       int number= storeservice.selectcountbyid(id);
       System.out.println(number);
       return number;
    }
}
