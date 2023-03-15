package com.aaa.service;

import com.aaa.domain.Book;
import com.aaa.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Dear Zhang
* @description 针对表【t_user】的数据库操作Service
* @createDate 2023-03-10 11:30:25
*/
public interface UserService extends IService<User>{
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);

    /**
     * 根据姓名查询用户
     * @param username
     * @return
     */
    User findUserByName(@Param("username") String username);

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    int regist(@Param("username") String username,@Param("password") String password);

}
