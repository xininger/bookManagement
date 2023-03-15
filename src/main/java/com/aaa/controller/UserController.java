package com.aaa.controller;

import com.aaa.domain.Book;
import com.aaa.domain.User;
import com.aaa.service.BookService;
import com.aaa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    /**
     * 跳转到首页(登陆页面)
     *
     * @return
     */
    @RequestMapping(value = "/")
    public String login() {
        return "index";
    }

    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping(value = "/toRegister")
    public String toRegister() {
        return "register";
    }



    /**
     * 用户登录
     * 登录表单页面的GET请求处理方法
     * @return
     */
    @RequestMapping("/login")
    public String loginPage() {
        return "index";
    }
    /**
     * 用户登录
     * 接收登录表单提交的POST请求处理方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        log.info("登录进去了!!!");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("得到前端的参数了!!!");

//        调用登录方法
        User user = userService.login(username, password);
        System.out.println(user);
        log.info("调用了登录方法!!!");
//        判断
        if (user != null) {
            log.info("找到用户了");
            request.getSession().setAttribute("loginUser", user.getUsername());
            List<Book> books = bookService.queryAll();
            if (user.getRole() == 0) {
                request.getSession().setAttribute("books",books);
                return "user/dashboard";
            }else {
                request.getSession().setAttribute("books",books);
                return "admin/dashboard";
            }
        } else {
            request.getSession().setAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }



    /**
     * 用户注册
     * 注册表单页面的GET请求处理方法
     * @return
     */
    @RequestMapping("/register")
    public String registPage(){
        return "register";
    }
    /**
     * 用户注册
     * 接收注册表单提交的POST请求处理方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String regist(HttpServletRequest request) {
        log.info("注册进去了!!!");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String resetpw = request.getParameter("resetpw");
        log.info("得到前端的参数了!!!");
//        调用登录方法
        User userByName = userService.findUserByName(username);
        if (userByName != null) {
            request.getSession().setAttribute("rmsg", "用户名已存在!");
            return "register";
        } else {
            if (!password.equals(resetpw)){
                request.getSession().setAttribute("rmsg", "两次密码不一致!");
                return "register";
            }
            userService.regist(username,password);
            request.getSession().setAttribute("rmsg", "注册成功,请点击返回登录!");
            log.info("注册成功了呀!");
            return "index";
        }
    }



    /**
     * 用户退出登录
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }
}

