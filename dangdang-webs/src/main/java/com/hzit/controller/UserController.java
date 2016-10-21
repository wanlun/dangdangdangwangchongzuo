package com.hzit.controller;

import com.hzit.services.Userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/10/9.
 */
@Controller
public class UserController {
    @Autowired
    private Userservices userservices;
   /* 这个是处理登录的方法*/
     @RequestMapping("/dengkluchenggong")
    public  String login(String userName,String passWord,HttpSession session){
           try{
               int i=userservices.findUesr(userName,passWord);
               if (i==1){
                     session.setAttribute("username",userName);
                   return "redirect:/controller/findbook";
               }else{
                   return "redirect:login.html";
               }
           }catch (Exception ex){
               ex.printStackTrace();
               return "redirect:login.html";
           }

     }


}
