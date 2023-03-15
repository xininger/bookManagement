package com.aaa.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName t_user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="t_user")
public class User implements Serializable {

    @TableId
    private Integer id;

    private String username;

    private String password;

    private Integer locked;

    private Integer role;
}