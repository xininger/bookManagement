package com.aaa.mapper;

import com.aaa.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Dear Zhang
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-03-10 11:30:25
* @Entity generator.domain.TUser
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll();

    Long countAll();

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    User login(@Param("username") String username,@Param("password") String password);

    /**
     * 根据名字查询用户
     *      当注册的名字存在,注册失败,否则注册成功
     * @param username
     * @return
     */
    User findUserByName(@Param("username") String username);

    /**
     * 注册方法
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
     * 添加用户
     * @param user
     * @return
     */
    int addOne(User user);

    /**
     * 根据用户状态查询用户
     * @param locked
     * @return
     */
    List<User> queryByLocked(@Param("locked") int locked);

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
