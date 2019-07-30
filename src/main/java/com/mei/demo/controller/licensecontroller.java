package com.mei.demo.controller;

import com.mei.demo.Domain.license;
import com.mei.demo.Service.licenseservice;

import net.sf.jsqlparser.statement.select.Select;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class licensecontroller {

    @Autowired
    private licenseservice licenseservice;

    //选择审核或者未审核的商家列表
    @CrossOrigin
    @RequestMapping(value = "/store/license",method = RequestMethod.POST)
    public ArrayList<license> selectlicense(@RequestBody Map map)throws Exception
    {
        String statu1=(String)map.get("status");
        int status=Integer.valueOf(statu1);

      return licenseservice.selectlicense(status);
    }

    //商家通过审核
    @CrossOrigin
    @RequestMapping(value = "/store/passlicense")
    public int passlicense(@RequestBody Map map)
    {
        int id=(Integer)map.get("id");
        return licenseservice.passlicense(id);
    }

    //拒绝商家通过审核
    @CrossOrigin
    @RequestMapping(value = "/store/unpasslicense")
    public int unpasslicense(@RequestBody Map map)
    {
        int id=(Integer)map.get("id");
        return licenseservice.unpasslicense(id);
    }
}
