package com.aaa.controller;

import com.aaa.domain.User;
import com.aaa.mapper.UserMapper;
import com.aaa.service.UserService;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String toUserInfo(HttpServletRequest request) {
        List<User> users = userService.selectAllUser();
        System.out.println(users);
        request.getSession().setAttribute("users",users);
        return "admin/userinfo";
    }

}
