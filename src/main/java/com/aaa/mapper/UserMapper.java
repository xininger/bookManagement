package com.aaa.mapper;

import com.aaa.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
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


}
