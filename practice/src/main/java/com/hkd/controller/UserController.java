package com.hkd.controller;

import com.hkd.pojo.User;
import com.hkd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/register")
    public String register(String username , String password, String password1, String code,  HttpServletRequest request,HttpSession session){
        //获取验证码
        HttpSession session1 = request.getSession();
        String realCode = (String) session1.getAttribute("realCode");

        if (!code.equals(realCode)){
            return "redirect:/register.jsp";
        }else {
            if (password.equals(password1)) {
                userService.register(username,password);
               return "redirect:/login.jsp";

            }else{
                return "redirect:/register.jsp";
            }
        }

    }

    @RequestMapping("/login")
    public String login(String username,String password,String code,HttpServletRequest request,HttpSession session){


        HttpSession session1 = request.getSession();
        String realCode = (String) session1.getAttribute("realCode");


        if (!code.equals(realCode)){
            return "redirect:login.jsp";
        }else {
            User login = userService.login(username, password);
            session1.setAttribute("username",username);
            if (login == null){
                return "redirect:register.jsp";
            }else {
                return "redirect:/product/selectAllProducts.do";
            }
        }
      }
}
