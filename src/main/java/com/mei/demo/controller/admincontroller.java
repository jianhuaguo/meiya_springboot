package com.mei.demo.controller;

import com.mei.demo.Domain.admin;
import com.mei.demo.util.Encryption;
import com.mei.demo.Service.adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mei.demo.util.JuheDemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class admincontroller {

    @Autowired
    private adminservice adminservice;


    @CrossOrigin
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public int adminlogin(HttpServletRequest request, @RequestBody Map map) throws Exception
    {

        int id=(Integer)map.get("id");
        String password=(String) map.get("password");
        String real_password=Encryption.MD5(password);
        System.out.println("login:"+real_password);
//        return real_password;
        int countadmin=adminservice.login(id,real_password);
        if(countadmin>0)
        {
            //加入session
            String admin=adminservice.adminnamer(id);
            request.getSession().setAttribute("id",id);
            request.getSession().setAttribute("login","yes");
            request.getSession().setAttribute("admin",admin);
        }

        return countadmin;
    }
    @CrossOrigin
    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    public void adminlogin1(HttpServletRequest request, @RequestBody Map map) throws Exception
    {
        String phone=(String)map.get("phone");
        admin admin=adminservice.selectbyphone(phone);
        request.getSession().setAttribute("id",admin.getId());
        request.getSession().setAttribute("login","yes");
        request.getSession().setAttribute("admin",admin.getName());

    }

    @CrossOrigin
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public int adminloginout(HttpServletRequest request) throws Exception
    {
        HttpSession session=request.getSession();
        session.invalidate();

        return 1;
    }

    @CrossOrigin
    @RequestMapping(value = "/adminname")
    public Map<String,Object> adminname(HttpServletRequest request)
    {
        Map<String,Object> reponsemap=new HashMap<>();
        HttpSession session=request.getSession();
        String admin=(String)session.getAttribute("admin");
        int id=(Integer)session.getAttribute("id");
        reponsemap.put("admin",admin);
        reponsemap.put("id",id);
        return reponsemap;
    }

    @CrossOrigin
    @RequestMapping(value = "/admin/changepassword")
    public int changeadminpassword(@RequestBody Map map)
    {
        int id=(Integer)map.get("id");
        String password=(String) map.get("password");
        String real_password=Encryption.MD5(password);
        System.out.println("change:"+real_password);
        return adminservice.changepassword(id,real_password);
    }

    @CrossOrigin
    @RequestMapping(value = "/admin/phone",method = RequestMethod.POST)
    public int selectphone(@RequestBody Map map)
    {
        String phone=(String)map.get("phone");
        return adminservice.selectphone(phone);
    }


    @CrossOrigin
    @RequestMapping(value = "/admin/yanzheng",method = RequestMethod.POST)
    public String sendcode(@RequestBody Map map)
    {
        String phone=(String)map.get("phone");
        long yanzhengsheng=Math.round(Math.random()*1000000);
        String  yanzheng= yanzhengsheng+"";
        JuheDemo.mobileQuery(phone,yanzheng);

        return yanzheng;


    }
}
