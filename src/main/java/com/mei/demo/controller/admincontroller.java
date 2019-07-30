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

    //管理员 根据账号和密码登录
    @CrossOrigin
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public int adminlogin(HttpServletRequest request, @RequestBody Map map) throws Exception
    {

        int id=(Integer)map.get("id");
        String password=(String) map.get("password");
        String real_password=Encryption.MD5(password);
        System.out.println("login:"+real_password);

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

    //通过手机号获得管理的姓名和编号
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

    //管理员登出 session失效
    @CrossOrigin
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public int adminloginout(HttpServletRequest request) throws Exception
    {
        HttpSession session=request.getSession();
        session.invalidate();

        return 1;
    }

    //从session中读取管理员的名字 一直挂在页面的上头
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

    //管理员的修改密码
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

    //判断手机号登录的时候 这个手机号在数据库中有没有注册
    @CrossOrigin
    @RequestMapping(value = "/admin/phone",method = RequestMethod.POST)
    public int selectphone(@RequestBody Map map)
    {
        String phone=(String)map.get("phone");
        return adminservice.selectphone(phone);
    }


    //前端发来发送验证码的请求 这边向聚合数据发出验证码请求 并向前端送出验证码进行匹配
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
