package com.mei.demo.controller;


import com.mei.demo.Domain.Category;

import com.mei.demo.Service.catecoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
public class categorycontroller {

    @Autowired
    private catecoryservice catecoryservice;

    @CrossOrigin
    @RequestMapping(value = "/category/show",method = RequestMethod.GET)
    public ArrayList<Category> categoryinfo(HttpSession session, ModelMap model)
//
    {
        ArrayList<Category> list=new ArrayList<Category>();

        list=catecoryservice.selectname();


        return list;

    }
}
