package com.mei.demo.Web;


import com.mei.demo.Domain.admin;
import com.mei.demo.Service.adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class adminlogin{
    private adminservice adminservice;

    @RequestMapping(value = {"/","/index.html"})
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

//    @RequestMapping(value = "/loginCheck.html")
//    public ModelAndView loginCheck(HttpServletRequest request,logincommand loginCommand){
//        boolean isValidUser =  adminservice.hasMatchUser(loginCommand.getUserName(),
//                loginCommand.getPassword());
//        if (!isValidUser) {
//            return new ModelAndView("login", "error", "用户名或密码错误。");
//        } else {
//            //直接进入主页面
//            return new ModelAndView("main");
//        }
//    }

    @Autowired
    public void setUserService(adminservice adminservice) {
        this.adminservice=adminservice;
    }
}
