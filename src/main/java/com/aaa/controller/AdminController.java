package com.aaa.controller;

import com.aaa.domain.User;
import com.aaa.service.UserService;
import com.aaa.util.MyToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到用户管理
     * @param request
     * @return
     */
    @RequestMapping("/user")
    public String toUserInfo(HttpServletRequest request) {
        List<User> users = userService.selectAllUser();
        log.info("查询用户 显示数据{}", MyToolUtil.objToJson(users));
        request.getSession().setAttribute("users",users);
        return "admin/userinfo";
    }

    /**
     * 显示所有用户
     * @param request
     * @return
     */
    @RequestMapping("/showAllUser")
    public String showAllUser(HttpServletRequest request) {
        List<User> users = userService.selectAllUser();
        request.getSession().setAttribute("users",users);
        return "admin/userinfo";
    }

    /**
     * 通过id搜索用户
     * @param request
     * @return
     */
    @RequestMapping("/searchById")
    public String searchById(HttpServletRequest request) {
        String id = request.getParameter("id");
        List<User> users = userService.queryAllById(Integer.parseInt(id));
        log.info("根据id查询用户 显示数据{}",MyToolUtil.objToJson(users));
        request.getSession().setAttribute("users",users);
        return "admin/userinfo";
    }


    /**
     * 通过姓名搜索用户
     * @param request
     * @return
     */
    @RequestMapping("/searchByName")
    public String searchByName(HttpServletRequest request) {
        String username = request.getParameter("username");
        List<User> users = userService.queryAllByUsername(username);
        log.info("根据姓名查询用户 显示数据{}",MyToolUtil.objToJson(users));
        request.getSession().setAttribute("users",users);
        return "admin/userinfo";
    }

    /**
     * 根据状态搜索用户
     * @param request
     * @return
     */
    @RequestMapping("/searchByLocked")
    public String searchByLocked(HttpServletRequest request) {
        String locked = request.getParameter("locked");
        List<User> users = userService.queryByLocked(Integer.valueOf(locked));
        request.getSession().setAttribute("users",users);
        if (users == null) {
            log.info("没有查询到用户,请重新输入正确的信息!");
            return "admin/userinfo";
        }else {
            log.info("根据状态查询到了用户 users={}",MyToolUtil.objToJson(users));
            return "admin/userinfo";
        }
    }

    /**
     * 跳转到添加用户页面
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAddUser() {
        return "admin/addUser";
    }

    /**
     * 添加用户
     * 添加图书页面的GET请求处理方法
     * @return
     */
    @RequestMapping("/addUser")
    public String addUserPage() {
        return "admin/addUser";
    }

    /**
     * 添加用户 接收表单提交的post请求方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String locked = request.getParameter("locked");
        String role = request.getParameter("role");
        log.info("添加用户 username={},password={},status={},role={}",username,password,locked,role);

        if (MyToolUtil.checkEmpty(username,"username",request) || MyToolUtil.checkEmpty(password,"password",request)
        || MyToolUtil.checkEmpty(locked,"locked",request) || MyToolUtil.checkEmpty(role,"role",request)) {
            return "admin/addUser";
        }
//        判断是否存在该用户
        User getUser = userService.findUserByName(username);
        if (getUser != null) {
            log.info("username={} 存在数据",username);
            request.getSession().setAttribute("umsg","该用户已存在!");
            return "admin/addUser";
        }else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setLocked(Integer.valueOf(locked));
            user.setRole(Integer.valueOf(role));
            userService.addOne(user);
            log.info("添加用户 写入数据{}",MyToolUtil.objToJson(user));
            List<User> users = userService.selectAllUser();
            request.getSession().setAttribute("users",users);
            return "admin/userinfo";
        }
    }

    /**
     * 跳转到修改用户页面
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/updateUser/{id}")
    public String toUpdateUser(@PathVariable("id") Integer id,HttpServletRequest request) {
        User user = userService.findById(id);
        log.info("user={}",MyToolUtil.objToJson(user));
        request.getSession().setAttribute("user",user);
        return "admin/updateUser";
    }

    /**
     * 修改用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(User user,HttpServletRequest request) {
        log.info("修改用户 id={},user={}", user.getId(), MyToolUtil.objToJson(user));
        User findOne = userService.findById(user.getId());
        if (MyToolUtil.checkEmpty(findOne, "根据" + user.getId() + "没有找到此用户", request)) {
            log.error("根据 id={} 查询无果", user.getId());
            return "admin/userinfo";
        }
        userService.updateUser(user);
        log.info("修改用户成功user={}", user);
        List<User> users = userService.selectAllUser();
        request.getSession().setAttribute("users",users);
        return "admin/userinfo";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id,HttpServletRequest request) {
        log.info("删除用户 id={}",id);
        userService.deleteUser(id);
        log.info("用户id={}删除成功",id);
        List<User> users = userService.selectAllUser();
        request.getSession().setAttribute("users",users);
        return "admin/userinfo";
    }
}
