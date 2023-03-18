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


    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUser();

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    List<User> queryAllById(@Param("id") int id);

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    List<User> queryAllByUsername(@Param("username") String username);

    /**
     * 根据用户状态查询用户
     * @param locked
     * @return
     */
    List<User> queryByLocked(@Param("locked") int locked);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addOne(User user);

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    User findById(@Param("id") Integer id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(@Param("id") Integer id);
    int updateLoginUserById(User user);

}
